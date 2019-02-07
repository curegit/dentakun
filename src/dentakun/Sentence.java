package dentakun;
import dentakun.Calculator;
import dentakun.Element;
import dentakun.elements.symbols.Kazu;
import dentakun.elements.symbols.KakkoStart;
import dentakun.elements.symbols.KakkoEnd;
import dentakun.elements.symbols.Point;
import dentakun.elements.symbols.Comma;
import dentakun.elements.symbols.Equal;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Function;
import dentakun.elements.evaluables.operators.PreUnary;
import dentakun.elements.evaluables.operators.PostUnary;
import dentakun.elements.evaluables.operators.Binary;
import dentakun.elements.evaluables.operators.Multiply;
import dentakun.elements.evaluables.value.Real;
import dentakun.elements.evaluables.Variable;
import dentakun.elements.evaluables.SpecialVariable;
import dentakun.elements.evaluables.Const;
import dentakun.elements.evaluables.Assignment;
import dentakun.exceptions.ParseError;
import java.util.List;
import java.util.ArrayList;

// ユーザが入力する文（数式）
// ボタン入力ごとにここに要素が追加される
public class Sentence {

	private ArrayList<Element> sentence; // 文
	private int pointer; // カーソル位置

	// コンストラクタ
	public Sentence () {
		sentence = new ArrayList<Element>();
		pointer = 0;
	}

	// 要素を追加
	public void add (Element element) {
		reset();
		sentence.add(pointer, element);
		pointer++;
		Calculator.ui.screen.setIn(toString());
	}

	// 要素を削除
	public void delete () {
		if (pointer > 0) {
			sentence.remove(pointer - 1);
			pointer--;
			Calculator.ui.screen.setIn(toString());
		}
		Calculator.ui.screen.setOut("");
	}

	// クリア
	public void clear () {
		sentence.clear();
		pointer = 0;
		Calculator.ui.screen.setIn(toString());
		Calculator.ui.screen.setOut("");
	}

	// カーソルを左に
	public void left () {
		reset();
		if (pointer > 0) {
			pointer--;
			Calculator.ui.screen.setIn(toString());
		}
	}

	// カーソルを左端に
	public void leftSide () {
		reset();
		pointer = 0;
		Calculator.ui.screen.setIn(toString());
	}

	// カーソルを右に
	public void right () {
		reset();
		if (sentence.size() > pointer) {
			pointer++;
			Calculator.ui.screen.setIn(toString());
		}
	}

	// カーソルを右端に
	public void rightSide () {
		reset();
		pointer = sentence.size();
		Calculator.ui.screen.setIn(toString());
	}

	// 文字列へ変換
	public String toString () {
		String str = "";
		for (int i = 0; i <= sentence.size(); i++) {
			if (i == pointer) {
				str += "|";
			}
			if (i < sentence.size()) {
				str += sentence.get(i).toString();
			}
		}
		return str;
	}

	// 式が変更されたときのイコールの除去と結果のクリア
	public void reset () {
		if (sentence.size() > 0 && sentence.get(sentence.size() - 1) instanceof Equal) {
			delete();
			Calculator.ui.screen.setOut("");
		}
	}

	// 再帰的に構文解析を行い式木を構成する（外部呼び出し部分）
	@SuppressWarnings("unchecked")
	public Evaluable parse () {
		// 式を複写する
		ArrayList<Element> sentence = (ArrayList<Element>)this.sentence.clone();
		int len = sentence.size();
		// =========ノードの前回の引数参照をリセットする=========
		for (int i = 0; i < len; i++) {
			if (sentence.get(i) instanceof Evaluable) {
				((Evaluable)sentence.get(i)).reset();
			}
		}
		// =========先頭、最後尾の括弧の自動補完=========
		// 括弧の数を調べる
		int depth = 0;
		for (int i = 0; i < len; i++) {
			if (sentence.get(i) instanceof KakkoStart || sentence.get(i) instanceof Function) {
				depth++;
			} else if (sentence.get(i) instanceof KakkoEnd) {
				depth--;
			}
		}
		// 数が一致しなければ追加する
		if (depth > 0) {
			for (int i = 0; i < depth; i++) {
				sentence.add(new KakkoEnd());
			}
		} else if (depth < 0) {
			for (int i = 0; i < -depth; i++) {
				sentence.add(0, new KakkoStart());
			}
		}
		// 再帰にかけて結果を返す
		return parse(sentence);
	}

	// 再帰的に構文解析を行い式木を構成する（再帰部分）
	private Evaluable parse (List<Element> s) {
		// =========最も優先度の低い演算部分で式を二分する=========
		int len = s.size();
		int depth = 0;
		int top = 0;
		for (int i = 0; i < len; i++) {
			if (s.get(i) instanceof KakkoStart || s.get(i) instanceof Function) {
				if (depth == 0) {
					if (s.get(i).priority <= s.get(top).priority) {
						top = i;
					}
				}
				depth++;
			} else if (s.get(i) instanceof KakkoEnd) {
				depth--;
			} else {
				if (depth == 0) {
					if (s.get(i).priority <= s.get(top).priority) {
						top = i;
					}
				}
			}
		}
		Element target = s.get(top);

		// =========それぞれの要素の種類に応じて頂点を追加して再帰する=========
		// イコールのとき
		if (target instanceof Equal) {
			return parse(s.subList(0, top));
		// 代入のとき
		} else if (target instanceof Assignment) {
			// 代入記号の左に変数があり、変数の左にはなにもないことを確認
			if (!(s.get(0) instanceof Variable) || top != 1) {
				throw new ParseError();
			}
			// 代入先と代入式を設定
			Variable v = (Variable)s.get(0);
			Assignment ass = (Assignment)target;
			ass.add(parse(s.subList(top + 1, len)));
			ass.setDestination(v.i);
			return ass;
		// 二項演算子
		} else if (target instanceof Binary) {
			Binary b = (Binary)target;
			b.add(parse(s.subList(0, top)));
			b.add(parse(s.subList(top + 1, len)));
			return b;
		// 前置単項演算子
		} else if (target instanceof PreUnary) {
			PreUnary u = (PreUnary)target;
			// 演算子の前になにかあるとエラー
			if (top != 0) {
				// ただし、前置単項演算子は前においてもいい
				for (int j = top - 1; j >= 0; j--) {
					if (!(s.get(j) instanceof PreUnary)) {
						throw new ParseError();
					}
				}
				PreUnary head = (PreUnary)s.get(0);
				head.add(parse(s.subList(1, len)));
				return head;
			} else {
				u.add(parse(s.subList(top + 1, len)));
				return u;
			}
		// 後置単項演算子
		} else if (target instanceof PostUnary) {
			PostUnary u = (PostUnary)target;
			// 演算子の後になにかあるとエラー
			if (top != len - 1) {
				throw new ParseError();
			} else {
				u.add(parse(s.subList(0, top)));
				return u;
			}
		// 関数のとき
		} else if (target instanceof Function) {
			Function f = (Function)target;
			// 括弧が閉じていることを確認
			if (top != 0 || !(s.get(len - 1) instanceof KakkoEnd)) {
				throw new ParseError();
			}
			// コンマで分割して引数として追加
			int i, j;
			int d = 0; // 括弧の深さ
			for (i = 1, j = 1; i < len - 1; i++) {
				if (s.get(i) instanceof Comma && d == 0) {
					f.add(parse(s.subList(j, i)));
					j = i + 1;
				} else if (s.get(i) instanceof KakkoStart || s.get(i) instanceof Function) {
					d++;
				} else if (s.get(i) instanceof KakkoEnd) {
					d--;
				}
			}
			f.add(parse(s.subList(j, i)));
			return f;
		// 括弧のとき
		} else if (target instanceof KakkoStart) {
			// 括弧が閉じていることを確認
			if (top != 0 || !(s.get(len - 1) instanceof KakkoEnd)) {
				throw new ParseError();
			}
			return parse(s.subList(1, len - 1));
		// 変数のとき
		} else if (target instanceof Variable) {
			Variable v = (Variable)target;
			// この要素単独のとき
			if (len == 1) {
				return v;
			// 前に何もないとき（掛け算と解釈）
			} else if (top == 0) {
				Multiply m = new Multiply();
				m.add(v);
				m.add(parse(s.subList(top + 1, len)));
				return m;
			// 後ろに何もないとき（掛け算と解釈）
			} else if (top == len - 1) {
				Multiply m = new Multiply();
				m.add(parse(s.subList(0, top)));
				m.add(v);
				return m;
			// 前にも後ろにも他の要素があるとき（掛け算と解釈）
			} else {
				Multiply m1 = new Multiply();
				m1.add(v);
				m1.add(parse(s.subList(top + 1, len)));
				Multiply m2 = new Multiply();
				m2.add(parse(s.subList(0, top)));
				m2.add(m1);
				return m2;
			}
		// 特殊変数のとき
		} else if (target instanceof SpecialVariable) {
			SpecialVariable sv = (SpecialVariable)target;
			// この要素単独のとき
			if (len == 1) {
				return sv;
			// 前に何もないとき（掛け算と解釈）
			} else if (top == 0) {
				Multiply m = new Multiply();
				m.add(sv);
				m.add(parse(s.subList(top + 1, len)));
				return m;
			// 後ろに何もないとき（掛け算と解釈）
			} else if (top == len - 1) {
				Multiply m = new Multiply();
				m.add(parse(s.subList(0, top)));
				m.add(sv);
				return m;
			// 前にも後ろにも他の要素があるとき（掛け算と解釈）
			} else {
				Multiply m1 = new Multiply();
				m1.add(sv);
				m1.add(parse(s.subList(top + 1, len)));
				Multiply m2 = new Multiply();
				m2.add(parse(s.subList(0, top)));
				m2.add(m1);
				return m2;
			}
		// 定数のとき
		} else if (target instanceof Const) {
			Const c = (Const)target;
			// この要素単独のとき
			if (len == 1) {
				return c;
			// 前に何もないとき（掛け算と解釈）
			} else if (top == 0) {
				Multiply m = new Multiply();
				m.add(c);
				m.add(parse(s.subList(top + 1, len)));
				return m;
			// 後ろに何もないとき（掛け算と解釈）
			} else if (top == len - 1) {
				Multiply m = new Multiply();
				m.add(parse(s.subList(0, top)));
				m.add(c);
				return m;
			// 前にも後ろにも他の要素があるとき（掛け算と解釈）
			} else {
				Multiply m1 = new Multiply();
				m1.add(c);
				m1.add(parse(s.subList(top + 1, len)));
				Multiply m2 = new Multiply();
				m2.add(parse(s.subList(0, top)));
				m2.add(m1);
				return m2;
			}
		// 数字のとき
		} else if (target instanceof Kazu || target instanceof Point) {
			String str = "";
			for (int i = 0; i < len; i++) {
				str += s.get(i).toString();
			}
			return new Real(Double.parseDouble(str));
		// 残りは許されない例外
		} else {
			throw new ParseError();
		}
	}
}

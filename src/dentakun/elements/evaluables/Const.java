package dentakun.elements.evaluables;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.UnknownError;

// 定数を表す要素のクラス
// インスタンスの作成はコンストラクタでなくあらかじめ用意したメソッドで行う
public class Const extends Evaluable {

	private String syn; // 表記
	private Value value; // 値

	// インスタンスの作成を禁じる
	private Const (String s, Value v) {
		syn = s;
		value = v;
		priority = 80;
	}

	// 子を追加する
	public void add (Evaluable e) {
		// 値クラスは子ノードを持たないので常にエラー
		throw new UnknownError();
	}

	// 子をリセットする
	public void reset () {
		// 子を持たないのでなにもしない
	}

	// 値を返す
	public Value evaluate () {
		return value;
	}
	
	// 表記を返す
	public String toString () {
		return syn;
	}

	// 円周率を表すインスタンスを作成する
	public static Const Pi () {
		return new Const("π", new Real(Math.PI));
	}

	// ネイピア数を表すインスタンスを作成する
	public static Const E () {
		return new Const("e", new Real(Math.E));
	}

	// 正の無限大を表すインスタンスを作成する
	public static Const Infinity () {
		return new Const("∞", new Real(Double.POSITIVE_INFINITY));
	}
}

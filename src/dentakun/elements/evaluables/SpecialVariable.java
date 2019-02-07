package dentakun.elements.evaluables;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Value;

// 特殊変数のクラス
// 積分などで対象になる変数のこと
// 積分などの開始時に値を挿入して、終わったら無効化して使えなくしておく
// すなわち積分などでない場所で呼び出すとエラーになる
public class SpecialVariable extends Evaluable {

	// 各変数の値
	public static Value variables[] = new Value[6];
	// 各変数の表記
	public static String syn[] = {"x", "y", "z", "i", "j", "k"};

	public int i; // 参照番号

	// コンストラクタ
	public SpecialVariable (int i) {
		this.i = i;
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
		return variables[i];
	}

	// 表記を返す
	public String toString () {
		return syn[i];
	}

	// すべての特殊変数を無効化する
	public static void init () {
		for (int i = 0; i < 6; i++) {
			variables[i] = null;
		}
	}

	// 特殊変数を無効化する
	public static void init (int i) {
		variables[i] = null;
	}
}

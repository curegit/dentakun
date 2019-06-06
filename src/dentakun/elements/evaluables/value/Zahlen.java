package dentakun.elements.evaluables.value;
import dentakun.elements.evaluables.Value;

// 整数のクラス
// 自然数を入力とする関数などのときに実数クラスからこのクラスに変換される
public class Zahlen extends Value {

	public static final long serialVersionUID = 102L; // シリアライズ用バージョン定数

	private long n; // 値

	// コンストラクタ
	public Zahlen (long n) {
		this.n = n;
	}

	// 値を取得
	public long getN () {
		return n;
	}

	// 整数に変換（オーバーライド）
	public Zahlen toZahlen () {
		return this;
	}

	// 実数に変換（オーバーライド）
	public Real toReal () {
		return new Real((double)n);
	}

	// 文字列に変換（オーバーライド）
	public String toString () {
		return "" + n;
	}
}

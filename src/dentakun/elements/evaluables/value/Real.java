package dentakun.elements.evaluables.value;
import dentakun.elements.evaluables.Value;
import dentakun.exceptions.RangeExceeded;
import dentakun.exceptions.InvalidNarrowingConversion;

// 実数のクラス
// 大部分の計算で用いられる
// 小数点以下を持たなければ整数に縮小できる
public class Real extends Value {
	
	public static final long serialVersionUID = 102L; // シリアライズ用バージョン定数

	private double x; // 値
	
	// コンストラクタ
	public Real (double x) {
		this.x = x;
	}

	// 値を取得
	public double getX () {
		return x;
	}

	// 整数に変換（オーバーライド）
	public Zahlen toZahlen () {
		// longの有効範囲外のとき
		if (x < Long.MIN_VALUE || x > Long.MAX_VALUE) {
			throw new RangeExceeded();
		// 縮小できないとき
		} else if (Double.compare(x, Math.round(x)) != 0) {
			throw new InvalidNarrowingConversion();
		// 成功
		} else {
			return new Zahlen(Math.round(x));
		}
	}

	// 実数に変換（オーバーライド）
	public Real toReal () {
		return this;
	}

	// 表記を取得（オーバーライド）
	public String toString () {
		return "" + x;
	}
}

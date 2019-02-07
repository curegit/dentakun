package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.RangeExceeded;
import dentakun.exceptions.InvalidOperation;

// 階乗演算子のクラス
public class Factorial extends PostUnary {

	// コンストラクタ
	public Factorial () {
		priority = 0;
	}

	// 評価する
	public Value evaluate () {
		// オペランドが整数か確認
		long s = a.evaluate().toZahlen().getN();
		// 自然数か確認
		if (s < 0) {
			throw new InvalidOperation();
		}
		// 演算する
		try {
			return new Zahlen(fact(s));
		} catch (Exception e) {
			throw new RangeExceeded();
		}
	}

	// 表記を取得
	public String toString () {
		return "!";
	}

	// 階乗を計算する
	private static long fact(long n) {
		long out = 1;
		for (long i = 0; i < n; i++) {
			out = Math.multiplyExact(out, Math.subtractExact(n, i));
		}
		return out;
	}
}

package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.RangeExceeded;
import dentakun.exceptions.InvalidOperation;

// 順列演算子のクラス
public class Permutation extends Binary {

	// コンストラクタ
	public Permutation () {
		priority = -5;
	}

	// 評価する
	public Value evaluate () {
		// オペランドが整数か確認
		long s = a.evaluate().toZahlen().getN();
		long t = b.evaluate().toZahlen().getN();
		// 自然数か確認
		if (s < 0 || t < 0) {
			throw new InvalidOperation();
		}
		// n >= kを確認
		if (s < t) {
			throw new InvalidOperation();
		}
		// 演算する
		try {
			return new Zahlen(perm(s, t));
		} catch (Exception e) {
			throw new RangeExceeded();
		}
	}

	// 表記を取得
	public String toString () {
		return "P";
	}

	// 順列を計算する
	private static long perm(long n, long k) {
		long out = 1;
		for (long i = 0; i < k; i++) {
			out = Math.multiplyExact(out, Math.subtractExact(n, i));
		}
		return out;
	}
}

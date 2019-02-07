package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.RangeExceeded;
import dentakun.exceptions.InvalidOperation;

// 組み合わせ演算子のクラス
public class Combination extends Binary {

	// コンストラクタ
	public Combination () {
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
			return new Zahlen(comb(s, t));
		} catch (Exception e) {
			throw new RangeExceeded();
		}
	}

	// 表記を取得
	public String toString () {
		return "C";
	}

	// 組み合わせを計算する
	private static long comb(long n, long k) {
		long out = 1;
		for (long i = 0; i < k; i++) {
			out = Math.multiplyExact(out, Math.subtractExact(n, i)) / Math.addExact(i, 1);
		}
		return out;
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.InvalidOperation;
import dentakun.exceptions.RangeExceeded;

// 最小公倍数関数
public class Lcm extends Function2 {

	// 評価する
	public Value evaluate () {
		// 整数型を要求
		long x = a.evaluate().toZahlen().getN();
		long y = b.evaluate().toZahlen().getN();
		// 自然数であることを確認
		if (x < 1 || y < 1) {
			throw new InvalidOperation();
		}
		// 最大公約数から算出する
		try {
			return new Zahlen(Math.multiplyExact(x, y) / euclidean(x, y) );
		} catch (Exception e) {
			throw new RangeExceeded();
		}
	}

	// 表記を取得
	public String toString () {
		return "lcm(";
	}

	// ユークリッドの互除法
	private long euclidean (long x, long y) {
		if (y == 0) {
			return x;
		} else {
			return euclidean(y, x % y);
		}
	}
}

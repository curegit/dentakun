package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.InvalidOperation;

// 最大公約数関数
public class Gcd extends Function2 {

	// 評価する
	public Value evaluate () {
		// 整数型を要求
		long x = a.evaluate().toZahlen().getN();
		long y = b.evaluate().toZahlen().getN();
		// 自然数であることを確かめる
		if (x < 1 || y < 1) {
			throw new InvalidOperation();
		}
		// ユークリッドの互除法を適用
		return new Zahlen(euclidean(x, y));
	}

	// 表記を取得
	public String toString () {
		return "gcd(";
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

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.RangeExceeded;

// 床関数
public class Floor extends Function1 {

	// 評価する
	public Value evaluate () {
		double x = a.evaluate().toReal().getX();
		// longの有効範囲外のとき
		if (x < Long.MIN_VALUE || x > Long.MAX_VALUE) {
			throw new RangeExceeded();
		}
		return new Zahlen((long)Math.floor(x));
	}

	// 表記を取得
	public String toString () {
		return "floor(";
	}
}

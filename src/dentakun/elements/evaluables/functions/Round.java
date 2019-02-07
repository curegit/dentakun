package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.RangeExceeded;

// 四捨五入
public class Round extends Function1 {

	// 評価する
	public Value evaluate () {
		double x = a.evaluate().toReal().getX();
		// longの有効範囲外のとき
		if (x < Long.MIN_VALUE || x > Long.MAX_VALUE) {
			throw new RangeExceeded();
		}
		// 演算して返す
		return new Zahlen(Math.round(x));
	}

	// 表記を取得
	public String toString () {
		return "round(";
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.InvalidOperation;

// 0以上x未満の乱数を返す
public class Range extends Function1 {

	// 評価する
	public Value evaluate () {
		double max = a.evaluate().toReal().getX();
		if (max < 0) {
			throw new InvalidOperation();
		}
		return new Real(Math.random() * max);
	}

	// 表記を取得
	public String toString () {
		return "range(";
	}
}

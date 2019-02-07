package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.InvalidOperation;

// 平均関数
public class Avg extends FunctionV {

	// 評価する
	public Value evaluate () {
		// 要素が一つ以上である必要がある
		if (list.size() < 1) {
			throw new InvalidOperation();
		}
		// 平均を求める
		double s = 0.0;
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i).evaluate().toReal().getX();
		}
		return new Real(s / list.size());
	}

	// 表記を取得
	public String toString () {
		return "avg(";
	}
}

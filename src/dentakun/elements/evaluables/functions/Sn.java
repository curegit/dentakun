package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.InvalidOperation;

// 標本標準偏差
public class Sn extends FunctionV {

	// 評価する
	public Value evaluate () {
		// 要素が一つ以上必要
		if (list.size() < 1) {
			throw new InvalidOperation();
		}
		// 平均を求める
		double s = 0.0;
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i).evaluate().toReal().getX();
		}
		double avg = s / list.size();
		// 標準偏差を求める
		double sv = 0.0;
		for (int i = 0; i < list.size(); i++) {
			sv += Math.pow(list.get(i).evaluate().toReal().getX() - avg, 2);
		}
		return new Real(Math.sqrt(sv / (list.size() - 1)));
	}

	// 表記を取得
	public String toString () {
		return "sn(";
	}
}

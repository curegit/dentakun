package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.InvalidOperation;

// 逆双曲線正接関数
public class Atanh extends Function1 {

	// 評価する
	public Value evaluate () {
		double x = a.evaluate().toReal().getX();
		// 定義域にあるか確認
		if (x <= -1 || x >= 1) {
			throw new InvalidOperation();
		}
		// 計算する
		return new Real(Math.log((1 + x) / (1 - x)) / 2);
	}

	// 表記を取得
	public String toString () {
		return "atanh(";
	}
}

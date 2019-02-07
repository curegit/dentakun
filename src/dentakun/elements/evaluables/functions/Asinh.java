package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 逆双曲線正弦関数
public class Asinh extends Function1 {

	// 評価する
	public Value evaluate () {
		double x = a.evaluate().toReal().getX();
		return new Real(Math.log(x + Math.sqrt(x * x + 1)));
	}

	// 表記を取得
	public String toString () {
		return "asinh(";
	}
}

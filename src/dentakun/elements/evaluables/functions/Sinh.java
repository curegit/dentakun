package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 双曲線正弦関数
public class Sinh extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.sinh(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "sinh(";
	}
}

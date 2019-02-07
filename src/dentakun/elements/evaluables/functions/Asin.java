package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 逆正弦関数
public class Asin extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.asin(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "asin(";
	}
}

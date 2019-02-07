package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 自然対数関数
public class Ln extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.log(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "ln(";
	}
}

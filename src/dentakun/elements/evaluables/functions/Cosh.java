package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 双曲線余弦関数
public class Cosh extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.cosh(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "cosh(";
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 正接関数
public class Tan extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.tan(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "tan(";
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 符号関数
public class Sgn extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.signum(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "sgn(";
	}
}

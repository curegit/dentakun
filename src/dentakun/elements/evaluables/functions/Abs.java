package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 絶対値関数
public class Abs extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.abs(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "abs(";
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 正弦関数
public class Sin extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.sin(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "sin(";
	}
}

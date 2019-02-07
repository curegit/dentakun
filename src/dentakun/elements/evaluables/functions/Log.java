package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 任意底の対数関数
public class Log extends Function2 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.log(b.evaluate().toReal().getX())/Math.log(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "log(";
	}
}

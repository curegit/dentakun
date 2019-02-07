package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 常用対数関数
public class Log10 extends Function1 {

	// 評価する
	public Value evaluate () {
		return new Real(Math.log10(a.evaluate().toReal().getX()));
	}

	// 表記を取得
	public String toString () {
		return "log10(";
	}
}

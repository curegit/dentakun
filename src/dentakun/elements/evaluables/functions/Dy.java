package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.elements.evaluables.SpecialVariable;

// yについて微分係数を求める関数
public class Dy extends Function2 {

	private final double dy = Math.pow(2, -25); // 微小区間

	// 評価する
	public Value evaluate () {
		// 微分する場所（第二引数）を求める
		double h = b.evaluate().toReal().getX();
		// 微小区間下側を求める
		double x1 = h - dy;
		SpecialVariable.variables[1] = new Real(x1);
		double y1 = a.evaluate().toReal().getX();
		SpecialVariable.init(1);
		// 微小区間上側を求める
		double x2 = h + dy;
		SpecialVariable.variables[1] = new Real(x2);
		double y2 = a.evaluate().toReal().getX();
		SpecialVariable.init(1);
		// 微分係数を求める
		return new Real( (y2 - y1) / dy / 2 );
	}

	// 表記を返す
	public String toString () {
		return "d/dy(";
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.elements.evaluables.SpecialVariable;

// xについて微分係数を求める関数
public class Dx extends Function2 {

	private final double dx = Math.pow(2, -25); // 微小区間

	// 評価する
	public Value evaluate () {
		// 微分する場所（第二引数）を求める
		double h = b.evaluate().toReal().getX();
		// 微小区間下側を求める
		double x1 = h - dx;
		SpecialVariable.variables[0] = new Real(x1);
		double y1 = a.evaluate().toReal().getX();
		SpecialVariable.init(0);
		// 微小区間上側を求める
		double x2 = h + dx;
		SpecialVariable.variables[0] = new Real(x2);
		double y2 = a.evaluate().toReal().getX();
		SpecialVariable.init(0);
		// 微分係数を求める
		return new Real( (y2 - y1) / dx / 2 );
	}

	// 表記を返す
	public String toString () {
		return "d/dx(";
	}
}

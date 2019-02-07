package dentakun.elements.evaluables.functions;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.elements.evaluables.SpecialVariable;

// yについて定積分を求める関数
public class Iy extends Function3 {

	private final int spans = 100; // 合成シンプソン公式での分割数

	// 評価する
	public Value evaluate () {
		// 始点と終点を算出
		double s = b.evaluate().toReal().getX();
		double f = c.evaluate().toReal().getX();
		// 合成シンプソン公式を適用
		return new Real(compositeSimpson(a, s, f));
	}

	// 表記を返す
	public String toString () {
		return "∫y(";
	}

	// シンプソンの公式
	private double simpson (Evaluable f, double a, double b) {
		SpecialVariable.variables[1] = new Real(a);
		double fa = f.evaluate().toReal().getX();
		SpecialVariable.variables[1] = new Real((a + b) / 2);
		double fab = f.evaluate().toReal().getX();
		SpecialVariable.variables[1] = new Real(b);
		double fb = f.evaluate().toReal().getX();
		SpecialVariable.init(1);
		return (b - a) / 6 * (fa + 4 * fab + fb);
	}

	// 合成シンプソンの公式
	private double compositeSimpson (Evaluable f, double a, double b) {
		double sum = 0.0;
		for (int i = 0; i < spans; i++) {
			sum += simpson(f, ((spans - i) * a + i * b) / spans, ((spans - i - 1) * a + (i + 1) * b) / spans);
		}
		return sum;
	}
}

package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.elements.evaluables.SpecialVariable;
import dentakun.exceptions.InvalidOperation;

// iについての数列の総和を求める
public class Sigmai extends Function3 {

	// 評価する
	public Value evaluate () {
		// 始点と終点を算出
		long s = b.evaluate().toZahlen().getN();
		long f = c.evaluate().toZahlen().getN();
		// 終点と始点の関係を確認
		if (f < s) {
			throw new InvalidOperation();
		}
		// 演算する
		double out = 0;
		for (long i = s; i <= f; i++) {
			SpecialVariable.variables[3] = new Zahlen(i);
			out += a.evaluate().toReal().getX();
			SpecialVariable.init(3);
		}
		return new Real(out);
	}

	// 表記を返す
	public String toString () {
		return "Σi(";
	}
}

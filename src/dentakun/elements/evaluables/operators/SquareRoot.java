package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 平方根演算子
public class SquareRoot extends PreUnary {

	// コンストラクタ
	public SquareRoot () {
		priority = 0;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		// 演算する
		return new Real(Math.sqrt(s.getX()));
	}

	// 表記を取得
	public String toString () {
		return "√";
	}
}

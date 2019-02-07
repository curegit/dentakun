package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 符号反転演算子
public class Negative extends PreUnary {

	// コンストラクタ
	public Negative () {
		priority = 20;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		// 符号反転する
		return new Real(-s.getX());
	}

	// 表記を取得
	public String toString () {
		return "-";
	}
}

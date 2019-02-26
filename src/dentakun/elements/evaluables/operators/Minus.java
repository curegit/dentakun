package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 減算演算子
public class Minus extends Binary {

	// コンストラクタ
	public Minus () {
		priority = -20;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		Real t = b.evaluate().toReal();
		// 減算する
		return new Real(s.getX() - t.getX());
	}

	// 表記を取得
	public String toString () {
		return "−";
	}
}

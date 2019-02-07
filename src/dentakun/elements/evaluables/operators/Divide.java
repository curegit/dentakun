package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 除算演算子
public class Divide extends Binary {

	// コンストラクタ
	public Divide () {
		priority = -10;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		Real t = b.evaluate().toReal();
		// 除算する
		return new Real(s.getX() / t.getX());
	}

	// 表記を取得
	public String toString () {
		return "÷";
	}
}

package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 加算演算子
public class Plus extends Binary {

	// コンストラクタ
	public Plus () {
		priority = -20;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		Real t = b.evaluate().toReal();
		// 加算する
		return new Real(s.getX() + t.getX());
	}

	// 表記を取得
	public String toString () {
		return "+";
	}
}

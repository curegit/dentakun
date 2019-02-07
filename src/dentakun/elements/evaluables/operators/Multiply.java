package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 乗法演算子
public class Multiply extends Binary {

	// コンストラクタ
	public Multiply () {
		priority = -10;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		Real t = b.evaluate().toReal();
		// 乗算する
		return new Real(s.getX() * t.getX());
	}

	// 表記を取得
	public String toString () {
		return "×";
	}
}

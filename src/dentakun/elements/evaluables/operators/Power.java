package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;

// 指数演算子
public class Power extends Binary {

	// コンストラクタ
	public Power () {
		priority = 0;
	}

	// 評価する
	public Value evaluate () {
		// 子要素を計算する
		Real s = a.evaluate().toReal();
		Real t = b.evaluate().toReal();
		// 指数演算する
		return new Real(Math.pow(s.getX(), t.getX()));
	}

	// 表記を取得
	public String toString () {
		return "^";
	}
}

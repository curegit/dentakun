package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;

// 等確率でaまたはbを返す関数
public class Coin extends Function2 {

	// 評価する
	public Value evaluate () {
		if (Math.random() < 0.5) {
			return a.evaluate();
		} else {
			return b.evaluate();
		}
	}

	// 表記を取得
	public String toString () {
		return "coin(";
	}
}

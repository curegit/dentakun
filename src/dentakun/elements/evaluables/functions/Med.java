package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.InvalidOperation;

// 中央値関数
public class Med extends FunctionV {

	// 評価する
	public Value evaluate () {
		// 要素が一つ以上必要
		if (list.size() < 1) {
			throw new InvalidOperation();
		}
		// ソートする
		list.sort((a, b) -> Double.compare(a.evaluate().toReal().getX(), b.evaluate().toReal().getX()));
		// 要素が偶数個の場合
		if (list.size() % 2 == 0) {
			return new Real((list.get(list.size() / 2 - 1).evaluate().toReal().getX() + list.get(list.size() / 2).evaluate().toReal().getX() ) / 2);
		// 要素が奇数個の場合
		} else {
			return list.get(list.size() / 2).evaluate();
		}
	}

	// 表記を取得
	public String toString () {
		return "med(";
	}
}

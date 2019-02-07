package dentakun.elements.evaluables.functions;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.exceptions.InvalidOperation;

// 1からNまでの数を等確率で返す乱数関数
public class Dice extends Function1 {

	// 評価する
	public Value evaluate () {
		// 整数型を要求
		long max = a.evaluate().toZahlen().getN();
		// maxが1以上である必要がある
		if (max < 1) {
			throw new InvalidOperation();
		}
		return new Zahlen((long)(Math.random() * max) + 1);
	}

	// 表記を取得
	public String toString () {
		return "dice(";
	}
}

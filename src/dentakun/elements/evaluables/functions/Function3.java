package dentakun.elements.evaluables.functions;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Function;
import dentakun.exceptions.InvalidOperation;

// 引数が3つの関数
// 積分関数などがこれを継承する
public abstract class Function3 extends Function {

	protected Evaluable a; // 引数1
	protected Evaluable b; // 引数2
	protected Evaluable c; // 引数3

	// 子を追加する
	public void add (Evaluable e) {
		if (a == null) {
			a = e;
		} else if (b == null) {
			b = e;
		} else if (c == null) {
			c = e;
		} else {
			throw new InvalidOperation();
		}
	}

	// 子をリセットする
	public void reset () {
		a = null;
		b = null;
		c = null;
	}

	// 引数を検査する
	public void validate () {
		if (a == null || b == null || c == null) {
			throw new InvalidOperation();
		}
	}
}

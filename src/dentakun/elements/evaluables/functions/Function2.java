package dentakun.elements.evaluables.functions;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Function;
import dentakun.exceptions.InvalidOperation;

// 引数が2つの関数
// 任意底の対数関数などがこれを継承する
public abstract class Function2 extends Function {

	protected Evaluable a; // 引数1
	protected Evaluable b; // 引数2

	// 子を追加する
	public void add (Evaluable e) {
		if (a == null) {
			a = e;
		} else if (b == null) {
			b = e;
		} else {
			throw new InvalidOperation();
		}
	}

	// 子をリセットする
	public void reset () {
		a = null;
		b = null;
	}

	// 引数を検査する
	public void validate () {
		if (a == null || b == null) {
			throw new InvalidOperation();
		}
	}
}

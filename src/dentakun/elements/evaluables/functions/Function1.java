package dentakun.elements.evaluables.functions;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Function;
import dentakun.exceptions.InvalidOperation;

// 引数が1つの関数
// 三角関数などがこれを継承する
public abstract class Function1 extends Function {

	protected Evaluable a; // 引数

	// 子を追加する
	public void add (Evaluable e) {
		if (a == null) {
			a = e;
		} else {
			throw new InvalidOperation();
		}
	}

	// 子をリセットする
	public void reset () {
		a = null;
	}

	// 引数を検査する
	public void validate () {
		if (a == null) {
			throw new InvalidOperation();
		}
	}
}

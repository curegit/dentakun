package dentakun.elements.evaluables.operators;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Operator;
import dentakun.exceptions.UnknownError;

// 二項演算子のクラス
// 加算、乗算演算子などがこれを継承する
public abstract class Binary extends Operator {

	protected Evaluable a; // 左オペランド
	protected Evaluable b; // 右オペランド

	// 子を追加する
	public final void add (Evaluable e) {
		if (a == null) {
			a = e;
		} else if (b == null) {
			b = e;
		} else {
			throw new UnknownError();
		}
	}

	// 子をリセットする
	public final void reset () {
		a = null;
		b = null;
	}
}

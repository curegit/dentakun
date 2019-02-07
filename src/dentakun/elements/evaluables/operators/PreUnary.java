package dentakun.elements.evaluables.operators;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Operator;
import dentakun.exceptions.UnknownError;

// 前置単項演算子のクラス
public abstract class PreUnary extends Operator {

	protected Evaluable a; // オペランド

	// 子を追加する
	public final void add (Evaluable e) {
		if (a == null) {
			a = e;
		} else {
			throw new UnknownError();
		}
	}

	// 子をリセットする
	public final void reset () {
		a = null;
	}
}

package dentakun.elements;
import dentakun.Element;
import dentakun.elements.evaluables.Value;

// 評価可能な式木の頂点
// 入力した式を解析するときに、これらを頂点とする木を構成する
// 計算するときは再帰的に木をたどればよい
public abstract class Evaluable extends Element {

	// 子を追加する
	public abstract void add (Evaluable e);

	// 子をリセットする
	public abstract void reset ();

	// 評価する
	public abstract Value evaluate ();

	// 引数の検査をする
	public void validate () { }
}

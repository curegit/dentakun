package dentakun.elements.evaluables;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Variable;
import dentakun.elements.evaluables.Value;
import dentakun.exceptions.UnknownError;

// 代入演算を行う記号
public class Assignment extends Evaluable {

	private Evaluable a; // 子ノード
	private int i = -1; // 代入先

	// コンストラクタ
	public Assignment () {
		priority = -80;
	}

	// 子ノードを追加する
	public void add (Evaluable e) {
		if (a == null) {
			a = e;
		} else {
			throw new UnknownError();
		}
	}

	// 代入先を指定する
	public void setDestination (int i) {
		this.i = i;
	}

	// 子ノードを破棄する
	public void reset () {
		a = null;
		i = -1;
	}

	// 演算する
	public Value evaluate () {
		Value v = a.evaluate();
		Variable.variables[i] = v;
		return v;
	}
	
	// 表記を返す
	public String toString () {
		return "←";
	}
}

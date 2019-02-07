package dentakun.elements.evaluables.functions;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Function;
import java.util.ArrayList;

// 可変長引数関数
// 平均、標準偏差関数などがこれを継承する
public abstract class FunctionV extends Function {

	protected ArrayList<Evaluable> list; // 引数リスト

	// コンストラクタ
	public FunctionV () {
		list = new ArrayList<Evaluable>();
	}

	// 子を追加する
	public void add (Evaluable e) {
		list.add(e);
	}

	// 子をリセットする
	public void reset () {
		list = new ArrayList<Evaluable>();
	}

	// 引数を検査する
	public void validate () { }
}

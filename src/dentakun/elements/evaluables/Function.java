package dentakun.elements.evaluables;
import dentakun.elements.Evaluable;

// 関数のクラス
// 各関数はこのクラスを継承する
public abstract class Function extends Evaluable {
	
	// 優先度
	public Function () {
		priority = 50;
	}

	// 引数を検査する
	public abstract void validate ();
}

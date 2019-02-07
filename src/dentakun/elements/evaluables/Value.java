package dentakun.elements.evaluables;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.value.Zahlen;
import dentakun.elements.evaluables.value.Real;
import dentakun.exceptions.UnknownError;
import java.io.Serializable;

// 値の抽象クラス
public abstract class Value extends Evaluable implements Serializable {
	
	public static final long serialVersionUID = 102L; // シリアライズ用バージョン定数

	// 子を追加する（オーバーライド）
	public final void add (Evaluable e) {
		// 値クラスは子ノードを持たないので常にエラー
		throw new UnknownError();
	}

	// 子をリセットする（オーバーライド）
	public void reset () {
		// 子を持たないのでなにもしない
	}

	// 値を評価する（オーバーライド）
	public Value evaluate () {
		return this;
	}

	// 整数に変換
	public abstract Zahlen toZahlen ();

	// 実数に変換
	public abstract Real toReal ();
}

package dentakun;

// 式文の構成要素
// 関数、演算子、定数などはすべてこれを継承する
public abstract class Element {

	// 演算優先度
	public int priority = 0;

	// 文字列での表記を取得する
	public abstract String toString();
}

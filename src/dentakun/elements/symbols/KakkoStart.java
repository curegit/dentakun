package dentakun.elements.symbols;
import dentakun.elements.Symbol;

// 式で括弧はじめを表すインスタンスを作成するクラス
public class KakkoStart extends Symbol {

	// コンストラクタ
	public KakkoStart () {
		priority = 50;
	}

	// 表記を返す
	public String toString () {
		return "(";
	}
}

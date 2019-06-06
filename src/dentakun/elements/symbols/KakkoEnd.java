package dentakun.elements.symbols;
import dentakun.elements.Symbol;

// 式で括弧終わりを表すインスタンスを作成するクラス
public class KakkoEnd extends Symbol {

	// コンストラクタ
	public KakkoEnd () {
		priority = 60;
	}

	// 表記を返す
	public String toString () {
		return ")";
	}
}

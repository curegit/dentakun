package dentakun.elements.symbols;
import dentakun.elements.Symbol;

// 式で小数点を表すインスタンスを作成するクラス
public class Point extends Symbol {

	// コンストラクタ
	public Point () {
		priority = 100;
	}

	// 表記を返す
	public String toString () {
		return ".";
	}
}

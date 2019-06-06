package dentakun.elements.symbols;
import dentakun.elements.Symbol;

// 式でコンマを表すインスタンスを作成するクラス
public class Comma extends Symbol {

	// コンストラクタ
	public Comma () {
		priority = 50;
	}

	// 表記を返す
	public String toString () {
		return ",";
	}
}

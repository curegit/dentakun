package dentakun.elements.symbols;
import dentakun.elements.Symbol;

// 式でイコール記号を表すインスタンスをつくるクラス
// イコールは計算実行時に末尾に付与されるだけであり、特に意味は持たない
public class Equal extends Symbol {

	// コンストラクタ
	public Equal () {
		priority = -100;
	}
	
	// 表記を返す
	public String toString () {
		return "=";
	}
}

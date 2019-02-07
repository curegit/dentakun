package dentakun.elements.symbols;
import dentakun.elements.Symbol;

// 式で数字を表すインスタンスを作成するクラス
// FactoryMethodパターンによって決められた形(0-9)のインスタンスのみ作成を許す
public class Kazu extends Symbol {

	private final String number; // 数の表記

	// コンストラクタ
	private Kazu (String number) {
		this.number = number;
		priority = 100;
	}

	// 表記を返す
	public String toString () {
		return number;
	}

	// 各数字を作るFactoryMethod
	public static Kazu One () {
		return new Kazu("1");
	}

	public static Kazu Two () {
		return new Kazu("2");
	}

	public static Kazu Three () {
		return new Kazu("3");
	}

	public static Kazu Four () {
		return new Kazu("4");
	}

	public static Kazu Five () {
		return new Kazu("5");
	}

	public static Kazu Six () {
		return new Kazu("6");
	}

	public static Kazu Seven () {
		return new Kazu("7");
	}

	public static Kazu Eight () {
		return new Kazu("8");
	}

	public static Kazu Nine () {
		return new Kazu("9");
	}

	public static Kazu Zero () {
		return new Kazu("0");
	}
}

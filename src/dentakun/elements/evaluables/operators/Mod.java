package dentakun.elements.evaluables.operators;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Zahlen;

// モジュロ演算子のクラス
public class Mod extends Binary {

	// コンストラクタ
	public Mod () {
		priority = -10;
	}

	// 評価する
	public Value evaluate () {
		// オペランドが整数か確認
		long s = a.evaluate().toZahlen().getN();
		long t = b.evaluate().toZahlen().getN();
		// 演算する
		return new Zahlen(mod(s, t));
	}

	// 表記を取得
	public String toString () {
		return "mod";
	}

	// 正の符号の剰余を返す
	private long mod (long dividend, long divisor)
	{
		return (dividend % divisor + Math.abs(divisor)) % divisor;
	}
}

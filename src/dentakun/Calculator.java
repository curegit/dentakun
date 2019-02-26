package dentakun;
import dentakun.Sentence;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.Variable;
import dentakun.elements.evaluables.SpecialVariable;
import dentakun.ui.UI;
import dentakun.exceptions.ParseError;
import dentakun.exceptions.InvalidOperation;
import dentakun.exceptions.InvalidNarrowingConversion;
import dentakun.exceptions.RangeExceeded;
import java.text.DecimalFormat;
import java.net.URLDecoder;
import java.io.*;

// 計算機のメインクラス
// エントリポイントを含む
public class Calculator {

	// プログラム情報定数
	public static final String TITLE = "電卓君";

	// シングルトン
	public static Calculator root; // 計算機(自身)
	public static Sentence sentence; // 入力文
	public static UI ui; // UI

	// エントリポイント
	public static void main (String[] args) {
		new Calculator();
	}
	
	// コンストラクタ
	private Calculator () {
		root = this;
		sentence = new Sentence();
		ui = new UI();
	}

	// 実行用バイナリファイルの場所を返す
	public String rootDir () {
		try {
			String binpath = URLDecoder.decode(getClass().getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
			File binf = new File(binpath);
			return binf.getParent();
		} catch (Exception e) {
			System.out.println("ディレクトリ情報を取得できません");
			return null;
		}
	}

	// 演算する
	public void calculate () {
		// パース
		Evaluable root;
		try {
			root = sentence.parse();
		} catch (ParseError e) {
			ui.screen.setOut("Parse Error"); // 構文エラー
			return;
		} catch (Exception e) {
			ui.screen.setOut("Invalid Operation"); // 引数過剰のエラー等
			return;
		}
		// 特殊変数を初期化
		SpecialVariable.init();
		// 演算
		Value value;
		try {
			root.validate();
			value = root.evaluate();
		} catch (InvalidOperation e) {
			ui.screen.setOut("Invalid Operation"); // 無効な演算
			return;
		} catch (InvalidNarrowingConversion e) {
			ui.screen.setOut("Invalid Narrowing Conversion"); // 整数のみ許与する関数に実数を渡した
			return;
		} catch (RangeExceeded e) {
			ui.screen.setOut("Range Exceeded"); // 整数型のオーバーフロー
			return;
		} catch (Exception e) {
			ui.screen.setOut("Error"); // その他のエラー
			return;
		}
		// 結果をansレジスタに記憶
		Variable.variables[26] = value;
		// シリアライズ保存
		Variable.saveToDisk();
		// 結果の整形
		double result = value.toReal().getX();
		if (Double.isNaN(result)) {
			ui.screen.setOut("Not-a-Number");
		} else if (result > Math.pow(2, 52) || -result > Math.pow(2, 52) ) {
			DecimalFormat format = new DecimalFormat("#.#############E0");
			String str = format.format(result);
			ui.screen.setOut(str);
		} else {
			DecimalFormat format = new DecimalFormat("#############.##############");
			String str = format.format(result);
			ui.screen.setOut(str);	
		}
	}
}

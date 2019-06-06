package dentakun.elements.evaluables;
import dentakun.Calculator;
import dentakun.elements.Evaluable;
import dentakun.elements.evaluables.Value;
import dentakun.elements.evaluables.value.Real;
import java.io.*;

// ユーザーが代入、参照可能な変数
public class Variable extends Evaluable {

	// 各変数の値
	public static Value variables[] = new Value[27];

	// 各変数の表記
	public static String syn[] = {"A", "B", "C'", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P'", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "(ans)"};

	// シリアライズ保存につかうファイルディレクトリ
	private static String filedir () {
		return Calculator.root.rootDir() + "/obj";
	}

	// シリアライズ保存につかうファイルパス
	private static String filepath () {
		return filedir() + "/variables.obj";
	}

	// 変数の0初期化
	static {
		loadFromDisk();
	}

	public int i; // 参照番号

	// コンストラクタ
	public Variable (int i) {
		this.i = i;
		priority = 80;
	}

	// 子を追加する
	public void add (Evaluable e) {
		// 値クラスは子ノードを持たないので常にエラー
		throw new UnknownError();
	}

	// 子をリセットする
	public void reset () {
		// 子を持たないのでなにもしない
	}

	// 値を返す
	public Value evaluate () {
		return variables[i];
	}

	// 表記を返す
	public String toString () {
		return syn[i];
	}

	// すべての変数を0初期化する
	public static void zeroAll () {
		for (int i = 0; i < 27; i++) {
			variables[i] = new Real(0.0);
		}
		saveToDisk();
	}

	// すべての変数の状態を表す文字列を返す
	public static String getAllString () {
		String str = "";
		for (int i = 0; i < 27; i++) {
			str += syn[i].toString() + " = " + variables[i].toReal().getX() + "\n";
		}
		return str;
	}

	// フォルダがなければ作る
	private static void mkdirIfNotExists() {
		File newdir = new File(filedir());
		if (!newdir.exists()) {
			newdir.mkdir();
		}
	}

	// ディスクからデシリアライズする
	public static void loadFromDisk () {
		try {
			mkdirIfNotExists();
			FileInputStream fis = new FileInputStream(filepath());
			ObjectInputStream ois = new ObjectInputStream(fis);
			variables = (Value[])ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("変数のファイルが見つかりませんでした。新規作成します。\n");
			zeroAll();
		}
	}

	// ディスクへシリアライズ保存する
	public static void saveToDisk () {
		mkdirIfNotExists();
		try {
			FileOutputStream fos = new FileOutputStream(filepath());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(variables);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

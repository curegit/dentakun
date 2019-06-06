package dentakun.ui;
import dentakun.Calculator;
import dentakun.elements.symbols.Kazu;
import dentakun.elements.symbols.Point;
import dentakun.elements.symbols.KakkoStart;
import dentakun.elements.symbols.KakkoEnd;
import dentakun.elements.symbols.Comma;
import dentakun.elements.symbols.Equal;
import dentakun.elements.evaluables.Assignment;
import dentakun.elements.evaluables.Variable;
import dentakun.elements.evaluables.operators.Plus;
import dentakun.elements.evaluables.operators.Minus;
import dentakun.elements.evaluables.operators.Multiply;
import dentakun.elements.evaluables.operators.Divide;
import dentakun.elements.evaluables.operators.Negative;
import dentakun.elements.evaluables.operators.Power;
import dentakun.ui.Screen;
import dentakun.ui.GridPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 計算機の最も基本のGUIフレームのクラス
// キーボードショートカットの処理もする
@SuppressWarnings("serial")
public class UI extends JFrame implements KeyListener {

	public final Screen screen; // 表示部
	public final GridPanel gridPanel; // 入力部

	// 対応する計算機のGUIフレームを作成する
	public UI () {
		// Look and Feelをクロスプラットフォームなものにする
		try {
			String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// フレームを作成
		setSize(1080, 700);
		setMinimumSize(new Dimension(1000, 600));
		setTitle(Calculator.TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// レイアウト
		setLayout(new BorderLayout());
		// ペーンを作成する
		add(screen = new Screen(this), BorderLayout.PAGE_START);
		add(gridPanel = new GridPanel(this), BorderLayout.CENTER);
		// キーボードショートカット用
		addKeyListener(this);
		screen.addKeyListener(this);
		gridPanel.addKeyListener(this);
		// 背景を変更
		screen.setBackground(new Color(152, 152, 230));
		gridPanel.setBackground(new Color(152, 152, 230));
		// アイコン設定
		ImageIcon icon = new ImageIcon(Calculator.root.rootDir() + "/img/icon.png");
		if (Taskbar.isTaskbarSupported()) {
			Taskbar.getTaskbar().setIconImage(icon.getImage());
		}
		setIconImage(icon.getImage());
		// 可視化
		setVisible(true);
	}

	// キーボードショートカットのキーが押された時
	public void keyPressed (KeyEvent e) {
		int keyCode = e.getKeyCode();
		// アルファベットのとき
		if (keyCode >= 65 && keyCode <= 90) {
			Calculator.sentence.add(new Variable(keyCode - 65));
		// 数字の時
		} else if (keyCode == 96 || keyCode == 48) {
			Calculator.sentence.add(Kazu.Zero());
		} else if (keyCode == 97 || keyCode == 49) {
			Calculator.sentence.add(Kazu.One());
		} else if (keyCode == 98 || keyCode == 50) {
			Calculator.sentence.add(Kazu.Two());
		} else if (keyCode == 99 || keyCode == 51) {
			Calculator.sentence.add(Kazu.Three());
		} else if (keyCode == 100 || keyCode == 52) {
			Calculator.sentence.add(Kazu.Four());
		} else if (keyCode == 101 || keyCode == 53) {
			Calculator.sentence.add(Kazu.Five());
		} else if (keyCode == 102 || keyCode == 54) {
			Calculator.sentence.add(Kazu.Six());
		} else if (keyCode == 103 || keyCode == 55) {
			Calculator.sentence.add(Kazu.Seven());
		} else if (keyCode == 104 || keyCode == 56) {
			Calculator.sentence.add(Kazu.Eight());
		} else if (keyCode == 105 || keyCode == 57) {
			Calculator.sentence.add(Kazu.Nine());
		// その他
		} else {
			switch (keyCode) {
				case KeyEvent.VK_LEFT:
					Calculator.sentence.left();
					break;
				case KeyEvent.VK_RIGHT:
					Calculator.sentence.right();
					break;
				case KeyEvent.VK_UP:
					Calculator.sentence.left();
					Calculator.sentence.left();
					break;
				case KeyEvent.VK_DOWN:
					Calculator.sentence.right();
					Calculator.sentence.right();
					break;
				case KeyEvent.VK_PAGE_UP:
					Calculator.sentence.leftSide();
					break;
				case KeyEvent.VK_PAGE_DOWN:
					Calculator.sentence.rightSide();
					break;
				case KeyEvent.VK_INSERT:
					Calculator.sentence.add(new Assignment());
					break;
				case KeyEvent.VK_ENTER:
				case KeyEvent.VK_EQUALS:
					Calculator.sentence.rightSide();
					Calculator.sentence.add(new Equal());
					Calculator.root.calculate();
					break;
				case KeyEvent.VK_ESCAPE:
					Calculator.sentence.clear();
					break;
				case KeyEvent.VK_BACK_SPACE:
				case KeyEvent.VK_DELETE:
					Calculator.sentence.delete();
					break;
				case KeyEvent.VK_COMMA:
				case KeyEvent.VK_SEPARATOR:
					Calculator.sentence.add(new Comma());
					break;
				case KeyEvent.VK_DECIMAL:
				case KeyEvent.VK_PERIOD:
					Calculator.sentence.add(new Point());
					break;
				case KeyEvent.VK_ADD:
					Calculator.sentence.add(new Plus());
					break;
				case KeyEvent.VK_SUBTRACT:
					Calculator.sentence.add(new Minus());
					break;
				case KeyEvent.VK_MULTIPLY:
					Calculator.sentence.add(new Multiply());
					break;
				case KeyEvent.VK_DIVIDE:
					Calculator.sentence.add(new Divide());
					break;
				case KeyEvent.VK_MINUS:
					Calculator.sentence.add(new Negative());
					break;
				case KeyEvent.VK_OPEN_BRACKET:
					Calculator.sentence.add(new KakkoStart());
					break;
				case KeyEvent.VK_CLOSE_BRACKET:
					Calculator.sentence.add(new KakkoEnd());
					break;
				case KeyEvent.VK_CIRCUMFLEX:
					Calculator.sentence.add(new Power());
					break;
			}
		}
	}

	// キーが押された時
	public void keyTyped (KeyEvent e) {

	}

	// キーが離された時
	public void keyReleased (KeyEvent e) {

	}
}

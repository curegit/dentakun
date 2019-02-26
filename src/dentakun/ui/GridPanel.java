package dentakun.ui;
import dentakun.Calculator;
import dentakun.elements.symbols.Kazu;
import dentakun.elements.symbols.Point;
import dentakun.elements.symbols.KakkoStart;
import dentakun.elements.symbols.KakkoEnd;
import dentakun.elements.symbols.Comma;
import dentakun.elements.symbols.Equal;
import dentakun.elements.evaluables.functions.Sin;
import dentakun.elements.evaluables.functions.Cos;
import dentakun.elements.evaluables.functions.Tan;
import dentakun.elements.evaluables.functions.Asin;
import dentakun.elements.evaluables.functions.Acos;
import dentakun.elements.evaluables.functions.Atan;
import dentakun.elements.evaluables.functions.Sinh;
import dentakun.elements.evaluables.functions.Cosh;
import dentakun.elements.evaluables.functions.Tanh;
import dentakun.elements.evaluables.functions.Asinh;
import dentakun.elements.evaluables.functions.Acosh;
import dentakun.elements.evaluables.functions.Atanh;
import dentakun.elements.evaluables.functions.Log;
import dentakun.elements.evaluables.functions.Log10;
import dentakun.elements.evaluables.functions.Ln;
import dentakun.elements.evaluables.functions.Dx;
import dentakun.elements.evaluables.functions.Dy;
import dentakun.elements.evaluables.functions.Dz;
import dentakun.elements.evaluables.functions.Ix;
import dentakun.elements.evaluables.functions.Iy;
import dentakun.elements.evaluables.functions.Iz;
import dentakun.elements.evaluables.functions.Sigmai;
import dentakun.elements.evaluables.functions.Sigmaj;
import dentakun.elements.evaluables.functions.Sigmak;
import dentakun.elements.evaluables.functions.Pii;
import dentakun.elements.evaluables.functions.Pij;
import dentakun.elements.evaluables.functions.Pik;
import dentakun.elements.evaluables.functions.Sum;
import dentakun.elements.evaluables.functions.Med;
import dentakun.elements.evaluables.functions.Avg;
import dentakun.elements.evaluables.functions.Var;
import dentakun.elements.evaluables.functions.Sd;
import dentakun.elements.evaluables.functions.Sn;
import dentakun.elements.evaluables.functions.Abs;
import dentakun.elements.evaluables.functions.Sgn;
import dentakun.elements.evaluables.functions.Round;
import dentakun.elements.evaluables.functions.Floor;
import dentakun.elements.evaluables.functions.Ceil;
import dentakun.elements.evaluables.functions.Gcd;
import dentakun.elements.evaluables.functions.Lcm;
import dentakun.elements.evaluables.functions.Range;
import dentakun.elements.evaluables.functions.Dice;
import dentakun.elements.evaluables.functions.Coin;
import dentakun.elements.evaluables.operators.Plus;
import dentakun.elements.evaluables.operators.Minus;
import dentakun.elements.evaluables.operators.Multiply;
import dentakun.elements.evaluables.operators.Divide;
import dentakun.elements.evaluables.operators.Negative;
import dentakun.elements.evaluables.operators.Power;
import dentakun.elements.evaluables.operators.Root;
import dentakun.elements.evaluables.operators.SquareRoot;
import dentakun.elements.evaluables.operators.Mod;
import dentakun.elements.evaluables.operators.Factorial;
import dentakun.elements.evaluables.operators.Permutation;
import dentakun.elements.evaluables.operators.Combination;
import dentakun.elements.evaluables.Assignment;
import dentakun.elements.evaluables.Variable;
import dentakun.elements.evaluables.SpecialVariable;
import dentakun.elements.evaluables.Const;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;

// 各種ボタンを含むパネル
// コンストラクタで各種コンポーネント追加とイベントの登録を行う
@SuppressWarnings("serial")
public class GridPanel extends JPanel {
	
	private final Color buttonColor = new Color(20, 20, 20); // ボタンの背景色
	private final Color buttonTextColor = new Color(255, 255, 255); // ボタンの前面色

	// コンストラクタ
	public GridPanel (KeyListener k) {
		// ==========================全体の設定==========================
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(layout);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.ipadx = 4;
		gbc.ipady = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		// ==========================↓各種ボタン追加==========================
		// ==========================カーソル操作ボタン==========================
		// 左端ボタン
		JButton lllButton = new JButton("|<<");
		lllButton.setForeground(buttonTextColor);
		lllButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		layout.setConstraints(lllButton, gbc);
		lllButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.leftSide();
			}
		});
		lllButton.addKeyListener(k);
		add(lllButton);
		// 倍左ボタン
		JButton llButton = new JButton("<<");
		llButton.setForeground(buttonTextColor);
		llButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		layout.setConstraints(llButton, gbc);
		llButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.left();
				Calculator.sentence.left();
			}
		});
		llButton.addKeyListener(k);
		add(llButton);
		// 左ボタン
		JButton lButton = new JButton("<");
		lButton.setForeground(buttonTextColor);
		lButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		layout.setConstraints(lButton, gbc);
		lButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.left();
			}
		});
		lButton.addKeyListener(k);
		add(lButton);
		// 右ボタン
		JButton rButton = new JButton(">");
		rButton.setForeground(buttonTextColor);
		rButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		layout.setConstraints(rButton, gbc);
		rButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.right();
			}
		});
		rButton.addKeyListener(k);
		add(rButton);
		// 倍右ボタン
		JButton rrButton = new JButton(">>");
		rrButton.setForeground(buttonTextColor);
		rrButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		layout.setConstraints(rrButton, gbc);
		rrButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.right();
				Calculator.sentence.right();
			}
		});
		rrButton.addKeyListener(k);
		add(rrButton);
		// 右端ボタン
		JButton rrrButton = new JButton(">>|");
		rrrButton.setForeground(buttonTextColor);
		rrrButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		layout.setConstraints(rrrButton, gbc);
		rrrButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.rightSide();
			}
		});
		rrrButton.addKeyListener(k);
		add(rrrButton);

		// ==========================基本操作ボタン==========================
		// 削除ボタンを追加
		JButton delButton = new JButton("DELETE");
		delButton.setForeground(buttonTextColor);
		delButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		layout.setConstraints(delButton, gbc);
		delButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.delete();
			}
		});
		delButton.addKeyListener(k);
		add(delButton);
		// クリアボタンを追加
		JButton clrButton = new JButton("CLEAR");
		clrButton.setForeground(buttonTextColor);
		clrButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		layout.setConstraints(clrButton, gbc);
		clrButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.clear();
			}
		});
		clrButton.addKeyListener(k);
		add(clrButton);
		// 代入演算子
		JButton assButton = new JButton("STORE");
		assButton.setForeground(buttonTextColor);
		assButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		layout.setConstraints(assButton, gbc);
		assButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Assignment());
			}
		});
		assButton.addKeyListener(k);
		add(assButton);
		// 変数確認ボタン
		JButton varsButton = new JButton("VARS");
		varsButton.setForeground(buttonTextColor);
		varsButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		layout.setConstraints(varsButton, gbc);
		varsButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				JOptionPane.showMessageDialog(Calculator.ui, Variable.getAllString(), "変数", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		varsButton.addKeyListener(k);
		add(varsButton);
		// 変数初期化ボタン
		JButton varclrButton = new JButton("VARCLR");
		varclrButton.setForeground(buttonTextColor);
		varclrButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(varclrButton, gbc);
		varclrButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Variable.zeroAll();
			}
		});
		varclrButton.addKeyListener(k);
		add(varclrButton);
		// 結果をクリップボードにコピー
		JButton copyButton = new JButton("COPY");
		copyButton.setForeground(buttonTextColor);
		copyButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		layout.setConstraints(copyButton, gbc);
		copyButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String s = Calculator.ui.screen.getOut();
				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection selection = new StringSelection(s);
				cb.setContents(selection, null);
			}
		});
		copyButton.addKeyListener(k);
		add(copyButton);

		// ==========================数字/キーパッド==========================
		// 1追加
		JButton oneButton = new JButton("1");
		oneButton.setForeground(buttonTextColor);
		oneButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(oneButton, gbc);
		oneButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.One());
			}
		});
		oneButton.addKeyListener(k);
		add(oneButton);
		// 2追加
		JButton twoButton = new JButton("2");
		twoButton.setForeground(buttonTextColor);
		twoButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(twoButton, gbc);
		twoButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Two());
			}
		});
		twoButton.addKeyListener(k);
		add(twoButton);
		// 3追加
		JButton threeButton = new JButton("3");
		threeButton.setForeground(buttonTextColor);
		threeButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(threeButton, gbc);
		threeButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Three());
			}
		});
		threeButton.addKeyListener(k);
		add(threeButton);
		// 4追加
		JButton fourButton = new JButton("4");
		fourButton.setForeground(buttonTextColor);
		fourButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(fourButton, gbc);
		fourButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Four());
			}
		});
		fourButton.addKeyListener(k);
		add(fourButton);
		// 5追加
		JButton fiveButton = new JButton("5");
		fiveButton.setForeground(buttonTextColor);
		fiveButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(fiveButton, gbc);
		fiveButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Five());
			}
		});
		fiveButton.addKeyListener(k);
		add(fiveButton);
		// 6追加
		JButton sixButton = new JButton("6");
		sixButton.setForeground(buttonTextColor);
		sixButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sixButton, gbc);
		sixButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Six());
			}
		});
		sixButton.addKeyListener(k);
		add(sixButton);
		// 7追加
		JButton sevenButton = new JButton("7");
		sevenButton.setForeground(buttonTextColor);
		sevenButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sevenButton, gbc);
		sevenButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Seven());
			}
		});
		sevenButton.addKeyListener(k);
		add(sevenButton);
		// 8追加
		JButton eightButton = new JButton("8");
		eightButton.setForeground(buttonTextColor);
		eightButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(eightButton, gbc);
		eightButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Eight());
			}
		});
		eightButton.addKeyListener(k);
		add(eightButton);
		// 9追加
		JButton nineButton = new JButton("9");
		nineButton.setForeground(buttonTextColor);
		nineButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(nineButton, gbc);
		nineButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Nine());
			}
		});
		nineButton.addKeyListener(k);
		add(nineButton);
		// 0追加
		JButton zeroButton = new JButton("0");
		zeroButton.setForeground(buttonTextColor);
		zeroButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(zeroButton, gbc);
		zeroButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Zero());
			}
		});
		zeroButton.addKeyListener(k);
		add(zeroButton);
		// 小数点追加
		JButton pointButton = new JButton(".");
		pointButton.setForeground(buttonTextColor);
		pointButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(pointButton, gbc);
		pointButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Point());
			}
		});
		pointButton.addKeyListener(k);
		add(pointButton);
		// コンマ追加
		JButton commaButton = new JButton(",");
		commaButton.setForeground(buttonTextColor);
		commaButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(commaButton, gbc);
		commaButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Comma());
			}
		});
		commaButton.addKeyListener(k);
		add(commaButton);
		// (追加
		JButton ksButton = new JButton("(");
		ksButton.setForeground(buttonTextColor);
		ksButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(ksButton, gbc);
		ksButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new KakkoStart());
			}
		});
		ksButton.addKeyListener(k);
		add(ksButton);
		// )追加
		JButton kfButton = new JButton(")");
		kfButton.setForeground(buttonTextColor);
		kfButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(kfButton, gbc);
		kfButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new KakkoEnd());
			}
		});
		kfButton.addKeyListener(k);
		add(kfButton);
		// +追加
		JButton plusButton = new JButton("+");
		plusButton.setForeground(buttonTextColor);
		plusButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(plusButton, gbc);
		plusButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Plus());
			}
		});
		plusButton.addKeyListener(k);
		add(plusButton);
		// -追加
		JButton minusButton = new JButton("−");
		minusButton.setForeground(buttonTextColor);
		minusButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(minusButton, gbc);
		minusButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Minus());
			}
		});
		minusButton.addKeyListener(k);
		add(minusButton);
		// x追加
		JButton mulButton = new JButton("×");
		mulButton.setForeground(buttonTextColor);
		mulButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(mulButton, gbc);
		mulButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Multiply());
			}
		});
		mulButton.addKeyListener(k);
		add(mulButton);
		// ÷追加
		JButton divButton = new JButton("÷");
		divButton.setForeground(buttonTextColor);
		divButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(divButton, gbc);
		divButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Divide());
			}
		});
		divButton.addKeyListener(k);
		add(divButton);
		// ±追加
		JButton pmButton = new JButton("±");
		pmButton.setForeground(buttonTextColor);
		pmButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(pmButton, gbc);
		pmButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Negative());
			}
		});
		pmButton.addKeyListener(k);
		add(pmButton);
		// ans追加
		JButton ansButton = new JButton("ans");
		ansButton.setForeground(buttonTextColor);
		ansButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(ansButton, gbc);
		ansButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(26));
			}
		});
		ansButton.addKeyListener(k);
		add(ansButton);
		// equal追加
		JButton eqButton = new JButton("＝");
		eqButton.setForeground(buttonTextColor);
		eqButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		layout.setConstraints(eqButton, gbc);
		eqButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.rightSide();
				Calculator.sentence.add(new Equal());
				Calculator.root.calculate();
			}
		});
		eqButton.addKeyListener(k);
		add(eqButton);

		// ==========================指数関数==========================
		// x^2追加
		JButton x2Button = new JButton("x^2");
		x2Button.setForeground(buttonTextColor);
		x2Button.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(x2Button, gbc);
		x2Button.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Power());
				Calculator.sentence.add(Kazu.Two());
			}
		});
		x2Button.addKeyListener(k);
		add(x2Button);
		// x^3追加
		JButton x3Button = new JButton("x^3");
		x3Button.setForeground(buttonTextColor);
		x3Button.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(x3Button, gbc);
		x3Button.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Power());
				Calculator.sentence.add(Kazu.Three());
			}
		});
		x3Button.addKeyListener(k);
		add(x3Button);
		// x^y追加
		JButton xyButton = new JButton("x^y");
		xyButton.setForeground(buttonTextColor);
		xyButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(xyButton, gbc);
		xyButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Power());
			}
		});
		xyButton.addKeyListener(k);
		add(xyButton);
		// x^-1追加
		JButton x_1Button = new JButton("x^-1");
		x_1Button.setForeground(buttonTextColor);
		x_1Button.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(x_1Button, gbc);
		x_1Button.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Power());
				Calculator.sentence.add(new Negative());
				Calculator.sentence.add(Kazu.One());
			}
		});
		x_1Button.addKeyListener(k);
		add(x_1Button);
		// 10^x追加
		JButton x10xButton = new JButton("10^x");
		x10xButton.setForeground(buttonTextColor);
		x10xButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(x10xButton, gbc);
		x10xButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.One());
				Calculator.sentence.add(Kazu.Zero());
				Calculator.sentence.add(new Power());
			}
		});
		x10xButton.addKeyListener(k);
		add(x10xButton);
		// 平方根追加
		JButton sqrtButton = new JButton("√x");
		sqrtButton.setForeground(buttonTextColor);
		sqrtButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sqrtButton, gbc);
		sqrtButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SquareRoot());
			}
		});
		sqrtButton.addKeyListener(k);
		add(sqrtButton);
		// 立方根追加
		JButton cbrtButton = new JButton("3√x");
		cbrtButton.setForeground(buttonTextColor);
		cbrtButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(cbrtButton, gbc);
		cbrtButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Kazu.Three());
				Calculator.sentence.add(new Root());
			}
		});
		cbrtButton.addKeyListener(k);
		add(cbrtButton);
		// y√x追加
		JButton yxButton = new JButton("y√x");
		yxButton.setForeground(buttonTextColor);
		yxButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(yxButton, gbc);
		yxButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Root());
			}
		});
		yxButton.addKeyListener(k);
		add(yxButton);

		// ==========================対数関数==========================
		// 常用対数追加
		JButton log10Button = new JButton("log10");
		log10Button.setForeground(buttonTextColor);
		log10Button.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(log10Button, gbc);
		log10Button.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Log10());
			}
		});
		log10Button.addKeyListener(k);
		add(log10Button);
		// 自然対数追加
		JButton lnButton = new JButton("ln");
		lnButton.setForeground(buttonTextColor);
		lnButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(lnButton, gbc);
		lnButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Ln());
			}
		});
		lnButton.addKeyListener(k);
		add(lnButton);
		// 任意底の対数追加
		JButton logButton = new JButton("log");
		logButton.setForeground(buttonTextColor);
		logButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(logButton, gbc);
		logButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Log());
			}
		});
		logButton.addKeyListener(k);
		add(logButton);

		// ==========================三角関数==========================
		// sin追加
		JButton sinButton = new JButton("sin");
		sinButton.setForeground(buttonTextColor);
		sinButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sinButton, gbc);
		sinButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sin());
			}
		});
		sinButton.addKeyListener(k);
		add(sinButton);
		// cos追加
		JButton cosButton = new JButton("cos");
		cosButton.setForeground(buttonTextColor);
		cosButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(cosButton, gbc);
		cosButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Cos());
			}
		});
		cosButton.addKeyListener(k);
		add(cosButton);
		// tan追加
		JButton tanButton = new JButton("tan");
		tanButton.setForeground(buttonTextColor);
		tanButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(tanButton, gbc);
		tanButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Tan());
			}
		});
		tanButton.addKeyListener(k);
		add(tanButton);
		// arcsin追加
		JButton arcsinButton = new JButton("asin");
		arcsinButton.setForeground(buttonTextColor);
		arcsinButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(arcsinButton, gbc);
		arcsinButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Asin());
			}
		});
		arcsinButton.addKeyListener(k);
		add(arcsinButton);
		// arccos追加
		JButton arccosButton = new JButton("acos");
		arccosButton.setForeground(buttonTextColor);
		arccosButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(arccosButton, gbc);
		arccosButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Acos());
			}
		});
		arccosButton.addKeyListener(k);
		add(arccosButton);
		// arctan追加
		JButton arctanButton = new JButton("atan");
		arctanButton.setForeground(buttonTextColor);
		arctanButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(arctanButton, gbc);
		arctanButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Atan());
			}
		});
		arctanButton.addKeyListener(k);
		add(arctanButton);
		// sinh追加
		JButton sinhButton = new JButton("sinh");
		sinhButton.setForeground(buttonTextColor);
		sinhButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sinhButton, gbc);
		sinhButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sinh());
			}
		});
		sinhButton.addKeyListener(k);
		add(sinhButton);
		// cosh追加
		JButton coshButton = new JButton("cosh");
		coshButton.setForeground(buttonTextColor);
		coshButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(coshButton, gbc);
		coshButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Cosh());
			}
		});
		coshButton.addKeyListener(k);
		add(coshButton);
		// tanh追加
		JButton tanhButton = new JButton("tanh");
		tanhButton.setForeground(buttonTextColor);
		tanhButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(tanhButton, gbc);
		tanhButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Tanh());
			}
		});
		tanhButton.addKeyListener(k);
		add(tanhButton);
		// arcsinh追加
		JButton arcsinhButton = new JButton("asinh");
		arcsinhButton.setForeground(buttonTextColor);
		arcsinhButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(arcsinhButton, gbc);
		arcsinhButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Asinh());
			}
		});
		arcsinhButton.addKeyListener(k);
		add(arcsinhButton);
		// arccosh追加
		JButton arccoshButton = new JButton("acosh");
		arccoshButton.setForeground(buttonTextColor);
		arccoshButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(arccoshButton, gbc);
		arccoshButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Acosh());
			}
		});
		arccoshButton.addKeyListener(k);
		add(arccoshButton);
		// arctanh追加
		JButton arctanhButton = new JButton("atanh");
		arctanhButton.setForeground(buttonTextColor);
		arctanhButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(arctanhButton, gbc);
		arctanhButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Atanh());
			}
		});
		arctanhButton.addKeyListener(k);
		add(arctanhButton);

		// ==========================微分積分関数==========================
		// d/dx追加
		JButton dxButton = new JButton("d/dx");
		dxButton.setForeground(buttonTextColor);
		dxButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(dxButton, gbc);
		dxButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Dx());
			}
		});
		dxButton.addKeyListener(k);
		add(dxButton);
		// d/dy追加
		JButton dyButton = new JButton("d/dy");
		dyButton.setForeground(buttonTextColor);
		dyButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(dyButton, gbc);
		dyButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Dy());
			}
		});
		dyButton.addKeyListener(k);
		add(dyButton);
		// d/dz追加
		JButton dzButton = new JButton("d/dz");
		dzButton.setForeground(buttonTextColor);
		dzButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(dzButton, gbc);
		dzButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Dz());
			}
		});
		dzButton.addKeyListener(k);
		add(dzButton);
		// ∫dx追加
		JButton ixButton = new JButton("∫dx");
		ixButton.setForeground(buttonTextColor);
		ixButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(ixButton, gbc);
		ixButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Ix());
			}
		});
		ixButton.addKeyListener(k);
		add(ixButton);
		// ∫dy追加
		JButton iyButton = new JButton("∫dy");
		iyButton.setForeground(buttonTextColor);
		iyButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(iyButton, gbc);
		iyButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Iy());
			}
		});
		iyButton.addKeyListener(k);
		add(iyButton);
		// ∫dz追加
		JButton izButton = new JButton("∫dz");
		izButton.setForeground(buttonTextColor);
		izButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(izButton, gbc);
		izButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Iz());
			}
		});
		izButton.addKeyListener(k);
		add(izButton);
		// Σi追加
		JButton sigiButton = new JButton("Σi");
		sigiButton.setForeground(buttonTextColor);
		sigiButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sigiButton, gbc);
		sigiButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sigmai());
			}
		});
		sigiButton.addKeyListener(k);
		add(sigiButton);
		// Σj追加
		JButton sigjButton = new JButton("Σj");
		sigjButton.setForeground(buttonTextColor);
		sigjButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sigjButton, gbc);
		sigjButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sigmaj());
			}
		});
		sigjButton.addKeyListener(k);
		add(sigjButton);
		// Σk追加
		JButton sigkButton = new JButton("Σk");
		sigkButton.setForeground(buttonTextColor);
		sigkButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sigkButton, gbc);
		sigkButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sigmak());
			}
		});
		sigkButton.addKeyListener(k);
		add(sigkButton);
		// Πi追加
		JButton piiButton = new JButton("Πi");
		piiButton.setForeground(buttonTextColor);
		piiButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(piiButton, gbc);
		piiButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Pii());
			}
		});
		piiButton.addKeyListener(k);
		add(piiButton);
		// Πj追加
		JButton pijButton = new JButton("Πj");
		pijButton.setForeground(buttonTextColor);
		pijButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(pijButton, gbc);
		pijButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Pij());
			}
		});
		pijButton.addKeyListener(k);
		add(pijButton);
		// Πk追加
		JButton pikButton = new JButton("Πk");
		pikButton.setForeground(buttonTextColor);
		pikButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(pikButton, gbc);
		pikButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Pik());
			}
		});
		pikButton.addKeyListener(k);
		add(pikButton);

		// ==========================統計関数==========================
		// 合計追加
		JButton sumButton = new JButton("sum");
		sumButton.setForeground(buttonTextColor);
		sumButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sumButton, gbc);
		sumButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sum());
			}
		});
		sumButton.addKeyListener(k);
		add(sumButton);
		// 中央値追加
		JButton medButton = new JButton("med");
		medButton.setForeground(buttonTextColor);
		medButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(medButton, gbc);
		medButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Med());
			}
		});
		medButton.addKeyListener(k);
		add(medButton);
		// 平均追加
		JButton avgButton = new JButton("avg");
		avgButton.setForeground(buttonTextColor);
		avgButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(avgButton, gbc);
		avgButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Avg());
			}
		});
		avgButton.addKeyListener(k);
		add(avgButton);
		// 分散追加
		JButton varButton = new JButton("var");
		varButton.setForeground(buttonTextColor);
		varButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(varButton, gbc);
		varButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Var());
			}
		});
		varButton.addKeyListener(k);
		add(varButton);
		// 標準偏差追加
		JButton sdButton = new JButton("σn");
		sdButton.setForeground(buttonTextColor);
		sdButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sdButton, gbc);
		sdButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sd());
			}
		});
		sdButton.addKeyListener(k);
		add(sdButton);
		// 不偏標準偏差追加
		JButton snButton = new JButton("sn");
		snButton.setForeground(buttonTextColor);
		snButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(snButton, gbc);
		snButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sn());
			}
		});
		snButton.addKeyListener(k);
		add(snButton);

		// ==========================乱数関数==========================
		// 実数範囲乱数関数追加
		JButton rangeButton = new JButton("range");
		rangeButton.setForeground(buttonTextColor);
		rangeButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(rangeButton, gbc);
		rangeButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Range());
			}
		});
		rangeButton.addKeyListener(k);
		add(rangeButton);
		// 離散範囲乱数関数追加
		JButton diceButton = new JButton("dice");
		diceButton.setForeground(buttonTextColor);
		diceButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(diceButton, gbc);
		diceButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Dice());
			}
		});
		diceButton.addKeyListener(k);
		add(diceButton);
		// 二値乱数関数追加
		JButton coinButton = new JButton("coin");
		coinButton.setForeground(buttonTextColor);
		coinButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(coinButton, gbc);
		coinButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Coin());
			}
		});
		coinButton.addKeyListener(k);
		add(coinButton);

		// ==========================その他の関数/演算子==========================
		// 絶対値追加
		JButton absButton = new JButton("abs");
		absButton.setForeground(buttonTextColor);
		absButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(absButton, gbc);
		absButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Abs());
			}
		});
		absButton.addKeyListener(k);
		add(absButton);
		// 符号関数追加
		JButton sgnButton = new JButton("sgn");
		sgnButton.setForeground(buttonTextColor);
		sgnButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(sgnButton, gbc);
		sgnButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Sgn());
			}
		});
		sgnButton.addKeyListener(k);
		add(sgnButton);
		// モジュロ追加
		JButton modButton = new JButton("mod");
		modButton.setForeground(buttonTextColor);
		modButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(modButton, gbc);
		modButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Mod());
			}
		});
		modButton.addKeyListener(k);
		add(modButton);
		// 最大公約数追加
		JButton gcdButton = new JButton("gcd");
		gcdButton.setForeground(buttonTextColor);
		gcdButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(gcdButton, gbc);
		gcdButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Gcd());
			}
		});
		gcdButton.addKeyListener(k);
		add(gcdButton);
		// 最小公倍数追加
		JButton lcmButton = new JButton("lcm");
		lcmButton.setForeground(buttonTextColor);
		lcmButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(lcmButton, gbc);
		lcmButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Lcm());
			}
		});
		lcmButton.addKeyListener(k);
		add(lcmButton);
		// 階乗追加
		JButton facButton = new JButton("n!");
		facButton.setForeground(buttonTextColor);
		facButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(facButton, gbc);
		facButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Factorial());
			}
		});
		facButton.addKeyListener(k);
		add(facButton);
		// 順列追加
		JButton perButton = new JButton("nPk");
		perButton.setForeground(buttonTextColor);
		perButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(perButton, gbc);
		perButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Permutation());
			}
		});
		perButton.addKeyListener(k);
		add(perButton);
		// 組み合わせ追加
		JButton comButton = new JButton("nCk");
		comButton.setForeground(buttonTextColor);
		comButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(comButton, gbc);
		comButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Combination());
			}
		});
		comButton.addKeyListener(k);
		add(comButton);
		// 四捨五入追加
		JButton roundButton = new JButton("round");
		roundButton.setForeground(buttonTextColor);
		roundButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(roundButton, gbc);
		roundButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Round());
			}
		});
		roundButton.addKeyListener(k);
		add(roundButton);
		// 床追加
		JButton floorButton = new JButton("floor");
		floorButton.setForeground(buttonTextColor);
		floorButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(floorButton, gbc);
		floorButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Floor());
			}
		});
		floorButton.addKeyListener(k);
		add(floorButton);
		// 天井追加
		JButton ceilButton = new JButton("ceil");
		ceilButton.setForeground(buttonTextColor);
		ceilButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(ceilButton, gbc);
		ceilButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Ceil());
			}
		});
		ceilButton.addKeyListener(k);
		add(ceilButton);

		// ==========================ユーザー変数==========================
		// A追加
		JButton AButton = new JButton("A");
		AButton.setForeground(buttonTextColor);
		AButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(AButton, gbc);
		AButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(0));
			}
		});
		AButton.addKeyListener(k);
		add(AButton);
		// B追加
		JButton BButton = new JButton("B");
		BButton.setForeground(buttonTextColor);
		BButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(BButton, gbc);
		BButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(1));
			}
		});
		BButton.addKeyListener(k);
		add(BButton);
		// C追加
		JButton CButton = new JButton("C'");
		CButton.setForeground(buttonTextColor);
		CButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(CButton, gbc);
		CButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(2));
			}
		});
		CButton.addKeyListener(k);
		add(CButton);
		// D追加
		JButton DButton = new JButton("D");
		DButton.setForeground(buttonTextColor);
		DButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(DButton, gbc);
		DButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(3));
			}
		});
		DButton.addKeyListener(k);
		add(DButton);
		// E追加
		JButton EButton = new JButton("E");
		EButton.setForeground(buttonTextColor);
		EButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(EButton, gbc);
		EButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(4));
			}
		});
		EButton.addKeyListener(k);
		add(EButton);
		// F追加
		JButton FButton = new JButton("F");
		FButton.setForeground(buttonTextColor);
		FButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(FButton, gbc);
		FButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(5));
			}
		});
		FButton.addKeyListener(k);
		add(FButton);
		// G追加
		JButton GButton = new JButton("G");
		GButton.setForeground(buttonTextColor);
		GButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(GButton, gbc);
		GButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(6));
			}
		});
		GButton.addKeyListener(k);
		add(GButton);
		// H追加
		JButton HButton = new JButton("H");
		HButton.setForeground(buttonTextColor);
		HButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(HButton, gbc);
		HButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(7));
			}
		});
		HButton.addKeyListener(k);
		add(HButton);
		// I追加
		JButton IButton = new JButton("I");
		IButton.setForeground(buttonTextColor);
		IButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(IButton, gbc);
		IButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(8));
			}
		});
		IButton.addKeyListener(k);
		add(IButton);
		// J追加
		JButton _JButton = new JButton("J");
		_JButton.setForeground(buttonTextColor);
		_JButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(_JButton, gbc);
		_JButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(9));
			}
		});
		_JButton.addKeyListener(k);
		add(_JButton);

		// K追加
		JButton KButton = new JButton("K");
		KButton.setForeground(buttonTextColor);
		KButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(KButton, gbc);
		KButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(10));
			}
		});
		KButton.addKeyListener(k);
		add(KButton);

		// L追加
		JButton LButton = new JButton("L");
		LButton.setForeground(buttonTextColor);
		LButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(LButton, gbc);
		LButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(11));
			}
		});
		LButton.addKeyListener(k);
		add(LButton);
		// M追加
		JButton MButton = new JButton("M");
		MButton.setForeground(buttonTextColor);
		MButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(MButton, gbc);
		MButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(12));
			}
		});
		MButton.addKeyListener(k);
		add(MButton);
		// N追加
		JButton NButton = new JButton("N");
		NButton.setForeground(buttonTextColor);
		NButton.setBackground(buttonColor);
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(NButton, gbc);
		NButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(13));
			}
		});
		NButton.addKeyListener(k);
		add(NButton);
		// O追加
		JButton OButton = new JButton("O");
		OButton.setForeground(buttonTextColor);
		OButton.setBackground(buttonColor);
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(OButton, gbc);
		OButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(14));
			}
		});
		OButton.addKeyListener(k);
		add(OButton);
		// P追加
		JButton PButton = new JButton("P'");
		PButton.setForeground(buttonTextColor);
		PButton.setBackground(buttonColor);
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(PButton, gbc);
		PButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(15));
			}
		});
		PButton.addKeyListener(k);
		add(PButton);
		// Q追加
		JButton QButton = new JButton("Q");
		QButton.setForeground(buttonTextColor);
		QButton.setBackground(buttonColor);
		gbc.gridx = 3;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(QButton, gbc);
		QButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(16));
			}
		});
		QButton.addKeyListener(k);
		add(QButton);
		// R追加
		JButton RButton = new JButton("R");
		RButton.setForeground(buttonTextColor);
		RButton.setBackground(buttonColor);
		gbc.gridx = 4;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(RButton, gbc);
		RButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(17));
			}
		});
		RButton.addKeyListener(k);
		add(RButton);
		// S追加
		JButton SButton = new JButton("S");
		SButton.setForeground(buttonTextColor);
		SButton.setBackground(buttonColor);
		gbc.gridx = 5;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(SButton, gbc);
		SButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(18));
			}
		});
		SButton.addKeyListener(k);
		add(SButton);
		// T追加
		JButton TButton = new JButton("T");
		TButton.setForeground(buttonTextColor);
		TButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(TButton, gbc);
		TButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(19));
			}
		});
		TButton.addKeyListener(k);
		add(TButton);
		// U追加
		JButton UButton = new JButton("U");
		UButton.setForeground(buttonTextColor);
		UButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(UButton, gbc);
		UButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(20));
			}
		});
		UButton.addKeyListener(k);
		add(UButton);
		// V追加
		JButton VButton = new JButton("V");
		VButton.setForeground(buttonTextColor);
		VButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(VButton, gbc);
		VButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(21));
			}
		});
		VButton.addKeyListener(k);
		add(VButton);
		// W追加
		JButton WButton = new JButton("W");
		WButton.setForeground(buttonTextColor);
		WButton.setBackground(buttonColor);
		gbc.gridx = 9;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(WButton, gbc);
		WButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(22));
			}
		});
		WButton.addKeyListener(k);
		add(WButton);
		// X追加
		JButton XButton = new JButton("X");
		XButton.setForeground(buttonTextColor);
		XButton.setBackground(buttonColor);
		gbc.gridx = 10;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(XButton, gbc);
		XButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(23));
			}
		});
		XButton.addKeyListener(k);
		add(XButton);
		// Y追加
		JButton YButton = new JButton("Y");
		YButton.setForeground(buttonTextColor);
		YButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(YButton, gbc);
		YButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(24));
			}
		});
		YButton.addKeyListener(k);
		add(YButton);
		// Z追加
		JButton ZButton = new JButton("Z");
		ZButton.setForeground(buttonTextColor);
		ZButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(ZButton, gbc);
		ZButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new Variable(25));
			}
		});
		ZButton.addKeyListener(k);
		add(ZButton);

		// ==========================特殊変数==========================
		// x追加
		JButton xButton = new JButton("x");
		xButton.setForeground(buttonTextColor);
		xButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(xButton, gbc);
		xButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SpecialVariable(0));
			}
		});
		xButton.addKeyListener(k);
		add(xButton);
		// y追加
		JButton yButton = new JButton("y");
		yButton.setForeground(buttonTextColor);
		yButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(yButton, gbc);
		yButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SpecialVariable(1));
			}
		});
		yButton.addKeyListener(k);
		add(yButton);
		// z追加
		JButton zButton = new JButton("z");
		zButton.setForeground(buttonTextColor);
		zButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(zButton, gbc);
		zButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SpecialVariable(2));
			}
		});
		zButton.addKeyListener(k);
		add(zButton);
		// i追加
		JButton iButton = new JButton("i");
		iButton.setForeground(buttonTextColor);
		iButton.setBackground(buttonColor);
		gbc.gridx = 6;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(iButton, gbc);
		iButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SpecialVariable(3));
			}
		});
		iButton.addKeyListener(k);
		add(iButton);
		// j追加
		JButton jButton = new JButton("j");
		jButton.setForeground(buttonTextColor);
		jButton.setBackground(buttonColor);
		gbc.gridx = 7;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(jButton, gbc);
		jButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SpecialVariable(4));
			}
		});
		jButton.addKeyListener(k);
		add(jButton);
		// k追加
		JButton kButton = new JButton("k");
		kButton.setForeground(buttonTextColor);
		kButton.setBackground(buttonColor);
		gbc.gridx = 8;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(kButton, gbc);
		kButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(new SpecialVariable(5));
			}
		});
		kButton.addKeyListener(k);
		add(kButton);

		// ==========================定数==========================
		// π追加
		JButton piButton = new JButton("π");
		piButton.setForeground(buttonTextColor);
		piButton.setBackground(buttonColor);
		gbc.gridx = 12;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(piButton, gbc);
		piButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Const.Pi());
			}
		});
		piButton.addKeyListener(k);
		add(piButton);
		// e追加
		JButton eButton = new JButton("e");
		eButton.setForeground(buttonTextColor);
		eButton.setBackground(buttonColor);
		gbc.gridx = 13;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(eButton, gbc);
		eButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Const.E());
			}
		});
		eButton.addKeyListener(k);
		add(eButton);
		// ∞追加
		JButton infButton = new JButton("∞");
		infButton.setForeground(buttonTextColor);
		infButton.setBackground(buttonColor);
		gbc.gridx = 11;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(infButton, gbc);
		infButton.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Calculator.sentence.add(Const.Infinity());
			}
		});
		infButton.addKeyListener(k);
		add(infButton);
	}
}

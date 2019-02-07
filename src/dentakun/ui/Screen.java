package dentakun.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dentakun.Calculator;

// 表示部を含むパネル
// 入力と出力を表示する
@SuppressWarnings("serial")
public class Screen extends JPanel {
	
	private final JTextArea in; // 入力式
	private final JTextArea out; // 結果

	// コンストラクタ
	public Screen (KeyListener k) {
		// レイアウト設定
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(box);
		// キーボードショートカット用
		addKeyListener(Calculator.ui);
		// コンポーネント作成
		in = new JTextArea("|", 2, 0);
		out = new JTextArea("", 1, 0);
		JScrollPane scp = new JScrollPane(in);
		// コンポーネントの調整（色、フォント、折り返し）
		in.setFont(new Font("Serif", Font.BOLD, 28));
		in.setForeground(new Color(0x000000));
		in.setBackground(new Color(0xffffff));
		in.setOpaque(true);
		in.addKeyListener(k);
		in.setLineWrap(true);
		in.setWrapStyleWord(false);
		in.setEditable(false);
		out.setEditable(false);
		out.setFont(new Font("Serif", Font.BOLD, 30));
		out.setForeground(new Color(0x000000));
		out.setBackground(new Color(0xffffff));
		out.setOpaque(true);
		out.addKeyListener(k);
		// コンポーネント追加
		add(scp);
		add(out);
	}

	// 入力式をセットする
	public void setIn (String s) {
		in.setText(s);
	}

	// 出力結果をセットする
	public void setOut (String s) {
		out.setText(s);
	}
	
	// 表示されている出力結果を取得する
	public String getOut () {
		return out.getText();
	}
}

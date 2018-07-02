package chap19;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		//contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40));
		contentPane.setLayout(new BorderLayout(30, 20));
		
		JLabel label = new JLabel("こんにちは", SwingConstants.CENTER);
		
		contentPane.add(label, BorderLayout.NORTH);
		contentPane.add(new JButton("OK"), BorderLayout.WEST);
		contentPane.add(new JButton("Cancel"), BorderLayout.CENTER);
		contentPane.add(new JButton("Ignore"), BorderLayout.EAST);
		

		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneEx();
	}


}

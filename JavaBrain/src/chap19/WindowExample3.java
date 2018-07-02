package chap19;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WindowExample3 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Zoo Program");
		//frame.setPreferredSize(new Dimension(700, 700));
		//frame.setLocation(500, 400);		
		Container contentPane = frame.getContentPane();
		GridLayout layout = new GridLayout(3, 5);
		
		//색상
		Color color = new Color(150, 150, 150);
		frame.getContentPane().setBackground(color);
		
		contentPane.setLayout(layout);
		contentPane.add(new JButton("얼룩말"));
		contentPane.add(new JButton("사자"));
		contentPane.add(new JButton("코끼리"));
		contentPane.add(new JButton("코뿔소"));
		contentPane.add(new JButton("펭귄"));
		contentPane.add(new JButton("하이에나"));		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		

	}

}

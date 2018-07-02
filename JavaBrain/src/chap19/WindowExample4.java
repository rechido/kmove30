package chap19;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowExample4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fruit Basket Program");
		frame.setPreferredSize(new Dimension(700, 700));
		//frame.setLocation(500, 400);		
		Container contentPane = frame.getContentPane();
		FlowLayout layout = new FlowLayout();
		
		//색상
		Color color = new Color(150, 150, 150);
		frame.getContentPane().setBackground(color);
		
		contentPane.setLayout(layout);
		contentPane.add(new JButton("사과"));
		contentPane.add(new JButton("파인애플"));
		contentPane.add(new JButton("오렌지"));
		contentPane.add(new JButton("포도"));
		contentPane.add(new JButton("레몬"));
		contentPane.add(new JButton("복숭아"));		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		

	}

}

/**
 * 2018. 5. 24. Dev. by D. A. Lee
 */
package chap19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WindowExample2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Program");
		frame.setPreferredSize(new Dimension(200, 170));
		//frame.setLocation(500, 400);
		
		Container contentPane = frame.getContentPane();		
		JTextField text = new JTextField("이름을 입력하세요.", 2); // 최초 실행 시 문구창에 보여주는 문구
		JButton button = new JButton("확인");
		
		//ImageIcon images1 = new ImageIcon("images\\coffeecuplogoJava_5406.png");
		JLabel label = new JLabel("Hello");
		//JLabel iamgelabel = new JLabel(images1, SwingConstants.CENTER);
		
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);
		//contentPane.add(iamgelabel, BorderLayout.NORTH);
		
		//ActionListener listener = new ConfirmButtonActionListener(text, label);
		button.addActionListener(new ConfirmButtonActionListener(text, label));
		text.addActionListener(new ConfirmButtonActionListener(text, label));
		
		contentPane.setFocusable(true); // 최초 포커스가 텍스트창으로 가지 않도록 함
		
		text.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) { }
			
			@Override
			public void focusGained(FocusEvent e) {
				if(text.getText().equals("이름을 입력하세요."))
					text.setText(null); // 텍스트 창 클릭 시 텍스트 사라지도록 함		
			}
		});
		
//		text.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) { }
//			
//			@Override
//			public void keyReleased(KeyEvent e) { }
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
////				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
////					System.out.println("enter");
////				}
//			}
//		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}

/**
 * 2018. 5. 25. Dev. by D. A. Lee
 */
package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercise19_3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("덧셈 프로그램");
		//frame.setPreferredSize(new Dimension(250, 120));
		Container contentPane = frame.getContentPane();		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		//BoxLayout layout = new BoxLayout(panel1, BoxLayout.X_AXIS);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
		panel1.setLayout(layout);
		panel1.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10)); //상하좌우 10씩 띄우기
		
		FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 20, 10);
		panel2.setLayout(layout2);
		
		JTextField text1 = new JTextField(4);
		JTextField text2 = new JTextField(4);
		JTextField text3 = new JTextField(4);
		text3.setFocusable(false);
		
		panel1.add(text1);
		panel1.add(new JLabel(" + "));
		panel1.add(text2);
		panel1.add(new JLabel(" = "));
		panel1.add(text3);		
		contentPane.add(panel1, BorderLayout.NORTH);		
		
		JButton button1 = new JButton("확인");
		JButton button2 = new JButton("취소");
		
		panel2.add(button1);
		panel2.add(button2);
		contentPane.add(panel2, BorderLayout.SOUTH);
		
		ActionListener okay = new OkayButton(text1, text2, text3);
		button1.addActionListener(okay);
		ActionListener cancel = new CancelButton(text1, text2, text3);
		button2.addActionListener(cancel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}

class OkayButton implements ActionListener {
	
	JTextField text1;
	JTextField text2;
	JTextField text3;
	public OkayButton(JTextField text1, JTextField text2, JTextField text3) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(text1.getText().equals(null) || text2.getText().equals(null)) {
			System.out.println();
			return;
		}
			
		int num1 = Integer.parseInt(text1.getText()); // textfield에 입력된 string -> int로 변환
		int num2 = Integer.parseInt(text2.getText());
		String str1 = String.valueOf(num1+num2); // 두 숫자 합산 후에 string으로 변환
		text3.setText(str1);
	}	
}

class CancelButton implements ActionListener {
	JTextField text1;
	JTextField text2;
	JTextField text3;	

	public CancelButton(JTextField text1, JTextField text2, JTextField text3) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		text1.setText(null);
		text2.setText(null);
		text3.setText(null);
		
	}
	
}

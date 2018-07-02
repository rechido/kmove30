package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPasswordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("로그인");
		frame.setPreferredSize(new Dimension(350, 150));
		//frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		JPanel idPswdWindow = new JPanel();
		idPswdWindow.setLayout(new GridLayout(2, 2));
		JTextField idField = new JTextField();
		JPasswordField pswdField = new JPasswordField();
		idPswdWindow.add(new JLabel("ID"));
		idPswdWindow.add(idField);
		idPswdWindow.add(new JLabel("Password"));
		idPswdWindow.add(pswdField);
		
		contentPane.add(idPswdWindow, BorderLayout.CENTER);
		
		pswdField.addActionListener(new pswdActionListener(pswdField));
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}

class pswdActionListener implements ActionListener{
	JPasswordField pswdField = new JPasswordField();
	

	public pswdActionListener(JPasswordField pswdField) {
		super();
		this.pswdField = pswdField;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		char[] p = pswdField.getPassword();
		String str = new String(p);
		System.out.println(str);
	}
	
}


package messenger;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {
	MybatisQuery query;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Login(MybatisQuery query) {
			super();
			this.query = query;
			
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
			
			JPanel btnWindow = new JPanel();
			JButton okBtn = new JButton("확인");
			JButton noBtn = new JButton("취소");
			JButton signInBtn = new JButton("회원가입");
			JButton signOutBtn = new JButton("회원탈퇴");
			btnWindow.add(okBtn);
			btnWindow.add(noBtn);
			btnWindow.add(signInBtn);
			btnWindow.add(signOutBtn);
			
			contentPane.add(idPswdWindow, BorderLayout.CENTER);
			contentPane.add(btnWindow, BorderLayout.SOUTH);
			
			// 버튼 이벤트
			noBtn.addActionListener(new NoBtn_Login(frame));
			OkBtn_Login okay = new OkBtn_Login(idField, pswdField, frame, query);
			okBtn.addActionListener(okay);
			signInBtn.addActionListener(new SignInBtn_Login(query));
			signOutBtn.addActionListener(new SignOutBtn_Login(query));
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			
			
		}

}

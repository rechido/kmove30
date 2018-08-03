package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class LoginEx1 {
	JDBC_Manager jdbcManager = new JDBC_Manager();
	
	public LoginEx1(JDBC_Manager jdbcManager) {
			super();
			this.jdbcManager = jdbcManager;
			
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
			noBtn.addActionListener(new NoBtnLoginEx1(frame));
			okBtn.addActionListener(new OkBtnLoginEx1(idField, pswdField, jdbcManager, frame));
			signInBtn.addActionListener(new signInBtnLoginEx1(jdbcManager));
			signOutBtn.addActionListener(new signOutBtnLoginEx1(jdbcManager));
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			
			try {
				jdbcManager.connectDB("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3307/malldb", "root", "12345");
				frame.setTitle("로그인 - DB 접속중");
				System.out.println("데이터베이스에 접속했습니다.");
			}catch (ClassNotFoundException cnfe) {
				System.out.println("해당 클래스를 찾을 수 없습니다." + 
		                cnfe.getMessage());
				frame.setTitle("로그인 - DB 접속 실패");
			}catch (SQLException se) {
				System.out.println(se.getMessage());
				frame.setTitle("로그인 - DB 접속 실패");
			}catch (Exception e) {
				System.out.println(e.getMessage());
				frame.setTitle("로그인 - DB 접속 실패");
			}
			
			
		}

}

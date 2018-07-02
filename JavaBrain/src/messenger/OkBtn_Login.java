package messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class OkBtn_Login implements ActionListener {	
	JTextField idField;
	JPasswordField pswdField;
	//JDBC_Manager jdbcManager;	
	JFrame frame;
	MybatisQuery query;
	
	public OkBtn_Login(JTextField idField, JPasswordField pswdField, JFrame frame, MybatisQuery query) {
		super();
		this.idField = idField;
		this.pswdField = pswdField;
		this.frame = frame;
		this.query = query;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(idField.getText() + " " + new String(pswdField.getPassword()));
		
		Member member = query.selectOne(idField.getText());
		//System.out.println(member.getId() + " " + member.getPassword());
		
		if(new String(pswdField.getPassword()).equals(member.getPassword())) {
			JOptionPane.showMessageDialog(null, idField.getText() + "님 환영합니다!", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
			new MessengerClient(idField.getText());			
			frame.dispose();
		}			
		else
			JOptionPane.showMessageDialog(null, "id 혹은 password가 맞지 않습니다!", "로그인 실패", JOptionPane.WARNING_MESSAGE);
	
	}
	
	
	
	
}

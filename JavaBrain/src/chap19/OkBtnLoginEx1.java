package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class OkBtnLoginEx1 implements ActionListener {	
	JTextField idField;
	JPasswordField pswdField;
	JDBC_Manager jdbcManager;	
	JFrame frame;

	public OkBtnLoginEx1(JTextField idField, JPasswordField pswdField, JDBC_Manager jdbcManager, JFrame frame) {
		super();
		this.idField = idField;
		this.pswdField = pswdField;
		this.jdbcManager = jdbcManager;
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(idField.getText() + " " + new String(pswdField.getPassword()));
		String query = "select * from member";
		//System.out.println(query);
		try {
			ResultSet rs = jdbcManager.selectTable(query);
			while(rs.next()) {
				//System.out.println(rs.getString(1) + " " + rs.getString(2));
				if(	idField.getText().equals(rs.getString(1))
				&& 	new String(pswdField.getPassword()).equals(rs.getString(2))
				) {
					JOptionPane.showMessageDialog(null, idField.getText() + "님 환영합니다!", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
					new MallDBTableExample(jdbcManager);
					frame.dispose();
					return;
				}			
			}
			JOptionPane.showMessageDialog(null, "id 혹은 password가 맞지 않습니다!", "로그인 실패", JOptionPane.WARNING_MESSAGE);
			return;
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

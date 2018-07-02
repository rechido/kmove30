package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class signInBtnLoginEx1 implements ActionListener {
	JDBC_Manager jdbcManager = new JDBC_Manager();	
	
	public signInBtnLoginEx1(JDBC_Manager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] options = {"확인", "취소"};
		
		JTextField idField = new JTextField();
		JPasswordField pswdField = new JPasswordField();
		JPasswordField pswd2ndField = new JPasswordField();
		//String id = idField.getText();
		//String pswd = new String(pswdField.getPassword());
		//String pswd2nd = new String(pswd2ndField.getPassword());
		
		Object[] message = new Object[6];
		message[0] = new JLabel("ID");
		message[1] = idField;
		message[2] = new JLabel("Password"); 
		message[3] = pswdField;
		message[4] = new JLabel("Password 확인");
		message[5] = pswd2ndField;
		
		while(true) {
			int result = JOptionPane.showOptionDialog(null, message,
	                "회원가입",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
			System.out.println(result);
			switch(result) { 
			   case 0: // yes 
			     //System.out.println(id.getText());
				   if( 			idField.getText().equals("")
						   || 	new String(pswdField.getPassword()).equals("") 
						   || 	new String(pswd2ndField.getPassword()).equals("")
						   ) {// 공백 존재시 에러 처리
					   JOptionPane.showMessageDialog(null, "입력하지 않은 칸이 있습니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
					   break;
				   }
				   if(checkExistingID(idField.getText())) {// 기존 아이디와 중복 검사
					   JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
					   break;
				   }				   
				   if(!(new String(pswdField.getPassword()).equals(new String(pswd2ndField.getPassword())))) { // 패스워드 체크
					   JOptionPane.showMessageDialog(null, "입력한 패스워드가 확인란과 일치하지 않습니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
					   break;
				   }
				   
				   
					   
				   String sql = "INSERT INTO member\r\n" + 
							"VALUES('"
							+ idField.getText()
							+ "', '"
							+ new String(pswdField.getPassword())
							+ "');";
				 System.out.println(sql);
					try {
						int changeRecord = jdbcManager.updateTable(sql); // JDBC_Manager 클래스의 sql update 명령어 메소드 호출
						System.out.println(changeRecord + "건이 삽입되었습니다.");
						JOptionPane.showMessageDialog(null, idField.getText() + "님 회원가입 되었습니다.", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
						return;
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				   
			     break; 
			     
			   case 1: // no 
			      return;	  
			   default: 
			     break; 
			} 
		}
	}
	
	// 아이디 중복 검사 메소드
	public boolean checkExistingID(String id) {
		String query = "select id from member";
		try {
			ResultSet rs = jdbcManager.selectTable(query);
			while(rs.next()) {				
				//System.out.println("비교= " + rs.getString(1) + " ? " + juminCD);
				if(rs.getString(1).equals(id))
					return true;
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

}

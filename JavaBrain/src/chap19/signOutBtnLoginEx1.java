package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class signOutBtnLoginEx1 implements ActionListener {
	JDBC_Manager jdbcManager = new JDBC_Manager();	
	
	public signOutBtnLoginEx1(JDBC_Manager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] options = {"확인", "취소"};
		
		JTextField idField = new JTextField();
		JPasswordField pswdField = new JPasswordField();
		
		Object[] message = new Object[4];
		message[0] = new JLabel("ID");
		message[1] = idField;
		message[2] = new JLabel("Password"); 
		message[3] = pswdField;
		
		while(true) {
			int result = JOptionPane.showOptionDialog(null, message,
	                "탈퇴할 회원정보를 입력하세요",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
			System.out.println(result);
			
			
			
			switch(result) { 
			   case 0: // yes 
			     //System.out.println(id.getText());	
				   if( 			idField.getText().equals("")
						   || 	new String(pswdField.getPassword()).equals("")
						   ) {// 공백 존재시 에러 처리
					   JOptionPane.showMessageDialog(null, "입력하지 않은 칸이 있습니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
					   break;
				   }
				   if(checkExistingID(idField.getText())) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다!", "회원탈퇴 실패", JOptionPane.WARNING_MESSAGE);
						break;
					}
					if(checkCorrectPswd(idField.getText(), new String(pswdField.getPassword()))) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다!", "회원탈퇴 실패", JOptionPane.WARNING_MESSAGE);
						break;
					}
					   
				 String sql = "delete from member where id = '"
				   		+ idField.getText()
				   		+ "';";
				 System.out.println(sql);	
				 try {
						int changeRecord = jdbcManager.updateTable(sql); // JDBC_Manager 클래스의 sql update 명령어 메소드 호출
						System.out.println(changeRecord + "건이 삭제되었습니다.");
						JOptionPane.showMessageDialog(null, idField.getText() + "님 회원탈퇴 되었습니다.", "회원탈퇴 성공", JOptionPane.INFORMATION_MESSAGE);
						return; 
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				   
			     
			     
			   case 1: // no 			      
				   return;	  
			   default: 	     
				   break;
			}
		}
	}
	
	// 삭제하려는 아이디가 존재하는지 검사
	public boolean checkExistingID(String id) {
		String query = "select id from member";
		try {
			ResultSet rs = jdbcManager.selectTable(query);
			while(rs.next()) {				
				//System.out.println("비교= " + rs.getString(1) + " ? " + juminCD);
				if(rs.getString(1).equals(id))
					return false; // 아이디 존재시 if문에 안걸리게 false반환 
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		return true; // if문에 걸림 -> if문에서 경고메시지와 함께 탈퇴 실패 처리
	}
	
	// 삭제하려는 계정의 비밀번호가 일치하는지 검사
	public boolean checkCorrectPswd(String id, String pswd) {
		String query = "select id, password from member";
		try {
			ResultSet rs = jdbcManager.selectTable(query);
			while(rs.next()) {				
				//System.out.println("비교= " + rs.getString(1) + " ? " + juminCD);
				if(rs.getString(1).equals(id) && rs.getString(2).equals(pswd))
					return false; // 비번 일치시 if문에 안걸림
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		return true; // if문에 걸림
	}
}

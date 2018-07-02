package messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignOutBtn_Login implements ActionListener {
	MybatisQuery query;		

	public SignOutBtn_Login(MybatisQuery query) {
		super();
		this.query = query;
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
						   ) // 공백 존재시 에러 처리
					   JOptionPane.showMessageDialog(null, "입력하지 않은 칸이 있습니다!", "회원탈퇴 실패", JOptionPane.WARNING_MESSAGE);
				   else if(!(query.checkExistingID(idField.getText())))
					   JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다!", "회원탈퇴 실패", JOptionPane.WARNING_MESSAGE);
				   else if(query.checkPassword(idField.getText(), new String(pswdField.getPassword())))
					   JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다!", "회원탈퇴 실패", JOptionPane.WARNING_MESSAGE);
				   else {
					   query.delete(idField.getText());
					   JOptionPane.showMessageDialog(null, idField.getText() + "님 회원탈퇴 되었습니다.", "회원탈퇴 성공", JOptionPane.INFORMATION_MESSAGE);
					   return;
				   }   
					   
				   break;
			     
			   case 1: // no 			      
				   return;	  
			   default: 	     
				   break;
			}
		}
	}
}
	

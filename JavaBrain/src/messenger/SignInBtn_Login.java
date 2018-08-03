package messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInBtn_Login implements ActionListener {
	MybatisQuery query;	

	public SignInBtn_Login(MybatisQuery query) {
		super();
		this.query = query;
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
			//System.out.println("버튼: " + result);
			switch(result) { 
			   case 0: // yes 
				   
			     //System.out.println(idField.getText() + " " + new String(pswdField.getPassword()));
				   if( 			idField.getText().equals("")
						   || 	new String(pswdField.getPassword()).equals("") 
						   || 	new String(pswd2ndField.getPassword()).equals("")
						   ) // 공백 존재시 에러 처리
					   JOptionPane.showMessageDialog(null, "입력하지 않은 칸이 있습니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
				   else if(!(new String(pswdField.getPassword()).equals(new String(pswd2ndField.getPassword()))))  // 패스워드 일치 체크
					   JOptionPane.showMessageDialog(null, "입력한 패스워드가 확인란과 일치하지 않습니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);				   
				   else if(query.checkExistingID(idField.getText())) // 아이디 중복 검사
					   JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다!", "회원가입 실패", JOptionPane.WARNING_MESSAGE);			   				   
				   else {
					   query.insertMember(idField.getText(), new String(pswdField.getPassword()));
					   JOptionPane.showMessageDialog(null, idField.getText() + "님 회원등록 되었습니다.", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
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
	

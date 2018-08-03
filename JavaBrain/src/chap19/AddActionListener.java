package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.internet.AddressException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class AddActionListener implements ActionListener {
	JTable table;
	JTextField text1, text2, text4;	
	JComboBox<String> genderSelectBox = new JComboBox<>();
	JDBC_Manager jdbcManager;	
	UpdateDataSaver saver = new UpdateDataSaver(jdbcManager);		

	public AddActionListener(JTable table, JTextField text1, JTextField text2, JTextField text4,
			JComboBox<String> genderSelectBox, JDBC_Manager jdbcManager, UpdateDataSaver saver) {
		super();
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text4 = text4;
		this.genderSelectBox = genderSelectBox;
		this.jdbcManager = jdbcManager;
		this.saver = saver;
	}

	// 문자열 내용이 숫자인지 아닌지 판별해주는 메소드 (숫자이면 true를 반환)
	public static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(
			text1.getText().equals("") 
		||	text2.getText().equals("") 
		//||	text3.getText().equals("")
		||	text4.getText().equals("")
		) {
			JOptionPane.showMessageDialog(null, "입력이 누락된 값이 있습니다!", "데이터 추가", JOptionPane.WARNING_MESSAGE);
			//System.out.println("주민번호는 반드시 입력해야 합니다!");
			return;
		}			
		else if(!(text1.getText().length() == 13)) {
			JOptionPane.showMessageDialog(null, "주민번호는 반드시 13자리여야 합니다!", "데이터 추가", JOptionPane.WARNING_MESSAGE);
			//System.out.println("주민번호는 반드시 13자리여야 합니다!");
			return;
		}		
		else if(saver.checkOverlap(text1.getText())) {
			JOptionPane.showMessageDialog(null, "입력한 주민번호가 이미 기존값 중에 있습니다!\n주민번호는 중복값을 가질 수 없습니다.", "데이터 추가", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(!(isStringDouble(text4.getText()))) {
			JOptionPane.showMessageDialog(null, "나이에는 숫자를 입력해야 합니다!", "데이터 추가", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(text4.getText().length()>3) {
			JOptionPane.showMessageDialog(null, "나이가 세자리 수를 넘습니다!", "데이터 추가", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(genderSelectBox.getSelectedItem().toString().equals("선택")) {
			JOptionPane.showMessageDialog(null, "올바른 성별을 선택해주세요!", "데이터 추가", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
			
		String arr[] = new String[4];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = genderSelectBox.getSelectedItem().toString();		
		arr[3] = text4.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr); // 레코드에 데이터 추가
		saver.setJuminCD(arr[0]);	
		//saver.printJuminCD();
				
		if(arr[2].equals("남"))
			arr[2] = "m";
		else if(arr[2].equals("여"))
			arr[2] = "f";
		
		String sql = "INSERT INTO Person (juminCD, personName, gender, age)\r\n" + 
        		"values(	'" + arr[0] + "'	,	'" + arr[1] + "' , '"+ arr[2] +"'	,	"+ arr[3] +"	);";
		System.out.println(sql);
		try {
			int changeRecord = jdbcManager.updateTable(sql); // JDBC_Manager 클래스의 sql update 명령어 메소드 호출
			System.out.println(changeRecord + "건이 삽입되었습니다.");
		}catch (Exception ex) {
			ex.getMessage();
		}
		
		
		
		//입력창 빈칸 만들기
		text1.setText(null);
		text2.setText(null);
		//text3.setText(null);
		text4.setText(null);
		text1.grabFocus(); // 이름칸으로 포커스 옮기기	
		
	}
	
//	public void actionPerformed(ActionEvent e) {
//		boolean isCheck = false; // 초기 입력창 체크 상태
//		
//		String arr[] = new String[3];
//		arr[0] = text1.getText();
//		arr[1] = text2.getText();
//		arr[2] = text3.getText();		
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		
//		for(int i = 0; i < arr.length;i++) {
//			if(arr[i].length() > 0)
//				isCheck = true;
//			else
//				isCheck = false;
//		}
//		
//		if(isCheck)
//			model.addRow(arr); // 레코드에 데이터 추가
//		
//		//입력창 빈칸 만들기
//		text1.setText(null);
//		text2.setText(null);
//		text3.setText(null);
//		
//		text1.grabFocus(); // 이름칸으로 포커스 옮기기
//		
//	}
	
}

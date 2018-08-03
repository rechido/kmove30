package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class UpdateActionListener implements ActionListener {
	JTable table;
	JDBC_Manager jdbcManager;
	UpdateDataSaver saver = new UpdateDataSaver(jdbcManager);


		public UpdateActionListener(JTable table, JDBC_Manager jdbcManager, UpdateDataSaver saver) {
		super();
		this.table = table;
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
		
		// 성별이 m, f로 입력되었는지 판별해주는 메소드
		public static boolean checkGender(String s) {
			switch(s) {
			case "남":
			case "여":
				return false;
			default:
				return true;		
			}		
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 데이터가 없습니다!", "데이터 수정", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Object value[] = new Object[4];
		for(int i=0; i< value.length; i++) {
			value[i] = table.getValueAt(row, i);
			//System.out.print(value[i].toString() + " ");
		}
		if(!(isStringDouble(value[3].toString()))) {
			JOptionPane.showMessageDialog(null, "나이에는 숫자를 입력해야 합니다!", "데이터 수정", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(value[3].toString().length()>3) {
			JOptionPane.showMessageDialog(null, "나이가 세자리 수를 넘습니다!", "데이터 수정", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(checkGender(value[2].toString())) {
			JOptionPane.showMessageDialog(null, "성별을 올바르게 입력하세요!", "데이터 수정", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String gender;
		if(value[2].toString().equals("남"))
			gender = "m";
		else
			gender = "f";
		
		String sql = "UPDATE person set "
				+ "juminCD = '" + value[0].toString()
				+ "', personName = '" + value[1].toString()
				+ "', gender = '" + gender
				+ "', age =  '" + value[3].toString()
				+ "' where juminCD = '" + saver.getJuminCD(row) // 주민번호를 바꿀 때에 대비해서 조회시 주민번호를 미리 저장한 뒤 그걸 참조
				+ "';";
		
		System.out.println(sql);
		
		try {
			int changeRecord = jdbcManager.updateTable(sql); // JDBC_Manager 클래스의 sql update 명령어 메소드 호출
			System.out.println(changeRecord + "건이 수정되었습니다.");
			saver.updateJuminCD(row, value[0].toString());
			//saver.printJuminCD();
		}catch (Exception ex) {
			ex.getMessage();
		}

				
		

	}

}

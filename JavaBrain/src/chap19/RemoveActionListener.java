package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class RemoveActionListener implements ActionListener {
	JTable table;
	JDBC_Manager jdbcManager;		
	UpdateDataSaver saver = new UpdateDataSaver(jdbcManager);
	
	public RemoveActionListener(JTable table, JDBC_Manager jdbcManager, UpdateDataSaver saver) {
		super();
		this.table = table;
		this.jdbcManager = jdbcManager;
		this.saver = saver;
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 데이터가 없습니다!", "데이터 삭제", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		// confirm이 0이면 yes, 1이면 no
		if(confirm==1)
			return;
		
		Object value = table.getValueAt(row, 0);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);
		saver.removeJuminCD(row);
		//saver.printJuminCD();
		
		String sql = "DELETE from person where juminCD = '" + value.toString() + "';";
		try {
			int changeRecord = jdbcManager.updateTable(sql); // JDBC_Manager 클래스의 sql update 명령어 메소드 호출
			System.out.println(changeRecord + "건이 삭제되었습니다.");
			
		}catch (Exception ex) {
			ex.getMessage();
		}
		
		
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		model.setNumRows(0);

	}

}

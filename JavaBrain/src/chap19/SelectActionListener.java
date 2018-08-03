package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class SelectActionListener implements ActionListener {
	JTable table;	
	JDBC_Manager jdbcManager;
	UpdateDataSaver saver = new UpdateDataSaver(jdbcManager);
	
	public SelectActionListener(JTable table, JDBC_Manager jdbcManager, UpdateDataSaver saver) {
		super();
		this.table = table;
		this.jdbcManager = jdbcManager;
		this.saver = saver;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String query = "select juminCD, personName, age, gender from person";
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		saver.removeAllJuminCD();
		try {
			ResultSet rs = jdbcManager.selectTable(query);
			
			rs.last(); // 커서를 레코드 셋 마지막 행으로 이동
			int rowCount = rs.getRow();
			//System.out.println("레코드 갯수: " + rowCount);
			if(rowCount==0) {
				JOptionPane.showMessageDialog(null, "조회된 레코드가 없습니다!", "조회 결과", JOptionPane.WARNING_MESSAGE);
				//System.out.println("조회된 레코드가 없습니다!");
				return;
			}
			rs.beforeFirst(); // 커서를 레코드 셋 처음 행으로 이동
			
			while(rs.next()) {
				String arr[] = new String[4];
				arr[0] = rs.getString("juminCD");
				arr[1] = rs.getString("personName");
				if(rs.getString("gender").equals("m"))
					arr[2] = "남";
				else if(rs.getString("gender").equals("f"))
					arr[2] = "여";
				arr[3] = String.valueOf(rs.getInt("age"));			
				
				model.addRow(arr);
				saver.setJuminCD(arr[0]);
			}
			//saver.printJuminCD();
			
			
		}catch (Exception ex) {
			ex.getMessage();
		}
		
	}

}

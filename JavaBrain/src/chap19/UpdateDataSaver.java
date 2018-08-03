package chap19;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.kosea.kmove30.JDBC_Manager;

public class UpdateDataSaver {	
	JDBC_Manager jdbcManager;	
	
	public UpdateDataSaver(JDBC_Manager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
	}

	ArrayList<String> juminCD = new ArrayList<String>(1);
	int row = -1;
	public String getJuminCD(int row) {
		if(row==-1) {
			//System.out.println("선택된 행이 없습니다.");
			return null;
		}
		return juminCD.get(row);
	}

	public void setJuminCD(String juminCD) {
		this.juminCD.add(juminCD);
	}
	
	public void removeAllJuminCD() {
		if(juminCD.size()==0)
			return;
		this.juminCD.clear();
	}
	
	public void removeJuminCD(int row) {
		this.juminCD.remove(row);
	}
	
	public void printJuminCD() {
		for(int i=0; i<juminCD.size(); i++)
			System.out.println(juminCD.get(i));
	}
	
	public void updateJuminCD(int row, String s) {
		this.juminCD.set(row, s);
	}
	
	public boolean checkOverlap(String juminCD) {		
		//System.out.println("입력값: " + juminCD);
		String query = "select juminCD from person";
		try {
			ResultSet rs = jdbcManager.selectTable(query);
			while(rs.next()) {				
				//System.out.println("비교= " + rs.getString(1) + " ? " + juminCD);
				if(rs.getString(1).equals(juminCD))
					return true;
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
	

	
	
	
}

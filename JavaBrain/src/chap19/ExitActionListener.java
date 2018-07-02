package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.kosea.kmove30.JDBC_Manager;

public class ExitActionListener implements ActionListener {
	JDBC_Manager jdbcManager;
	JFrame frame;
	
	public ExitActionListener(JDBC_Manager jdbcManager, JFrame frame) {
		super();
		this.jdbcManager = jdbcManager;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			jdbcManager.closeDB();			
		}catch (Exception ex) {
			ex.getMessage();
		}		
		frame.dispose();
		return;
	}

}

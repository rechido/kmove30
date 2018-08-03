package chap19;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyMouseListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		JTable table = (JTable)e.getSource();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		Object value[] = new Object[4];
		for(int i=0; i< value.length; i++) {
			value[i] = table.getValueAt(row, i);
			System.out.print(value[i].toString() + " ");
		}
		System.out.println();
				
	
		
		
	}
	

}

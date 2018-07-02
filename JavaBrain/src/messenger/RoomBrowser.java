package messenger;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import chap19.AddActionListener;
import chap19.ExitActionListener;
import chap19.RemoveActionListener;
import chap19.SelectActionListener;
import chap19.UpdateActionListener;

public class RoomBrowser {
	
	public RoomBrowser() {
		JFrame frame = new JFrame("대화방 브라우저");
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setLocation(500, 400);
		
		Container contentPane = frame.getContentPane();
		String colNames[] = { "방제목", "대화명", "인삿말" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 80));		
		
		JButton createRoomBtn = new JButton("대화방생성");
		JButton getinRoomBtn = new JButton("대화방참가");
		JButton exitBtn = new JButton("종료");
		JButton nicknameBtn = new JButton("대화명변경");
		panel.add(createRoomBtn);
		panel.add(getinRoomBtn);
		panel.add(nicknameBtn);
		panel.add(exitBtn);		
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		// 버튼 이벤트
		createRoomBtn.addActionListener(null);
		getinRoomBtn.addActionListener(null);		
		nicknameBtn.addActionListener(null);
		exitBtn.addActionListener(null);		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}

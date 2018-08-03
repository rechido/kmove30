/**
 * 2018. 5. 31. Dev. by D. A. Lee
 */
package messenger;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class TeacherMessengerClient {
	String id;
	InputStream input;	
	Socket socket;
	Thread receiver;
	
	
	public TeacherMessengerClient(String id) {
		super();
		this.id = id;		
		
		JFrame frame = new JFrame("메신저");
		frame.setPreferredSize(new Dimension(300, 500));
		frame.setLocation(0, 0);
		Container backgroundLayer = frame.getContentPane();
		
		JPanel chatterWindow = new JPanel();
		JPanel displayWindow = new JPanel();
		JPanel typingWindow = new JPanel();
		
		chatterWindow.setPreferredSize(new Dimension(290, 100));
		displayWindow.setPreferredSize(new Dimension(290, 300));
		typingWindow.setPreferredSize(new Dimension(290, 100));
		
		// 대화방 참여 인원창
		String colNames[] = { "ID", "대화명", "상태" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable chatterTable = new JTable(model);
		JScrollPane scrollchatterTable = new JScrollPane(chatterTable);
		scrollchatterTable.setPreferredSize(new Dimension(290, 100));
		chatterWindow.add(scrollchatterTable, BorderLayout.CENTER);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//table.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		
		// 채팅내용 출력창
		JTextArea displayField = new JTextArea(50, 25);		
		displayField.setText("Welcome to the Messenger Dev. by D. E. Lee");
		displayField.setEditable(false);
		//JScrollPane ScrollDisplayField = new JScrollPane(displayField);
		displayWindow.add(displayField, BorderLayout.NORTH);
		
		// 채팅입력창
		JTextArea typingField = new JTextArea(5, 18);
		JPanel btnPanel = new JPanel();
		BoxLayout layout = new BoxLayout(btnPanel, BoxLayout.Y_AXIS);
		btnPanel.setLayout(layout);
		
		typingWindow.add(typingField, BorderLayout.WEST);
		typingWindow.add(btnPanel, BorderLayout.EAST);
		
		// 버튼패널
		JButton enterChatBtn = new JButton("입력");
		JButton enterQuizBtn = new JButton("문제");
		btnPanel.add(enterChatBtn);
		btnPanel.add(enterQuizBtn);
		
		
		backgroundLayer.add(chatterWindow, BorderLayout.NORTH);
		backgroundLayer.add(displayWindow, BorderLayout.CENTER);
		backgroundLayer.add(typingWindow, BorderLayout.SOUTH);
		
		try {
			socket = new Socket("192.168.0.13", 9000);
			receiver = new ReceiverThread(socket, displayField);
			receiver.start();
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(id);
			writer.flush();
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}		

		// 버튼 이벤트
		enterChatBtn.addActionListener(new EnterChat_Messenger(displayField, typingField, id, socket));
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		//frame.setLocationRelativeTo(null);
	}

	

}

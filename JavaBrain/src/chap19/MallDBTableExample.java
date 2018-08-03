package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class MallDBTableExample {
	JDBC_Manager jdbcManager = new JDBC_Manager();

	public MallDBTableExample(JDBC_Manager jdbcManager) {
		super();
		this.jdbcManager = jdbcManager;
		
		UpdateDataSaver saver = new UpdateDataSaver(jdbcManager);
		
		JFrame frame = new JFrame("참가자 명단 프로그램");
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setLocation(500, 400);
		
		Container contentPane = frame.getContentPane();
		String colNames[] = { "주민번호", "이름", "성별", "나이" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 80));
		
		JPanel panel1 = new JPanel();
		JTextField text1 = new JTextField(8);
		JTextField text2 = new JTextField(4);
		//JTextField text3 = new JTextField(2);		
		JTextField text4 = new JTextField(2);		
		
		// 콤보박스
		String[] genderList = {"선택", "남", "여"};
		JComboBox<String> genderSelectBox = new JComboBox<>(genderList);
		
		panel1.add(new JLabel("주민번호"));
		panel1.add(text1);
		panel1.add(new JLabel("이름"));		
		panel1.add(text2);
		panel1.add(new JLabel("성별"));		
		//panel1.add(text3);
		panel1.add(genderSelectBox);
		panel1.add(new JLabel("나이"));
		panel1.add(text4);
		panel.add(panel1, BorderLayout.NORTH);
		
		
		JPanel panel2 = new JPanel();
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		JButton selectBtn = new JButton("조회");
		JButton exitBtn = new JButton("종료");
		JButton updateBtn = new JButton("수정");
		panel2.add(selectBtn);
		panel2.add(button1);
		panel2.add(updateBtn);
		panel2.add(button2);
		panel2.add(exitBtn);		
		panel.add(panel2, BorderLayout.SOUTH);
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		// 버튼 이벤트
		genderSelectBox.addActionListener(null);
		text4.addActionListener(new AddActionListener(table, text1, text2, text4, genderSelectBox, jdbcManager, saver));		
		button1.addActionListener(new AddActionListener(table, text1, text2, text4, genderSelectBox, jdbcManager, saver));
		button2.addActionListener(new RemoveActionListener(table, jdbcManager, saver));
		selectBtn.addActionListener(new SelectActionListener(table, jdbcManager, saver));
		
		exitBtn.addActionListener(new ExitActionListener(jdbcManager, frame));
		updateBtn.addActionListener(new UpdateActionListener(table, jdbcManager, saver));
		
		// 마우스 이벤트
		//table.addMouseListener(new MyMouseListener());
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		text1.grabFocus();
		
		System.out.println("프로그램 시작");
		

		
//		try {
//			jdbcManager.connectDB("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3307/malldb", "root", "12345");
//			frame.setTitle("참가자 명단 프로그램 - DB 접속중");
//			System.out.println("데이터베이스에 접속했습니다.");
//		}catch (ClassNotFoundException cnfe) {
//			System.out.println("해당 클래스를 찾을 수 없습니다." + 
//                    cnfe.getMessage());
//			frame.setTitle("참가자 명단 프로그램 - DB 접속 실패");
//		}catch (SQLException se) {
//			System.out.println(se.getMessage());
//			frame.setTitle("참가자 명단 프로그램 - DB 접속 실패");
//		}catch (Exception e) {
//			e.getMessage();
//			frame.setTitle("참가자 명단 프로그램 - DB 접속 실패");
//		}
	}
	

}

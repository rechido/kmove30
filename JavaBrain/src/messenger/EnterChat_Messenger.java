package messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class EnterChat_Messenger implements ActionListener {
	JTextArea displayField;
	JTextArea typingField;	
	String id;
	Socket socket;	
	
	public EnterChat_Messenger(JTextArea displayField, JTextArea typingField, String id, Socket socket) {
		super();
		this.displayField = displayField;
		this.typingField = typingField;
		this.id = id;
		this.socket = socket;
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			InputStream input = new ByteArrayInputStream(typingField.getText().getBytes("UTF-8"));
			Thread thread1 = new SenderThread(socket, input);
			thread1.start();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		

	}

}

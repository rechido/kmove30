package messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class ReceiverThread extends Thread {
	Socket socket;
	JTextArea displayField;

	public ReceiverThread(Socket socket, JTextArea displayField) {
		super();
		this.socket = socket;
		this.displayField = displayField;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				System.out.println(str);
				displayField.append("\n"+ str);
			}
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
		
}

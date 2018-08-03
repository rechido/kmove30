package ch20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverThread extends Thread {
	Socket socket;
	

	public ReceiverThread(Socket socket) {
		super();
		this.socket = socket;
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
			}
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
		
}
	



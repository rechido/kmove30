package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SenderThread2 extends Thread {
	Socket socket;
	String name;
	
	public SenderThread2(Socket socket, String name) {
		super();
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(name);
			writer.flush();
			
			while(true) {
				String str = reader.readLine();
				if(str.equals("bye"))
					break;
				writer.println(str);
				writer.flush();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}catch (Exception ignored) {
			}
		}
		
		
	}
	

}

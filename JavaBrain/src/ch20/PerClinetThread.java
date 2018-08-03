package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class PerClinetThread extends Thread {
	static ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
	Socket socket;
	PrintWriter writer;
	
	public PerClinetThread(Socket socket) {
		super();
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
				for(PrintWriter writer : list) {
					writer.println(str);
					writer.flush();
				}
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		finally {
			list.remove(writer);
			try {
				socket.close();
			}catch (Exception ignored) {
			}
		}
		
		
	}
	
	

}

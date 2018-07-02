package messenger;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() {
		System.out.println("server start");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9000); 
			while(true) {
				Socket socket = serverSocket.accept();
				Thread thread = new PerClientThread(socket);
				thread.start();
			}			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

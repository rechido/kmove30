/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample4 {
	public static void main(String[] args) {
		System.out.println("server start");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9002); 
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

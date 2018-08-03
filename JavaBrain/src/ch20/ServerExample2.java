/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {

	public static void main(String[] args) {
System.out.println("server start");
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000); 
			socket = serverSocket.accept();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			String str = reader.readLine();
			System.out.println(str);
			
			writer.println("Hello, Client");
			//writer.flush();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}catch (Exception ignored) {
			}
			try {
				serverSocket.close();
			}catch (Exception ignored) {
			}
		}

	}

}

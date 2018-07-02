/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample2 {
	public static void main(String[] args) {
		System.out.println("client start");
		Socket socket = null;
		try {
			socket = new Socket("0.0.0.0", 9000); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			writer.println("Hello, Server");
			writer.flush();
			
			String str = reader.readLine();
			System.out.println(str);
			
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

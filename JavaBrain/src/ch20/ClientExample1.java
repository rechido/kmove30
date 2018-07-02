/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample1 {

	public static void main(String[] args) {
		System.out.println("client start");
		Socket socket = null;
		try {
			socket = new Socket("0.0.0.0", 9000); 
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			
			String str = "Hello, Server";
			out.write(str.getBytes());
			
			
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}catch (Exception e) {
			}
		}
	}

}

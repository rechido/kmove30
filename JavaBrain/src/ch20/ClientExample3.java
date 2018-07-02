/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.net.Socket;

public class ClientExample3 {
	public static void main(String[] args) {
		System.out.println("client start");
		Socket socket = null;
		try {
			socket = new Socket("0.0.0.0", 9001);
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

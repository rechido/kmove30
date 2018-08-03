/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.net.Socket;

public class ClientExample4 {
	public static void main(String[] args) {
		System.out.println("client start");
		if(args.length != 1) {
			System.out.println("Usage: java ClientExample4 <user-name>");
			return;
		}		
		
		try {
			Socket socket = new Socket("0.0.0.0", 9002);
			Thread thread1 = new SenderThread2(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

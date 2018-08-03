package ch20;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransferExample {

	public static void main(String[] args) {

	}

}

class ClientThread1 extends Thread {
	Socket socket = null;

	@Override
	public void run() {
		try {
			socket = new Socket("0.0.0.0", 9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}

	}
}

class ServerThread1 extends Thread {
	@Override
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
			try {
				serverSocket.close();
			} catch (Exception e) {
			}
		}
	}
}
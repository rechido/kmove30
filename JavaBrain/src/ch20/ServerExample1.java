/**
 * 2018. 6. 4. Dev. by D. A. Lee
 */
package ch20;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {

	// 포트 가용성 테스트 메소드
	public static boolean isTcpPortAvailable(int port) {
		try (ServerSocket serverSocket = new ServerSocket()) {
			// setReuseAddress(false) is required only on OSX,
			// otherwise the code will not work correctly on that platform
			serverSocket.setReuseAddress(false);
			serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 0;

		try {
			for (int cnt = 9000; cnt < 10000; cnt++) {
				if (isTcpPortAvailable(cnt)) {
					serverSocket = new ServerSocket(cnt);
					port = serverSocket.getLocalPort();
					System.out.println(port);
					break;
				} else if(cnt <=10000) {
					System.out.println("port: " + cnt + "가 사용불가");
				} else {
					System.out.println("사용 가능한 포트가 없습니다.");
					return;
				}
			}

			socket = serverSocket.accept();
			// System.out.println("소켓이 닫혀있는가? " + serverSocket.isClosed());
			System.out.println("server start");
			socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));

			String str = "Hello, Client";
			out.write(str.getBytes());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				System.out.println("생성한 포트번호: " + port);
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

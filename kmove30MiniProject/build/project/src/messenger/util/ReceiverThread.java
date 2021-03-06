package messenger.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.log4j.Logger;

import javafx.scene.control.TextArea;

public class ReceiverThread extends Thread {
	private Socket socket;
	private TextArea chatDisplayArea;
	private Logger log = Logger.getLogger(this.getClass());

	public ReceiverThread(Socket socket, TextArea chatDisplayArea) {
		super();
		this.socket = socket;
		this.chatDisplayArea = chatDisplayArea;
	}

	@Override
	public void run() {
		super.run();
		log.info("리시버 스레드 시작.");

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String str = reader.readLine();
				if (str == null) {
					log.info("리시버 스레드 종료.");
					break;
				}

				chatDisplayArea.appendText(str + "\n");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			log.info("리시버 스레드 종료.");
		}

	}

}

package basicExamples;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressExample {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();

			String ip = local.getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}

	}

}

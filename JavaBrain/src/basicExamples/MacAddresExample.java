package basicExamples;

public class MacAddresExample {

	public static void main(String[] args) {
		try {
			Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
			String line;
			line = in.readLine();
			String[] result = line.split(",");

			System.out.println(result[0].replace('"', ' ').trim());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

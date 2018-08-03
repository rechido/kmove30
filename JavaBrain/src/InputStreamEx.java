import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamEx {

	public static void main(String[] args) {
		String contents = "아휴";
		try {
			InputStream input = new ByteArrayInputStream(contents.getBytes("UTF-8"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			System.out.println(reader.readLine());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("뭔데");
		}
		
		

	}

}

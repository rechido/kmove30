/**
 * 2018. 7. 2. Dev. by D. A. Lee
 */
package chap10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample1 {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("poem.txt");
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				System.out.print(ch);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
			}
		}

	}

}

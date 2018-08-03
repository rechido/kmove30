package chap10;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataSaverProgram {

	public static void main(String[] args) {
		DataOutputStream out = null;
		String str = "1. 동해물과 백두산이 마르고 닳도록 \r\n" + 
				"하느님이 보우하사 우리나라 만세\r\n" + 
				"무궁화 삼천리 화려 강산\r\n" + 
				"대한 사람 대한으로 길이 보전하세";
		try {
			out = new DataOutputStream(new FileOutputStream("output.dat"));
			out.writeChars(str);
			System.out.println("파일 출력중.");
		}
		catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		}
		finally {
			try {
				out.close();
				System.out.println("파일 출력 완료.");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}

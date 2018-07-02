/**
 * 2018. 5. 14. Dev. by D. A. Lee
 */
package chap09;

import java.util.StringTokenizer;

public class StringTokenizerExample1 {
	public static void main(String[] args) {
//		String stt = "사과;배;복숭아;귤";
//		System.out.println(stt);
//		StringTokenizer stok = new StringTokenizer(stt, ";");
//		while(stok.hasMoreTokens()) {
//			String str = stok.nextToken();
//			System.out.println(str);
//		}
		
//		String stt2 = "고슴도치,앵무새|토끼";
//		System.out.println(stt2);
//		StringTokenizer stok2 = new StringTokenizer(stt2, ",|");
//		while(stok2.hasMoreTokens()) {
//			String str = stok2.nextToken();
//			System.out.println(str);
//		}
		
		String stt3 = "사과=10|초콜렛=3|샴페인=1";
		System.out.println(stt3);
		StringTokenizer stok3 = new StringTokenizer(stt3, "=|", true);
		while(stok3.hasMoreTokens()) {
			String token = stok3.nextToken();
			if(token.equals("="))
				System.out.print("\t");
			else if(token.equals("|"))
				System.out.print("\n");
			else
				System.out.print(token);
		}

	}

}

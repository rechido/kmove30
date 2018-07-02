/**
 * 2018. 5. 11. Dev. by D. A. Lee
 */
package chap09;

public class StringIndexer {
	public static void main(String[] args) {
		String str = "꽃나무는 제가 생각하는 꽃나무를 " + "열심으로 생각하는 것처럼 열심으로 꽃을 피워가지고 섰소";
		System.out.println(str.indexOf('꽃'));
		System.out.println(str.indexOf('꽃',3));
		System.out.println(str.indexOf("꽃나무"));
		System.out.println(str.indexOf("꽃나무",3));
		System.out.println(str.lastIndexOf('꽃'));
		System.out.println(str.lastIndexOf('꽃',20));
		System.out.println(str.lastIndexOf("꽃나무"));
		System.out.println(str.lastIndexOf("꽃나무",20));
		
		StringBuffer sb = new StringBuffer("Java");
		System.out.println(sb);
		sb.replace(0, 4, "C#");
		System.out.println(sb);
		

	}

}

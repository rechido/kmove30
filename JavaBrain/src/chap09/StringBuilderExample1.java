/**
 * 2018. 5. 14. Dev. by D. A. Lee
 */
package chap09;

public class StringBuilderExample1 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("역사를 하노라고 맨땅을 파다가 ");		
		//StringBuilder sb = new StringBuilder("역사를");	
		System.out.println(sb.capacity());	
		sb.ensureCapacity(100);
		System.out.println(sb);
		System.out.println(sb.append("커다란 고인돌을 끄집어 내어놓고 보니"));		
		System.out.println(sb.capacity());
		System.out.println(sb.insert(26,"하나 "));		
		System.out.println(sb.capacity());		
		System.out.println(sb.delete(21,23));		
		System.out.println(sb.capacity());		
		System.out.println(sb.deleteCharAt(9));		
		System.out.println(sb.capacity());
		System.out.println(sb.reverse());
		System.out.println(sb.reverse());
		System.out.println(sb.replace(16, 19, "조그마한"));
		sb.setCharAt(5, '느');
		System.out.println(sb);
		sb.trimToSize();
		System.out.println(sb.capacity());
		
		

	}

}

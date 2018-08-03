/**
 * 2018. 5. 23. Dev. by D. A. Lee
 */
package chap11;

public class ObjectExample2 {
	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
		System.out.println(obj); // obj.toString() 호출
		String str = obj.toString();
		System.out.println(str);
		
		System.out.println("재고정보 = " + obj.toString());
		
		String str2 = "재고정보 = " + obj; // obj만 호출해도 toString이 자동 호출
		System.out.println(str2); 

	}

}

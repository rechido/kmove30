/**
 * 2018. 7. 2. Dev. by D. A. Lee
 */
package chap12;

public class WrapperExample1 {
	public static void main(String[] args) {
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		int sum = obj1.intValue() + obj2.intValue();
		System.out.println(sum);
		
		System.out.println(obj1.MAX_VALUE);
		System.out.println(obj2.MIN_VALUE);

	}

}

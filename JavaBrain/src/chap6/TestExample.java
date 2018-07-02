/**
 * 2018. 5. 23. Dev. by D. A. Lee
 */
package chap6;

public class TestExample {
	public static void main(String[] args) {
		Lendable arr[] = {
				new AppCDInfo("2005-7001", "Redhat Fedora"),
				new SeparateVolume("859ㅂ986ㅊ", "책상은 책상이다", "빅셀")
		};
		checkOutAll(arr, "김수진", "20060318");
				

	}
	
	static void checkOutAll(Lendable arr[], String borrower, String date) {
		for(Lendable obj : arr) {
			try {
				obj.checkOut(borrower, date);
				System.out.println("대출인: " + borrower);
				System.out.println("대출일: " + date);
			}
			catch(Exception e) {
				
			}
			
		}
	}

}

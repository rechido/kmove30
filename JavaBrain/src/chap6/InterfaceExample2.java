/**
 * 2018. 5. 18. Dev. by D. A. Lee
 */
package chap6;

public class InterfaceExample2 {
	public static void main(String[] args) {
		Lendable arr[] = new Lendable[3];
		arr[0] = new SeparateVolume("883ㅇ326ㅍ2", "푸코의 진자", "에코");
		arr[1] = new SeparateVolume("609.2ㄱ428ㅅ", "서양마술사", "곰브리치");
		arr[2] = new AppCDInfo("2002-1742", "XML을 위한 자바 프로그래밍");
		checkOutAll(arr, "윤지혜", "20060315");

	}
	
	static void checkOutAll(Lendable arr[], String borrower, String date) {
		for(int cnt = 0; cnt < arr.length; cnt++)
			arr[cnt].checkOut(borrower, date);
	}

}

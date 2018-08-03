package chap6;

public interface Lendable {
	final static byte STATE_BORROWED = 1; // interface에서는 상수 필드만 정의가능
	byte STATE_NORMAL = 0; // final static 생략해도 됨
	abstract void checkOut(String borrower, String date) 
			//throws Exception
			; // 인터페이스의 메소드는 무조건 abstract, public
	void checkIn(); // abstract 생략해도 됨

}

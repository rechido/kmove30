package chap6;

public class AppCDInfo extends CDInfo implements Lendable{
	public String borrower;
	public String checkOutDate;
	byte state; // 대출 상태를 판단

	public AppCDInfo(String registerNo, String title) {
		super(registerNo, title);
	}

	@Override
	public void checkOut(String borrower, String date) {
		if(state != STATE_NORMAL) { // 재고가 없을 시 작업취소
			System.out.println(super.title + "의 재고가 없습니다.\n");
			return;
		}
			
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = STATE_BORROWED; // state=1 이면 대출된 상태
		System.out.println("*" + super.title + " CD가 대출되었습니다.");
		System.out.println("대출인: " + borrower);
		System.out.println("대출일: " + date + "\n");

	}

	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = STATE_NORMAL; // state=0 이면 대출가능 상태 (재고보유)
		System.out.println("*" + super.title + " CD가 반납되었습니다.");
		System.out.println();

	}


}

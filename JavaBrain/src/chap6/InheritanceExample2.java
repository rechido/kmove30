/**
 * 2018. 5. 16. Dev. by D. A. Lee
 */
package chap6;

class CheckingAccount2 extends CheckingAccount{
		
	public CheckingAccount2() {
		System.out.println("CheckingAccount() 기본생성자");
	}
	
	CheckingAccount2(String accountNo, String ownerName, int balance, String cardNo){
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		this.cardNo = cardNo;
	}
	
}

public class InheritanceExample2 {
	public static void main(String[] args) {
		CheckingAccount2 acc1 = new CheckingAccount2("111-22-33333333", "홍길동", 0, "5555-6666-7777-8888");
		acc1.deposit(100000);
		
		try {
			int paidAmount = acc1.pay("5555-6666-7777-8888", 47000);
			System.out.println("지불액: " + paidAmount);
			System.out.println("잔액: " + acc1.balance);
		}
		catch(Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
			//System.out.println(e.hashCode());
			//System.out.println(e);
		}
		

	}

}

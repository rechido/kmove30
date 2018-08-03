/**
 * 2018. 5. 16. Dev. by D. A. Lee
 */
package chap6;

class Account{
	String accountNo;
	String ownerName;
	int balance;
	
//	public Account() {
//		System.out.println("Account() 기본생성자");
//	}
		
	void deposit(int amount) {
		balance += amount;
	}
	
	int withdraw(int amount) throws Exception {
		if(balance < amount)
			throw new Exception("잔액이 부족합니다.");
		balance -= amount;
		return amount;
	}
}

class CheckingAccount extends Account{
	String cardNo;
	
	public CheckingAccount() {
		System.out.println("CheckingAccount() 기본생성자");
	}
	
	int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo))
			throw new Exception("계좌번호가 잘못되었습니다.");
		if(balance<amount)
			throw new Exception("잔액이 부족합니다.");
		return withdraw(amount);
	}
}

public class InheritanceExample1 {
	public static void main(String[] args) {
		CheckingAccount acc1 = new CheckingAccount();
		
		acc1.accountNo = "111-22-33333333";
		acc1.ownerName = "홍길동";
		acc1.cardNo = "5555-6666-7777-8888";
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

/**
 * 2018. 5. 16. Dev. by D. A. Lee
 */
package chap6;

class Account3{
	String accountNo;
	String ownerName;
	int balance;		
	
//	public Account3() {
//		System.out.println("Account() 기본생성자");
//	}
		
	Account3(String accountNo, String ownerName, int balance){
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	int displayBalance() {
		//System.out.println("잔액: " + balance);
		return balance;
	}
	
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

class CheckingAccount3 extends Account3{
	String cardNo;
	
	CheckingAccount3(String accountNo, String ownerName, int balance, String cardNo){
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo; 
	}
	
	int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo))
			throw new Exception("계좌번호가 잘못되었습니다.");
		if(balance<amount)
			throw new Exception("잔액이 부족합니다.");
		return withdraw(amount);
	}
}

public class InheritanceExample3 {
	public static void main(String[] args) {
		CheckingAccount3 acc1 = new CheckingAccount3("111-22-33333333", "홍길동", 100000, "5555-6666-7777-8888");
		
		//Account3 acc = new Account3();
		
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

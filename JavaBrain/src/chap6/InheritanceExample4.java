/**
 * 2018. 5. 16. Dev. by D. A. Lee
 */
package chap6;

class CreditLineAccount extends Account3{
	int creditLine;
	
	 CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	 
	 int displayCreditLine() {
		 return creditLine;
	 }
	
	 int withdraw(int amount) throws Exception {
		if(balance + creditLine < amount)
			throw new Exception("인출한도를 초과하였습니다.");
		balance -= amount;
		return amount;
	}
}

public class InheritanceExample4 {
	public static void main(String[] args) {
		CreditLineAccount acc = new CreditLineAccount("000-11-111111", "김선달", 10000, 100000);
		try {
			int amount = acc.withdraw(50000);
			System.out.println("인출액: " + amount);
			
			int balance = acc.displayBalance();
			System.out.println("잔액:" + balance);
			
			int creditLine = acc.creditLine;
			System.out.println("마이너스 한도:" + creditLine);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

package chap6;

class BonusPointAccount extends Account3{
	int bonusPoint;
	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint){
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	@Override
	void deposit(int amount) {
		// TODO Auto-generated method stub
		super.deposit(amount);
		bonusPoint += (int)(amount*0.001);
	}
	
	
}

public class InheritanceExample5 {
	public static void main(String[] args) {
		BonusPointAccount acc = new BonusPointAccount("333-33-3333333", "김미영", 0, 0);
		acc.deposit(1000000);
		System.out.println("잔액: " + acc.balance);
		System.out.println("누적 포인트: " + acc.bonusPoint);
		
	}
}

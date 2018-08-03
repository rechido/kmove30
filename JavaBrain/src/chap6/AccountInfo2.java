package chap6;

public class AccountInfo2 {

	public static void main(String[] args) {
		Account3 obj = new Account3("999-88-777777", "연흥부", 10);
		System.out.printf("계좌번호: %s\n", obj.accountNo);
		System.out.printf("예금주 이름: %s\n", obj.ownerName);
		System.out.printf("잔액: %d\n", obj.balance);

	}

}

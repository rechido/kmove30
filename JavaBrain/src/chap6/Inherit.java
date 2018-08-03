/**
 * 2018. 5. 15. Dev. by D. A. Lee
 */
package chap6;

class Perent{
	int money;
	
	public Perent() {
		// 기본 생성자
		System.out.println("부모클래스에 기본생성자 Perent() 호출");
		this.money = 300000000;
	}
	
	public Perent(int money) {
		this.money = money;
		System.out.println("부모클래스에 생성자 Perent(int money) 호출");
		
	}
	
	public void displayMoney() {
		System.out.println("재산 = " + this.money);
		//return money;
	}
	
}

class Child extends Perent{
	
	public Child() {
		System.out.println("자식클래스에 기본생성자 Perent() 호출");
		super.displayMoney();
	}
	
	
}

public class Inherit {
	public static void main(String[] args) {
		
		Perent pnt = new Perent(1000000000);
		System.out.println(pnt.money);
		pnt.displayMoney();
		
		Child child = new Child();
//		System.out.println(child.money);
//		child.displayMoney();
		
		
		
	}

}

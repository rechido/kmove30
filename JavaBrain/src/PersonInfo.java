/**
 * 2018. 5. 3. Dev. by D. A. Lee
 */

public class PersonInfo {

	public static void main(String[] args) {
		
//		 매개변수 없는 디폴트 생성자 호출하여 객체 생성
		Person person; 
//		person = new Person();
		
		// 매개변수 1개 있는 생성자 호출하여 객체 생성
//		person = new Person("이다은");
		
		// String 매개변수, int 매개변수 있는 생성자 호출하여 객체 생성
		person = new Person("이다은", 20);
		
		person.showPerson();
		
		// System.out.println(person);
		
		Person person2 = new Person(21, "고등어");
		
		person2.showPerson(person2);

	}

}

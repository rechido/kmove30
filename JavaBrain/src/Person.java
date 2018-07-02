/**
 * 2018. 5. 3. Dev. by D. A. Lee
 */

public class Person {
	
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name) {
		this. name = name;
	}
	
	public Person(String name, int age) {
		this. name = name;
		this. age = age;
		
	}
	
	public Person(int age, String name) {
		this. name = name;
		this. age = age;
	}
	
	public void showPerson() {
		System.out.println("이름: " + name + " 나이: " + age);
	}
	
	public void showPerson(Person obj) {
		System.out.println("이름은: " + name);
		System.out.println("나이는: " + age + "입니다.");
		
		obj.name = "김철수";
		obj.age = 10;
	}

}

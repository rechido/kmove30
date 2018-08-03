/**
 * 2018. 5. 2. Dev. by D. A. Lee
 */

public class Circle {
	
	int radius;
	String name;
	
	public Circle(){
		this.radius = 1;
		this.name = "";
	}
	
	public Circle(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	


	public static void main(String[] args) {
		
		Circle pizza;
		pizza = new Circle();
		pizza.radius = 10;
		pizza.name = "자바피자";
		System.out.println(pizza.name + "의 면적은 " + pizza.getArea());
		
		Circle donut = new Circle(2, "자바도넛");
		System.out.println(donut.name + "의 면적은 " + donut.getArea());
		
				
	}

}

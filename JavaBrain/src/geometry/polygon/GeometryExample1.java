/**
 * 2018. 5. 23. Dev. by D. A. Lee
 */
package geometry.polygon;

public class GeometryExample1 {
	public static void main(String[] args) {
		Square obj1 = new Square(10);
		System.out.println("obj1의 길이: " + obj1.getWidth());
		System.out.println("obj1의 높이: " + obj1.getHeight());
		System.out.println("obj1의 둘레: " + obj1.getPerimeter());
	}

}

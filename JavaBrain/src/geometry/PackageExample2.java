/**
 * 2018. 5. 11. Dev. by D. A. Lee
 */
package geometry;
import geometry.polygon.Rectangle;

public class PackageExample2 {
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(2, 3);
		System.out.println("넓이 = " + rec.width);
		System.out.println("높이 = " + rec.height);
		System.out.println("면적 = " + rec.getArea());

	}

}

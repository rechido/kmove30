package geometry.polygon;

public class Square extends Rectangle {

	public Square(int sideLength) {
		super(sideLength, sideLength);
	}
	
	int getPerimeter() {
		return (getWidth() + getHeight())*2;
	}	

}

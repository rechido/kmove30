package chap12;

public class MaxValue {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("Usage: java MaxValue <정수1> <정수2>");
			return;
		}
		
		System.out.println(Integer.parseInt(args[0]) + " " + Integer.parseInt(args[1]));
		if(Integer.parseInt(args[0])>Integer.parseInt(args[1]))
			System.out.println("MaxValue = " + Integer.parseInt(args[0]));
		else if(Integer.parseInt(args[0]) == Integer.parseInt(args[1]))
			System.out.println("두 값이 같음");
		else
			System.out.println("MaxValue = " + Integer.parseInt(args[1]));

	}

}

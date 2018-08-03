package basicExamples;

import java.util.LinkedList;

public class StaticExample {
	public static void function1() {
		System.out.println("wow");
		return;
	}
	
	public static int function2() {
		function1();
		return 2;
	}
	
	public static void main(String args[]) {
		function2();
	}
}

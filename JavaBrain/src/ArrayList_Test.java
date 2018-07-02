import java.util.ArrayList;

/**
 * 2018. 5. 9. Dev. by D. A. Lee
 */
 
public class ArrayList_Test {

	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<String>(3);
		fruits.add("포도");
		fruits.add("딸기");
		fruits.add("복숭아");
		fruits.add("아보카도");
		
		for(int i=0; i<fruits.size(); i++)
			System.out.println(fruits.get(i));
		
		//fruits.remove(2);
		//fruits.clear();
		fruits.set(0, "청포도");
		
		for(int i=0; i<fruits.size(); i++)
			System.out.println(fruits.get(i));

	}

}

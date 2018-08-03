package basicExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionExample {
	public static void main(String args[]) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(4);
		for (int cnt = 0; cnt < list1.size(); cnt++)
			System.out.println(list1.get(cnt));
		
		// Creating a TreeSet
        SortedSet<String> fruits = new TreeSet<>();

        // Adding new elements to a TreeSet
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Orange");

        System.out.println("Fruits Set : " + fruits);
		
	}
	

}

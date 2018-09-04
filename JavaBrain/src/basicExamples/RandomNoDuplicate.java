package basicExamples;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomNoDuplicate {

	public static void main(String[] args) {
		Random random = new Random();
		int max=100;
		Set<Integer> generated = new LinkedHashSet<Integer>();
		for(int cnt=0;cnt<1000;cnt++) { // Even you try 1000 times, it appears only 100 numbers can get in the Set.
			Integer next = random.nextInt(max) + 1; // random number between 1~100
		    // As we're adding to a set, this will automatically do a containment check
		    generated.add(next);
		}
		System.out.println(generated);
		Iterator<Integer> iter = generated.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());

	}

}

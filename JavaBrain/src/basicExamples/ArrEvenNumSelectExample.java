package basicExamples;

public class ArrEvenNumSelectExample {

	public static void main(String[] args) {
		int inpAry[] = { 1, 5, 4, 8, 315 };
		int oupAry[] = new int[inpAry.length];
		int k = 0;
		for (int cnt = 0; cnt < inpAry.length; cnt++)
			if (inpAry[cnt] % 2 == 0) {
				System.out.println(oupAry[k++] = inpAry[cnt]);
			}
	}
}

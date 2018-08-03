package basicExamples;

public class ArrOddAvg {

	public static void main(String[] args) {
		int inpAry[] = {1,5,4,8,315};
		int sum=0, k=0;
		for(int cnt=0; cnt<5; cnt++) {
			if(inpAry[cnt]%2!=0) {
				sum+=inpAry[cnt];
				k++;
			}
		}
		System.out.println(sum/k);

	}

}

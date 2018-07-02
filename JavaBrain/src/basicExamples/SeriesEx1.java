/**
 * 2018. 6. 18. Dev. by D. A. Lee
 */
package basicExamples;

public class SeriesEx1 {
	public static void main(String[] args) {
		//1+2+4+8+... 100항까지
//		int cnt=1, i=1, sum=1;
//		System.out.printf("%5d %5d\n", i, sum);
//		for(;cnt<10;cnt++) {
//			i=i*2;
//			sum=sum+i;
//			System.out.printf("%5d %5d\n", i, sum);
//		}
		
		//1+1/2+1/3+...+1/100
//		double i=0, sum=0;
//		for(i=1;i<=100;i++) {
//			sum = sum + 1/i;
//			System.out.printf("%.0f %f %f\n", i, 1/i, sum);
//		}
		
		// 1+2+4+7+... 10항
		
		// 1-2+3-4...-100
//		int i=0, sum=0;
//		int sw=0;
//		do {
//			i=i+1;
//			if(sw==0) {
//				sum=sum+i;
//				sw=1;
//			}
//			else {
//				sum=sum-i;
//				sw=0;
//			}
//		}while(i<100);
//		System.out.println(sum);
		
		int i=1,j=1,k=0,sum=2;
		for(int n=3; n<=10; n++) {
			k=i+j;
			sum=sum+k;
			i=j;
			j=k;
		}
		
		System.out.println(sum);
		
		

	

	}
}

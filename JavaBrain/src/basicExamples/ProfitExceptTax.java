package basicExamples;

public class ProfitExceptTax {

	public static void main(String[] args) {
		double x, a, r; // x=원금, a=수익률, r=세금
		x= 10000;
		a= 0.2;
		r= 0.0033;
		double profit = x*(1+a)*(1-r)-x;
		System.out.printf("수익: %.2f 원\n", profit);
		System.out.printf("수익률: %.2f %%" , ((1+a)*(1-r)-1)*100);

	}

}

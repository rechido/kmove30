package basicExamples;

public class CompoundInterest {

	public static void main(String[] args) {
		int a, al, rate, n; // a=기본급, al=연증가급, r=이자율, n= 적립연수
		double r, result=0;
		a=2300000;
		al=300000;
		rate=25;
		n=30;
		r=rate/100.0;
		for(int cnt=1; cnt<=n; cnt++)
			result+=(a+al*(cnt-1))*0.8*0.1*12 // 원금: (기본급 a + 연 급여 상승액 al) * 세금 20% 제외(일본기준) * 급여의 10% 저축 * 연 12회
						*Math.pow((1+r), n-cnt); // 복리 적금 공식
		
		String str = "";
		if ((long)(result / Math.pow(10, 16)) != 0) {
			str += String.valueOf((int)(result / Math.pow(10, 16))) + "경 ";
			result = (long) (result % Math.pow(10, 16));
		}
		if ((long)(result / Math.pow(10, 12)) != 0) {
			str += String.valueOf((int)(result / Math.pow(10, 12))) + "조 ";
			result = (long) (result % Math.pow(10, 12));
		}
		if ((long)(result / Math.pow(10, 8)) != 0) {
			str += String.valueOf((int)(result / Math.pow(10, 8))) + "억 ";
			result = (long) (result % Math.pow(10, 8));
		}
		if ((long)(result / Math.pow(10, 4)) != 0) {
			str += String.valueOf((int)(result / Math.pow(10, 4))) + "만 ";
			result = (long) (result % Math.pow(10, 4));
		}
		if ((long)(result / Math.pow(10, 0)) != 0) {
			str += String.valueOf((int)(result / Math.pow(10, 0))) + "";
			result = (long) (result % Math.pow(10, 0));
		}
		str += "원";
		System.out.println(str);

	}

}

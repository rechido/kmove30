/**
 * 2018. 5. 30. Dev. by D. A. Lee
 */
package basicExamples;

public class NumberCheck {
	public static void main(String[] args) {
		  String str = "99";
		    if (isStringDouble(str))
		      System.out.println("숫자입니다.");
		    else
		      System.out.println("숫자가 아닙니다.");

		  }




		  public static boolean isStringDouble(String s) {
		    try {
		        Double.parseDouble(s);
		        return true;
		    } catch (NumberFormatException e) {
		        return false;
		    }
		  }

	

}

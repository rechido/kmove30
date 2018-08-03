import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FibonacciServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str1 = request.getParameter("terms");
		int terms = Integer.parseInt(str1);
		int num1 = 1;
		int num2 = 1;
		int num3 = 2;
		int sum = 2;
//		while (true) {
//			sum += num3;
//			num1 = num2;
//			num2 = num3;
//			num3 = num1 + num2;
//			if (num3 > 100)
//				break;
//		}
		
		for(int cnt=3; cnt<=terms; cnt++) {
		sum += num3;
		num1 = num2;
		num2 = num3;
		num3 = num1 + num2;
	}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>피보나치 수열 합 프로그램 - 결과 화면</TITLE></HEAD>");
		out.println("<BODY>");
		out.printf("1+1+2+...+%d = %d", num2, sum);
		out.println("</BODY>");
		out.println("</HTML>");

	}

}

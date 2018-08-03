import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HundredServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = 0;
		for (int cnt = 1; cnt <= 100; cnt++)
			total += cnt;
		
//		PrintWriter out = response.getWriter();
//		out.println("<HTML>");
//		out.println("<HEAD><TITLE>Hundred Servlet</TITLE></HEAD>");
//		out.println("<BODY>");
//		out.printf("1+2+3+...+1000 = %d", total);
//		out.println("</BODY>");
//		out.println("</HTML>");
		
		request.setAttribute("result", total); // int result = total; result는 jsp 파일에서 사용할 키 변수
		
		String str = "Jsp Programming";
		
		request.setAttribute("webProgramming", str); // String webProgramming = str;
		
		RequestDispatcher rd = request.getRequestDispatcher("Hundred2.jsp");
		rd.forward(request, response);

	}

}

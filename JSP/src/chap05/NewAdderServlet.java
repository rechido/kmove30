package chap05;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewAdderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String str1 = req.getParameter("NUM1");
			String str2 = req.getParameter("NUM2");
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			int result = num1 + num2;
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head><title>덧셈 프로그램</title></head>");
			out.println("<body>");
			out.printf("%d + %d = %d", num1, num2, result);
			out.println("</body>");
			out.println("</html>");
		}catch (NumberFormatException e) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("data-error");
			dispatcher.forward(req, resp);
		}
	}

}

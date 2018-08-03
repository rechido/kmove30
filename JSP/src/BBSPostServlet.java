import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BBSPostServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("NAME");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>게시판 글쓰기 - 결과 화면</title></head>");
		out.println("<body>");
		out.printf("이름: %s <br>", name);
		out.printf("타이틀: %s <br>", title);
		out.println("-------------<br>");
		out.printf("<pre>%s</pre>", content);
		out.println("-------------<br>");
		out.println("저장되었습니다.");
		out.println("</body>");
		out.println("</html>");

	}

}

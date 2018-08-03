import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		if(gender.equals("male"))
			gender = "남";
		else
			gender = "여";
		String iNotice = req.getParameter("inotice");
		String clNotice = req.getParameter("cnotice");
		String dNotice = req.getParameter("dnotice");
		String job = req.getParameter("job");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>개인 정보 입력 - 결과 화면</title></head>");
		out.println("<body>");
		out.println("<h2>개인 정보 입력</h2>");
		out.printf("이름: %s <br>", name);
		out.printf("아이디: %s <br>", id);
		out.printf("암호: %s <br>", password);
		out.printf("성별: %s <br>", gender);
		out.printf("공지 메일: %s <br>", noticeToHangul(iNotice));
		out.printf("광고 메일: %s <br>", noticeToHangul(clNotice));
		out.printf("배송 확인 메일: %s <br>", noticeToHangul(dNotice));
		out.printf("직업: %s <br>", job);
		out.println("</body>");
		out.println("</html>");

	}
	
	private String noticeToHangul(String notice) {
		if(notice == null)
			return "받지 않음";
		else if(notice.equals("on"))
			return "받음";
		else
			return notice;
	}

}

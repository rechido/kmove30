package chap06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet {
	
	private PrintWriter logFile;
	
	@Override
	public void init() throws ServletException {

		String fileName = getInitParameter("FILE_NAME");
		try {
			//logFile = new PrintWriter(new FileWriter("d:\\data\\log.txt", true));
			logFile = new PrintWriter(new FileWriter(fileName, true));
		}catch (IOException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("NAME");
		String greeting = "안녕하세요, " + name + "님.";
		if(logFile != null) {
			GregorianCalendar now = new GregorianCalendar();
			logFile.printf("%TF %TT - %s %n", now, now, name);
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>인사하기</title></head>");
		out.println("<body>");
		out.println(greeting);
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void destroy() {
		if(logFile != null) {
			logFile.close();
		}
	}

}

package chap13;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class BBSPostServlet extends HttpServlet {

	Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String title = req.getParameter("TITLE");
		String content = req.getParameter("CONTENT");
		String currentURL = req.getParameter("CURRENT_URL");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("LOGIN_ID");

		session.setAttribute("TITLE", title);
		session.setAttribute("CONTENT", content);
		//log.info(session.getAttribute("TITLE"));
		
		if(req.getParameter("save") != null) {
			log.info("글 저장중");
			PrintWriter out = resp.getWriter();
			if (id == null) {
				log.info("로그인안함!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('로그인 후에 사용 가능한 기능입니다!');");
				out.println("location='" + currentURL + "';");
				out.println("</script>");
				// resp.sendRedirect(currentURL);
				return;
			}
			if (title.equals("") || content.equals("")) {
				log.info("내용부정확");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('내용을 입력해주세요!');");
				out.println("location='" + currentURL + "';");
				out.println("</script>");
				return;
			}
			saveTexttoDB(title, content, id);
			session.removeAttribute("TITLE");
			session.removeAttribute("CONTENT");
			log.info("정상진행됨");
			resp.sendRedirect("bbs-list");
		}
		else if(req.getParameter("temporarySave") != null) {
			log.info("글 임시저장중");
			resp.sendRedirect(currentURL);
		}

	}

	public void saveTexttoDB(String title, String content, String id) throws ServletException {

		Connection conn = null;
		Statement stmt = null;
		GregorianCalendar now = new GregorianCalendar();
		String date = String.format("%TF", now);
		String time = String.format("%TT", now);
		try {

			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/wdbpool");
			conn = ds.getConnection();
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select MAX(seqNo) as max from bbs;");
			rs.next();
			int maxSeqNo = rs.getInt("max");
			log.info("게시글 개수: " + maxSeqNo);
			String sql = String.format("insert into bbs values(%d, '%s', '%s', '%s', '%s', '%s');", maxSeqNo+1, title,
					content, id, date, time);
			log.info(sql);
			int rowNum = stmt.executeUpdate(sql);
			if (rowNum < 1)
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				stmt.close();
			} catch (Exception ignored) {

			}
			try {
				conn.close();
			} catch (Exception ignored) {

			}
		}
	}

}

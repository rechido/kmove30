package chap13;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class NewLoginServlet extends HttpServlet {
	
	Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("ID");
		String password = req.getParameter("PASSWORD");
		String currentURL = req.getParameter("CURRENT_URL");
		if (checkLoginInfo(id, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("LOGIN_ID", id);
		} 
		resp.sendRedirect(currentURL);
	}

	private boolean checkLoginInfo(String id, String password) throws ServletException {
		Connection conn = null;
		Statement stmt = null;

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/wdbpool");
			conn = ds.getConnection();
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");

			stmt = conn.createStatement();

			String sql = String.format("select password from userinfo where id = '%s';", id);
			log.info(sql);
			ResultSet rs = stmt.executeQuery(sql);

			if (!rs.next()) { // 아이디가 없는 경우
				return false;
			}

			String correctPassword = rs.getString("password");
			if (password.equals(correctPassword))
				return true; // 패스워드 일치
			else
				return false; // 패스워드가 일치하지 않음

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

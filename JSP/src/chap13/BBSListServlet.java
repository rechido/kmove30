package chap13;

import java.io.IOException;
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
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class BBSListServlet extends HttpServlet {
	
	Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strUpperSeqNo = req.getParameter("LAST_SEQ_NO");
		int upperSeqNo;
		if (strUpperSeqNo == null)
			upperSeqNo = Integer.MAX_VALUE;
		else
			upperSeqNo = Integer.parseInt(strUpperSeqNo);

		int textCountPerPage = 5;
		req.setAttribute("TEXT_PER_PAGE", new Integer(textCountPerPage));
		BBSList list = readDB(upperSeqNo, textCountPerPage);
		req.setAttribute("BBS_LIST", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WebTemplate.jsp?BODY_PATH=BBSListVIew.jsp");
		dispatcher.forward(req, resp);

	}

	private BBSList readDB(int upperSeqNo, int textCountPerPage) throws ServletException {
		BBSList list = new BBSList();
		Connection conn = null;
		Statement stmt = null;

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/wdbpool");
			conn = ds.getConnection();
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");

			stmt = conn.createStatement();
			{
				String sql = String.format("select * from bbs order by seqNo desc;");
				log.info(sql);
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				int maxSeqNo = rs.getInt("seqNo");
				list.setMaxSeqNo(maxSeqNo);
				list.setTotalPageCount(maxSeqNo % textCountPerPage == 0 ? maxSeqNo / textCountPerPage
						: maxSeqNo / textCountPerPage + 1);
			}

			String sql = String.format("select * from bbs where seqNo < %d order by seqNo desc;", upperSeqNo);
			
			ResultSet rs = stmt.executeQuery(sql);

			for (int cnt = 0; cnt < textCountPerPage; cnt++) {
				if (!rs.next())
					break;
				list.setSeqNo(cnt, rs.getInt("seqNo"));
				list.setTitle(cnt, rs.getString("title"));
				list.setWriter(cnt, rs.getString("writer"));
				list.setDate(cnt, rs.getDate("wdate"));
				list.setTime(cnt, rs.getTime("wtime"));
			}
			if (!rs.next())
				list.setLastPage(true);

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
		return list;
	}
}

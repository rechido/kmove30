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

public class GoodsListServlet extends HttpServlet {
	
	Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strUpperCode = req.getParameter("LAST_CODE");
		int upperCode;
		if (strUpperCode == null)
			upperCode = Integer.MIN_VALUE;
		else
			upperCode = Integer.parseInt(strUpperCode);

		int textCountPerPage = 5;
		req.setAttribute("TEXT_PER_PAGE", new Integer(textCountPerPage));
		GoodsList list = readDB(upperCode, textCountPerPage);
		req.setAttribute("GOODS_LIST", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WebTemplate.jsp?BODY_PATH=GoodsListVIew.jsp");
		dispatcher.forward(req, resp);

	}

	private GoodsList readDB(int upperCode, int textCountPerPage) throws ServletException {
		GoodsList list = new GoodsList();
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
				String sql = String.format("select * from goodsinfo order by code;");
				log.info(sql);
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				int minCode = rs.getInt("code");
				int maxCode = 0;
				while(rs.next()) {
					maxCode = rs.getInt("code");
				}
				list.setMinCode(minCode);
				list.setMaxCode(maxCode);
				list.setTotalPageCount((maxCode-minCode+1) % textCountPerPage == 0 ? (maxCode-minCode+1) / textCountPerPage
						: (maxCode-minCode+1) / textCountPerPage + 1);
			}

			String sql = String.format("select * from goodsinfo where code > '%d' order by code;", upperCode);
			log.info(sql);
			ResultSet rs = stmt.executeQuery(sql);

			for (int cnt = 0; cnt < textCountPerPage; cnt++) {
				if (!rs.next())
					break;
				list.setCode(cnt, rs.getString("code"));
				list.setTitle(cnt, rs.getString("title"));
				list.setWriter(cnt, rs.getString("writer"));
				list.setPrice(cnt, rs.getInt("price"));
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

package chap13;

import java.sql.*;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.sql.*;

public class BBSItem {
	private int seqNo;
	private String title;
	private String content;
	private String writer;
	private Date date;
	private Time time;

	public BBSItem() {
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public void readDB() throws ServletException {
		Connection conn = null;
		Statement stmt = null;

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/wdbpool");
			conn = ds.getConnection();
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");

			stmt = conn.createStatement();
			String sql = String.format("select * from bbs where seqNo=%d;", seqNo);
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				title = rs.getString("title"); // 제목
				content = rs.getString("content"); // 내용
				writer = rs.getString("writer"); // 작성자
				date = rs.getDate("wdate"); // 저장일자
				time = rs.getTime("wtime"); // 저장시각
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

		finally {
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

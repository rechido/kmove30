package chap08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonalInfo obj = new PersonalInfo();
		obj.setName("이정호");
		obj.setGender('남');
		obj.setAge(24);
		req.setAttribute("pinfo", obj);
		RequestDispatcher dispatcher = req.getRequestDispatcher("CustomerInfoViewer.jsp");
		dispatcher.forward(req, resp);
	}

}

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WinnersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int arr[] = new int[7];
		Random random = new Random();
		for(int cnt=0; cnt<arr.length; cnt++)
			arr[cnt] = random.nextInt(45)+1;
		req.setAttribute("ARR", arr);
		RequestDispatcher rd = req.getRequestDispatcher("Winners.jsp");
		rd.forward(req, resp);
	}

}

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalityTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String strName = req.getParameter("name");
		String strColor = req.getParameter("color");
		String strAnimal = req.getParameter("animal");
		String[] str = new String[3];
		str[0] = req.getParameter("zzazang");
		str[1] = req.getParameter("zzambbong");
		str[2] = req.getParameter("tangsuyuk");		
		String strFood = "";

		if (strColor.equals("yellow"))
			strColor = "노랑";
		else if (strColor.equals("red"))
			strColor = "빨강";
		else if (strColor.equals("blue"))
			strColor = "파랑";

		if (str[0].equals("on"))
			str[0] = "짜장면";
		if (str[1].equals("on"))
			str[1] = "짬뽕";
		if (str[2].equals("on"))
			str[2] = "탕수육";

		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (str[i] == null)
				continue;
			cnt++;
		}

		for (int i = 0; i < cnt; i++) {
			if (i < cnt-1)
				strFood += str[i] + "과 ";
			else
				strFood += str[i];
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>성격 테스트 - 결과 화면</title></head>");
		out.println("<body>");
		out.println("<h2>성격 테스트</h2>");
		out.println("<br><br>");
		out.println(strName + " 님의 성격 테스트 결과");
		out.println("<br><br>");
		out.printf("%s색을 좋아하는 당신은 %s, 그리고 %s을 좋아하는 성격입니다.", strColor, strAnimal, strFood);
		out.println("</body>");
		out.println("</html>");
	}

}

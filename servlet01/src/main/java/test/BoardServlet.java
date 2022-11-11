package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>게시글내용</h2>");
		out.printf("<div>작성자: %s</div>", writer);
		out.printf("<div>제목: %s</div>", title);
		out.printf("<div>내용: %s</div>", content);
		
		out.print("<hr>");
		out.printf("<div>Request: %s</div>"
						, request.getAttribute("request") );
		//Object -> Integer
		out.printf("<div>Request no: %d</div>"
						, (Integer)request.getAttribute("no") );
		
		HttpSession session = request.getSession();
		out.printf("<div>Session: %s</div>"
						, session.getAttribute("session") );
		
		out.printf("<div>Application: %s</div>"
						, getServletContext().getAttribute("app") );
		

		out.print("</body>");
		out.print("</html>");
		
		
		
		
		
		
		
	}

}

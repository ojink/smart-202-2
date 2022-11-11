package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*    
		jsp/servlet 에는 유효범위(scope) 가 있다
		1. application : 웹서버가 서비스 되는 동안 유효
		2. session : session 이 유지되는 동안 유효
		3. request : 요청된 페이지와 응답하는 jsp/servlet까지 유효
		4. page : jsp 에만 적용. 해당 페이지에만 유효
		각 scope에 데이터를 담아두려면 attribute 로 데이터를 담는다	
		
			page < request < session < application
		*/
		
		ServletContext context = getServletContext();
		context.setAttribute("app",  "Application Scope Data");
	
		HttpSession session = request.getSession();
		session.setAttribute("session", "Session Scope Data");
		
		request.setAttribute("request", "Request Scope Data");
		request.setAttribute("no", 100);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>Scope 정보</h2>");
		out.printf("<div>Request: %s</div>"
								, request.getAttribute("request") );
		//Object -> Integer
		out.printf("<div>Request no: %d</div>"
								, (Integer)request.getAttribute("no") );
		out.printf("<div>Session: %s</div>"
								, session.getAttribute("session") );
		out.printf("<div>Application: %s</div>"
								, context.getAttribute("app") );
		
		out.print("</body>");
		out.print("</html>");
	}

}

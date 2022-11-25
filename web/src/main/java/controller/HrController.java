package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.hr")
public class HrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		
		if( uri.equals("/list.hr") ) {
			request.getSession().setAttribute("category", "hr");
			//비지니스로직
			//응답화면연결
			view = "employee/list.jsp";
		}
		
		if( redirect ) response.sendRedirect(view);
		else 
			request.getRequestDispatcher(view)
						.forward(request, response);
			
		
	}
	

}

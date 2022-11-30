package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/index"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("category");
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		if( uri.equals("/index") ) {
			
			view = "index.jsp";
		}
		if(redirect) response.sendRedirect(view);
		else request.getRequestDispatcher(view).forward(request, response);
		
	}

}

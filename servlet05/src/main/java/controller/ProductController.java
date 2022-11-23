package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.ProductAll;

@WebServlet("*.pd")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		if( uri.equals("/productAll.pd") ) {
			Command command = new ProductAll();
			command.execute(request, response);
			
			view = "product_list.jsp";
		}
	
		if( redirect )
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.command.CustomerList;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uri = request.getServletPath();
		String view="";
		boolean redirect = false;
		Command command = null;
		//고객목록화면 요청
		if( uri.equals("/list.cu") ) {
			//비지니스 로직
			command = new CustomerList();
			command.exec(request, response);
			
			//응답화면연결
			view = "customer/list.jsp";
		}
		
		//화면연결 기본은 forward방식
		//redirect: DB에 insert,update,delete 하는 
		//          비지니스 로직이 들어간 요청이 되었을때
		if( redirect )	response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.command.EmployeeInfo;
import hr.command.EmployeeList;

@WebServlet("*.hr")
public class HrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		
		Command cmd = null;
		if( uri.equals("/list.hr") ) {
			//전체 사원목록 화면 요청
			request.getSession().setAttribute("category", "hr");
			//비지니스로직
			cmd = new EmployeeList();
			cmd.exec(request, response);
			
			//응답화면연결
			view = "employee/list.jsp";
			
		}else if( uri.equals("/info.hr") ) {
			//사원정보화면 요청
			cmd = new EmployeeInfo();
			cmd.exec(request, response);
			
			view = "employee/info.jsp";
		}
		
		if( redirect ) response.sendRedirect(view);
		else 
			request.getRequestDispatcher(view)
						.forward(request, response);
			
		
	}
	

}

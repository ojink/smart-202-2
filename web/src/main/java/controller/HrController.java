package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.command.EmployeeCode;
import hr.command.EmployeeDelete;
import hr.command.EmployeeInfo;
import hr.command.EmployeeInsert;
import hr.command.EmployeeList;
import hr.command.EmployeeUpdate;

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
			
		}else if( uri.equals("/modify.hr")) {
			//사원정보수정화면 요청
			cmd = new EmployeeInfo();
			cmd.exec(request, response);
			
			//코드정보조회요청
			cmd = new EmployeeCode();
			cmd.exec(request, response);
			
			view = "employee/modify.jsp";
			
		}else if( uri.equals("/update.hr") ) {
			//사원정보변경저장처리 요청
			cmd = new EmployeeUpdate();
			cmd.exec(request, response);
			
			view = "info.hr?id=" + request.getParameter("employee_id");
			redirect = true;
			
		}else if( uri.equals("/delete.hr") ) {
			//사원정보삭제처리 요청
			cmd = new EmployeeDelete();
			cmd.exec(request, response);
			
			view = "list.hr";
			redirect = true;
			
		}else if( uri.equals("/new.hr")) {
			//신규사원등록화면 요청
			cmd = new EmployeeCode();
			cmd.exec(request, response);
			
			view = "employee/new.jsp";
			
		}else if( uri.equals("/insert.hr")) {
			//신규사원등록처리 요청
			cmd = new EmployeeInsert();
			cmd.exec(request, response);
			
			view = "list.hr";
			redirect = true;
		}
		
		if( redirect ) response.sendRedirect(view);
		else 
			request.getRequestDispatcher(view)
						.forward(request, response);
			
		
	}
	

}

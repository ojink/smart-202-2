package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.command.CustomerDelete;
import customer.command.CustomerInfo;
import customer.command.CustomerInsert;
import customer.command.CustomerList;
import customer.command.CustomerUpdate;

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
			
		}else if( uri.equals("/info.cu") ) {
			//선택한 고객정보화면 요청
			//비지니스로직
			command = new CustomerInfo();
			command.exec(request, response);
			
			//응답화면연결
			view = "customer/info.jsp";
			
		}else if( uri.equals("/modify.cu")) {
			//고객정보수정화면 요청
			//비지니스로직
			command = new CustomerInfo();
			command.exec(request, response);
			
			//응답화면연결
			view = "customer/modify.jsp";
		
		}else if( uri.equals("/update.cu")) {
			//고객정보수정 저장처리 요청
			command = new CustomerUpdate();
			command.exec(request, response);
			
			//응답화면연결
			view = "info.cu?id="+ request.getParameter("id");
			redirect = true;
			
		}else if( uri.equals("/new.cu") ) {
			//신규고객등록화면 요청
			//응답화면연결
			view ="customer/new.jsp";
			
		}else if( uri.equals("/insert.cu")) {
			//신규고객정보 저장처리 요청
			//비지니스로직
			command = new CustomerInsert();
			command.exec(request, response);
			
			//응답화면연결
			view = "list.cu";
			redirect = true;
			
		}else if( uri.equals("/delete.cu")) {
			//고객정보 삭제처리요청
			//비지니스로직
			command = new CustomerDelete();
			command.exec(request, response);
			
			//응답화면연결
			view = "list.cu";
			redirect = true;
		}
		
		
		//화면연결 기본은 forward방식
		//redirect: DB에 insert,update,delete 하는 
		//          비지니스 로직이 들어간 요청이 되었을때
		if( redirect )	response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}

}

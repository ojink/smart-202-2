package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.TestCommand;

@WebServlet("*.do") //모든 .do 의 요청에 대한 처리를 할 Controller
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring( path.length() );
	
		if( uri.equals("/test.do") ) {
			//비지니스로직
			TestCommand command = new TestCommand();
			command.execute(request, response);
			
			//응답화면연결: forward
			//redirect 하는 경우: DB에 insert,update,delete 하는 요청에 대한 처리를 하는 경우
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
		}
	}

}

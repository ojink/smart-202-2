package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.UserAllCommand;
import command.UserCommand;

@WebServlet("*.ju")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring( path.length() );

		if( uri.equals("/user.ju")) {
			//비지니스 로직
			UserCommand command = new UserCommand();
			command.execute(request, response);
			
			//응답화면연결
			request.getRequestDispatcher("user.jsp").forward(request, response);
		
		}else if( uri.equals("/userAll.ju") ) {
			//비지니스 로직
			Command command = new UserAllCommand();
			command.execute(request, response);
			
			//응답화면연결
			request.getRequestDispatcher("user_all.jsp")
				.forward(request, response);
		}
		
	}

}

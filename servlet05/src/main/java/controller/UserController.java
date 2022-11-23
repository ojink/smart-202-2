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
import command.UserInfoCommand;

@WebServlet("*.ju")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring( path.length() );

		boolean redirect = false;
		String view = "";
		if( uri.equals("/user.ju")) {
			//비지니스 로직
			UserCommand command = new UserCommand();
			command.execute(request, response);
			
			//응답화면연결
			view = "user.jsp";
		
		}else if( uri.equals("/userAll.ju") ) {
			//비지니스 로직
			Command command = new UserAllCommand();
			command.execute(request, response);
			
			//응답화면연결
			view = "user_all.jsp";
		}else if( uri.equals("/info.ju") ) {
			//비지니스 로직
			Command command = new UserInfoCommand();
			command.execute(request, response);
			
			//응답화면연결
			view = "user_info.jsp";
		}
		
		if( redirect ) {
			response.sendRedirect(view);
		}else {
			request.getRequestDispatcher(view)
					.forward(request, response);
		}
	}

}

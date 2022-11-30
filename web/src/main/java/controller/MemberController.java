package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import member.command.MemberLogin;
import member.command.MemberLogout;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("category");
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		Command cmd = null;
		if( uri.equals("/login.mb") ) {
			//로그인화면 요청
			view = "member/login.jsp";
			
		}else if( uri.equals("/smartLogin.mb") ) {
			//로그인처리 요청
			cmd = new MemberLogin();
			cmd.exec(request, response);
			
			return; //화면으로 응답하지 않고 데이터로 응답하도록 한다
			
		}else if( uri.equals("/logout.mb")) {
			//로그아웃처리 요청
			cmd = new MemberLogout();
			cmd.exec(request, response);
			
			//Object -> String
			view = (String)request.getAttribute("url");
			redirect = true;
		}
	
		if( redirect ) response.sendRedirect(view);
		else request.getRequestDispatcher(view).forward(request, response);
	
	}

}

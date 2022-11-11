package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.command.EmployeeSelect;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// http://localhost:80/servlet02/select.do
		String uri = request.getRequestURI(); // /servlet02/select.do
		String context = request.getContextPath(); // /servlet02
		uri = uri.substring( context.length() ); // /select.do
		
		String business = "", view = "";
		if( uri.equals("/select.do") ) {
			business = "조회 요청에 대한 비지니스 로직";
			view = "select" ;//"조회요청에 대한 응답화면";
			
			//비지니스로직
			EmployeeSelect command = new EmployeeSelect();
			command.execute(request, response);
			
			//응답화면연결
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
			
		}else if( uri.equals("/insert.do") ) {
			business = "저장 요청에 대한 비지니스 로직";
			view = "저장요청에 대한 응답화면";
			
		}else if( uri.equals("/update.do") ) {
			business = "수정 요청에 대한 비지니스 로직";
			view = "수정요청에 대한 응답화면";
			
		}else if( uri.equals("/delete.do") ) {
			business = "삭제 요청에 대한 비지니스 로직";
			view = "삭제요청에 대한 응답화면";
			
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<div><a href='front.html'>front controller패턴</a></div>");
		out.printf("<div>%s</div>", business);
		out.printf("<div>%s</div>", view);
		out.print("</body></html>");
		
	}

}

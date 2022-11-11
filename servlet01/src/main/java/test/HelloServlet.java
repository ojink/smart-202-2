package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* annotation */
//@WebServlet("/hello") 
//@WebServlet({"/hello", "/first"}) 
//@WebServlet("/*") 
//@WebServlet({"/first.do", "/second.do"}) 
@WebServlet("*.do") 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	get방식 : 주소창에 파라미터가 노출되는 방식
	post방식 : 주소창에 파라미터가 노출되지 않는 방식
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("HelloServlet: ").append(request.getContextPath());
		System.out.println("사용자가 웹브라우저에서 url을 요청시 실행되는 곳");
		System.out.println();
//		응답페이지를 html 문서로 만든다
		//쓰기작업
		//한글이 깨지지 않도록 charset 을 지정한다
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h2>Hello~</h2>");
		writer.print("<div>응답화면 만들기</div>");
		writer.print("</body>");
		writer.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

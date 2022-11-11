package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* 서블릿의 생명주기 
	  init() : 서블릿의 초기화 - 최초 1회만 실행된다
	  service() : 요청/응답 - 요청할때마다 매번 실행된다
	  destory(): 서블릿 종료 - 웹컨테이너(tomcat)가 서비스를 종료할때 한 번 실행된다
	 */
	
	public void init() {
		System.out.println("초기화");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청에 대한 응답");
	}
	
	public void destroy() {
		System.out.println("종료");
	}

}

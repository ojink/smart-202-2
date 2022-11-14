package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator_error")
public class CalculatorError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exception e = (Exception)request.getAttribute("error");
		String msg = "";
		if( e instanceof ArithmeticException ) {
			msg = "잘못된 연산: 0으로 나눔";
		}else if ( e instanceof NumberFormatException ) {
			msg = "숫자만 입력해야 합니다";
		}else if ( e instanceof ArrayIndexOutOfBoundsException) {
			msg = "인덱스의 범위를 벗어났습니다";
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>오류</h2>");
		out.printf("<div>내용: %s</div>", msg);
		out.printf("<div>%s</div>", e.getMessage());
		out.print("빠른시일내에 복구하겠습니다");
		out.print("</body>");
		out.print("</html>");
	}

}

package calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
		//String  -> int : Integer 
		int num1 = Integer.parseInt( request.getParameter("num1") );
		//Integer -> int : 자동형변환(Unboxing)
		int num2 = Integer.valueOf( request.getParameter("num2") );
		String operator = request.getParameter("operator");
		
		//비지니스로직 : 연산처리
		//int calculated = calculate(num1, num2, operator);
		Calculator c = new Calculator(num1, num2, operator);
		String result = num1 + operator + num2 + " = " + c.getResult();
		//응답할 화면에서 사용할 수 있도록 request에 담는다
		request.setAttribute("calculated", result);
		request.getSession().setAttribute("result", result);
		}catch(Exception e) {
//			RequestDispatcher rd
//			= request.getRequestDispatcher("calculator_error");
//			rd.forward(request, response);
			request.setAttribute("error", e);
			request.getRequestDispatcher("calculator_error")
					.forward(request, response);
		}
		
		//응답화면
		/*
		//1.forward방식: 요청url 이 그대로 유지됨
		RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
		rd.forward(request, response);
		*/
		//2.redirect방식: 요청url은 redirect된 url로 변경됨
		//response.sendRedirect("hello.jsp");
		/*
		RequestDispatcher rd 
			= request.getRequestDispatcher("calculator_forward");
		rd.forward(request, response);
		*/
//		response.sendRedirect("calculator_redirect");
		
		/*
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>계산결과</h2>");
		out.printf("<div>%d %s %d = %d</div>"
						, num1, operator, num2, c.getResult());
		out.print("<div><a href='calculator.html'>계산기화면</a></div>");
		out.print("</body>");
		out.print("</html>");
		*/
	}
/*
	int calculate(int num1, int num2, String operator) {
		int result = 0;
		switch(operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		return result;
	}
*/	
}

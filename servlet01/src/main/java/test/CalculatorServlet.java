package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Calculator;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//String  -> int : Integer 
		int num1 = Integer.parseInt( request.getParameter("num1") );
		//Integer -> int : 자동형변환(Unboxing)
		int num2 = Integer.valueOf( request.getParameter("num2") );
		String operator = request.getParameter("operator");
		
		//비지니스로직 : 연산처리
		//int calculated = calculate(num1, num2, operator);
		Calculator c = new Calculator(num1, num2, operator);
		
		//응답화면
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

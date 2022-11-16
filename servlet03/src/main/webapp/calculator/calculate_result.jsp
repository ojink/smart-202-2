<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>계산결과화면</h2>
<%
String no1 = request.getParameter("no1");
String no2 = request.getParameter("no2");
String operator = request.getParameter("operator");

//String -> int
int num1 = Integer.valueOf( no1 );
int num2 = Integer.parseInt( no2 );

int result;
switch( operator){
case "+":
	result = num1 + num2;
	break;
case "-":
	result = num1 - num2;
	break;
case "*":
	result = num1 * num2;
	break;
// case "/":
default:	
	result = num1 / num2;
	break;
}
%>
<%=result %>
계산결과: <%=num1 %> <%=operator %> <%=num2 %> = <%=result %>

<%

pageContext.setAttribute("result", result);
//Object -> int
int no = (Integer)pageContext.getAttribute("result");
request.setAttribute("result", result);

RequestDispatcher rd = request.getRequestDispatcher("../");
rd.forward(request, response);
%>
</body>
</html>
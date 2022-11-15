<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='./'>홈으로</a></div>
<%@ include file='include/today.jsp' %>
<hr>
<h3>스크립팅 기본 문법</h3>
<div>1. 스크립트릿 </div>
<div>합 계산하기</div>
<%
int sum = 0;
for(int i=1; i<=10; i++){
	sum += i;
}
String text = "가나다";

num1 = 10;
num2 = 20;
operator = "*";
int result = calculate();
%>
<div>2. 표현식 </div>
<%="가나다" %>
<%=text %>
<div>1~10 까지의 합 : <%=sum %></div>
<div><%="1부터 10까지의 합: " + sum %></div>
<div><%=num1 %> <%=operator %> <%=num2 %> = <%=calculate() %></div>
<div><%=num1 + operator + num2 + "=" + calculate() %></div>

<%!
int num1, num2;
String operator;
int calculate(){
	int result = 0;
	if( operator.equals("+") ){
		result = num1 + num2;
	}else if( operator.equals("-") ){
		result = num1 - num2;
	}else if( operator.equals("*") ){
		result = num1 * num2;
	}else if( operator.equals("/") ){
		result = num2==0 ? 0 : num1 / num2;
	}
	return result;
}
%>
<!-- <p></p> -->
<%-- <%@ include file="include/footer.jsp" %> --%>

</body>
</html>
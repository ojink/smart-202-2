<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>스크립팅 기본 문법</h3>
<div>1. 스크립트릿 </div>
<div>합 계산하기</div>
<%
int sum = 0;
for(int i=1; i<=10; i++){
	sum += i;
}
String text = "가나다";
%>
<div>2. 표현식 </div>
<%="가나다" %>
<%=text %>
<div>1~10 까지의 합 : <%=sum %></div>
<div><%="1부터 10까지의 합: " + sum %></div>
</body>
</html>
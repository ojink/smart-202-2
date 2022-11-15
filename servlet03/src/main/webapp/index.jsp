<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.Date, java.text.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='sum.jsp'>합 계산하기</a></div>
<div><a href='out.jsp'>출력하기</a></div>


<%@ include file="include/today.jsp" %>
<hr>
<h3>홈 [ <%=pageContext.getAttribute("pageInfo") %>
			 <%=request.getAttribute("requestInfo") %> ] </h3>
<% 
Date date = new Date();
SimpleDateFormat sdf 
	= new SimpleDateFormat("yyyy년 MM월 dd일 E a hh시 mm분 ss초");
String now = sdf.format(date);
%>

<div>날짜정보: <%=date %></div>
<div>현재: <%=now %></div>
<hr>
<div>jsp 에서 선언할 수 있는 것들</div>
<ul>
	<li>html 태그 선언</li>
	<li>jsp스크립팅: java코드</li>
	<li>jsp표준액션</li>
	<li>EL</li>
	<li>JSTL</li>
</ul>

<%@ include file='include/footer.jsp' %>
</body>
</html>
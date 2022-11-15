<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인 정보</h3>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
/* 아이디, 비번 모두 입력되어 있으면 로그인된것으로 간주 */
if( id.isEmpty() || pw.isEmpty() ){
	//아이디나 비밀번호가 입력하지 않으면 다시 로그인화면으로 연결
	response.sendRedirect("login.jsp");
}else {
	//로그인된 정보는 모든 페이지에서 접근할 수 있도록 세션에 담는다
	session.setAttribute("id", id); /* 지정한 속성명으로 값을 저장*/
	session.setAttribute("pw", pw);
	response.sendRedirect("../"); //홈으로 연결
}
%>
</body>
</html>
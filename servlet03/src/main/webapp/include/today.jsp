<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.text.*, java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//세션에 저장한 로그인정보인 id 를 확인
//Object  -> String
String id = (String)session.getAttribute("id");

if( id==null ){
	//로그인 해야 함
	out.print("<div><a href='member/login.jsp'>로그인</a></div>");
	out.print("<div><a href='member/join.jsp'>회원가입</a></div>");
}else{
	//로그인됨
	out.print("[ " +id+" ]");
	out.print("[ <a href='member/logout.jsp'>로그아웃</a> ]");
}
%>
<%
	SimpleDateFormat df 
		= new SimpleDateFormat("yyyy년 MM월 dd일");
	String today = df.format(new Date());
%>
[ <%=today%> ]
</body>
</html>
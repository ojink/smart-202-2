<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>전체 사용자정보 목록</h3>
<table border='1'>
<tr><th>아이디</th><th>이름</th><th>이메일</th>
	<th>관리자여부</th><th>Money</th></tr>
<c:forEach items='${user_list}' var='dto'>
<tr><td>${dto.id}</td>
	<td>${dto.name }</td>
	<td>${dto.email }</td>
	<td>${dto.admin }</td>
	<td>${dto.money }</td>
</tr>
</c:forEach>	
	
</table>

<hr>
<h3>전체 사용자 이름 목록</h3>
<ul>
	<c:forEach items='${list}' var='name'>
	<li>${name}</li>
	</c:forEach>
</ul>

</body>
</html>






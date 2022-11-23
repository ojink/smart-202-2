<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='userAll.ju'>사용자전체목록</a></div>
<hr>
<h3>사용자 정보</h3>
<table border='1'>
<tr><th>아이디</th><td>${dto.id}</td></tr>
<tr><th>이름</th><td>${dto.name}</td></tr>
<tr><th>이메일</th><td>${dto.email}</td></tr>
<tr><th>Money</th><td>${dto.money}</td></tr>
</table>
</body>
</html>
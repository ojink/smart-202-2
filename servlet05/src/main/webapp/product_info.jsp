<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='<c:url value="/"/>'>홈으로</a></div>
<div><a href='productAll.pd'>전체상품목록</a></div>
<hr>
<h3>상품정보</h3>
<table border='1'>
<tr><th>상품명</th><td>${info.name}</td></tr>
<tr><th>제조사</th><td>${info.company }</td></tr>
<tr><th>상품가격</th><td>${info.price }</td></tr>
<tr><th>상품수량</th><td>${info.qty }</td></tr>
</table>
</body>
</html>
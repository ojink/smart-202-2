<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.number {text-align: right;}
</style>
</head>
<body>
<div><a href='<c:url value="/"/>'>홈</a></div>
<hr>

<h3>전체 상품 목록</h3>
<table border='1'>
	<tr><th>번호</th><th>상품명</th><th>제조사</th>
		<th>상품가격</th><th>상품수량</th></tr>
	<c:forEach items="${list}" var="dto">
	<tr><td>${dto.num}</td>
		<td><a href='product_info.pd?no=${dto.num}'>${dto.name}</a></td>
		<td>${dto.company}</td>
		<td class='number'><fmt:formatNumber value='${dto.price}'/> </td>
		<td class='number'>${dto.qty}</td>
	</tr>	
	</c:forEach>
</table>

</body>
</html>
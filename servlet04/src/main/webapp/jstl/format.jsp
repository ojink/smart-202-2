<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>포맷 라이브러리</h3>
<h4>숫자포맷</h4>
<ul>
	<li><fmt:formatNumber value='123450000' type='currency' groupingUsed='true'/></li>
	<li><fmt:formatNumber value='0.85' type='percent'/></li>
</ul>

<hr>
<h4>날짜포맷</h4>
<c:set var='today' value='<%=new java.util.Date() %>'/>
<ul>
	<li>오늘: ${today}</li>
	<li>오늘: <fmt:formatDate value="${today}" type='date'  dateStyle='long'/> </li>
	<li>오늘: <fmt:formatDate value='${today}' 
					pattern="yyyy-MM-dd HH:mm:ss" /> </li>
	<li>현재: <fmt:formatDate value='${today}' type='time' timeStyle='full' /> </li>
</ul>
 

</body>
</html>
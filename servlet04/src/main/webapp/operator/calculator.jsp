<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='../'>홈으로</a></div>
<hr>
<h3>과일 목록</h3>
<div>${fruits[0]}</div>
<div>${fruits[1]}</div>
<div>${fruits[2]}</div>
<hr>
<h3>계산기</h3>
<form method='get' action='calculator_result.jsp'>
	<input type='text' name='no1'>
	<input type='text' name='no2'>
	<input type='submit' value='계산하기'>
</form>
</body>
</html>
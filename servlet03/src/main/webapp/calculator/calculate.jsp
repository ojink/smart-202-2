<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>계산기화면</h2>
<!--   두 숫자 입력, 연산자 선택 해서  -->
<!--    계산하기 버튼을 클릭시 form 태그를 submit 한다 -->
<!--    : 요청은 calculate_result.jsp  -->
<form action='calculate_result.jsp'>
<input type='text' name='no1'>
<select name='operator'>
	<option>+</option>
	<option>-</option>
	<option>*</option>
	<option>/</option>
</select>
<input type='text' name='no2'>
<input type='submit' value='계산하기'>
</form>
</body>
</html>
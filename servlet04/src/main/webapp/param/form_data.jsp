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
<form method='post' action='form_result.jsp'>
	<div>이름: <input type='text' name='name'></div>
	<div>성별: <input type='radio' name='gender' 
					value='남' id='male'><label for="male">남</label>
			  <label><input type='radio' name='gender' 
					value='여' checked>여</label>
	</div>
	<div>취미: <label><input type='checkbox' name='sports' value='야구'>야구</label>
			  <label><input type='checkbox' name='sports' value='농구'>농구</label>
			  <label><input type='checkbox' name='sports' value='축구'>축구</label>
			  <label><input type='checkbox' name='sports' value='탁구'>탁구</label> 
	</div>
	<input type='submit' value='확인'>				
</form>
</body>
</html>
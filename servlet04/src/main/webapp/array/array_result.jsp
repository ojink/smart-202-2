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
<h3>연락처 목록</h3>
<div>홍길동: ${phone['홍길동']}</div>
<div>박문수: ${phone['박문수']}</div>
<div>심청: ${phone["심청"]}</div>
<hr>
<h3>과일 목록</h3>
<div>${fruits[0]}</div>
<div>${fruits[1]}</div>
<div>${fruits[2]}</div>
<hr>
<h3>취미 목록</h3>
<div>${hobby[0]}</div>
<div>${hobby[1]}</div>
<div>${hobby[2]}</div>
</body>
</html>
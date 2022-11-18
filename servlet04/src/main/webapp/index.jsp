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
<div><a href='scope/scope_data.jsp'>데이터 저장 및 출력</a></div>
<div><a href='param/form_data.jsp'>파라미터 출력</a></div>
<div><a href='operator/calculator.jsp'>계산기</a></div>
<div><a href='array/array_data.jsp'>배열,자료구조,맵</a></div>
<div><a href='jstl/index.jsp'>JSTL</a></div>
<div><a href='<c:url value="/param/form_result.jsp?name=심청&gender=남" />'>회원정보</a></div>

<c:url value='/jstl/index.jsp' var='jstl'>
	<c:param name='name' value='박문수'/>
</c:url>
<div><a href='${jstl}'>JSTL 링크</a></div>

<hr>
<h3>홈</h3>
</body>
</html>
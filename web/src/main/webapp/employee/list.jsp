<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />        
<title>Insert title here</title>
</head>
<body>
<div class="d-flex" id="wrapper">
<!-- Sidebar-->
<jsp:include page="/include/sidebar.jsp"/> 
<!-- Page content wrapper-->
<div id="page-content-wrapper">
	<!-- Top navigation-->
	<jsp:include page="/include/navigation.jsp"/> 

	<!-- Page content-->
	<div class="container-fluid">
		<h2 class="mt-4">사원목록</h2>
		<table class='w-px800 tb-list'>
		<colgroup>
			<col width='80px'>
			<col width='150px'>
			<col width='150px'>
			<col>
			<col width='120px'>
		</colgroup>
		<tr>
			<th>사번</th>
			<th>사원명</th>
			<th>부서</th>
			<th>업무</th>
			<th>입사일자</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</table>

	</div>
</div>
</div>
</body>
</html>
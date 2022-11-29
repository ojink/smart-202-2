<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />        
<title>Insert title here</title>
<style type="text/css">
.readonly { border: none; }
</style>
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
		<h2 class="mt-4">사원정보수정</h2>
		<form method='post' action='update.hr'>
		<table class='w-px600'>
		<tr><th class='w-px140'>사번</th>
			<td><input type='text' class='readonly' readonly name='employee_id' value='${dto.employee_id}'></td>
		</tr>
		<tr><th>사원명</th>
			<td>
				<input type='text' placeholder="성" name='last_name' value='${dto.last_name}'>
				<input type='text' placeholder="명" name='first_name' value='${dto.first_name}'>
			</td>
		</tr>
		<tr><th>이메일</th>
			<td><input type='text' name='email' value='${dto.email }'></td>
		</tr>
		<tr><th>전화번호</th>
			<td><input type='text' name='phone_number' value='${dto.phone_number }'></td>
		</tr>
		<tr><th>급여</th>
			<td><input type='text' name='salary' value='${dto.salary }'></td>
		</tr>
		<tr><th>입사일자</th>
			<td><input type='date' name='hire_date' value='${dto.hire_date }'></td>
		</tr>
		<tr><th>부서</th>
			<td><!-- 실제 사원의 부서가 선택되어 있게 -->
				<select name='department_id' class='w-px300'>
					<option value='-1'>부서선택</option>
					<c:forEach items='${departments}' var='d'>
					<option ${dto.department_id eq d.department_id ? 'selected' :''}
					 value='${d.department_id}'>${d.department_name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr><th>업무</th>
			<td>
				<!-- 실제 사원의 업무가 선택되어 있게 -->
				<select name='job_id' class='w-px300'>
					<c:forEach items='${jobs}' var='j'>
					<option <c:if test='${j.job_id eq dto.job_id}'>selected</c:if> 
					value='${j.job_id}'>${j.job_title}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr><th>매니저</th>
			<td><!-- 실제 사원의 매니저가 선택되어 있게 -->
				<select name='manager_id' class='w-px300'>
					<option value='-1'>매니저선택</option>
					<c:forEach items='${managers}' var='m'>
					<option <c:if test='${dto.manager_id eq m.manager_id}'>selected</c:if> 
					value='${m.manager_id}'>${m.manager_name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</table>	
		</form>
		<div class='btnSet'>
			<button class='btn btn-primary' onclick="$('form').submit()">저장</button>
			<button class='btn btn-secondary' 
				onclick='location="info.hr?id=${dto.employee_id}"'>취소</button>
		</div>
	</div>
</div>
</div>
</body>
</html>



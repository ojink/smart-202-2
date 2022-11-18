<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='<c:url value="/"/>'>홈으로</a></div>
<hr>
<h3>함수 라이브러리</h3>
<c:set var='title' value='   함수 라이브러리 FUNCTIONS'/>
<h4>[${title}]</h4>
여기에     공백을         아무리 많이      줘도    한 개만 표현된다
<ul>
	<li>문자열의 길이: ${fn: length(title)}</li>
	<li>문자열의 일부: ${fn: substring(title, 6, 11) }]</li>
		<!-- 3번째 파라미터 생략 불가 -->
	<li>공백제거하기: [${fn: trim(title)}]</li>
</ul>

<c:set var='email' value='hong22@hanuedu.co.kr'/>
<h4>[${email}]</h4>
<ul>
	<li>특정문자열의 위치: ${fn: indexOf(email, '@')}</li>
	<li>이메일아이디: ${fn: substring(email, 0, fn: indexOf(email, '@')) }</li>
	<li>이메일호스트: ${fn: substring(email, fn: indexOf(email, '@')+1
										, fn:length(email) ) }</li>
	<li>문자열변경(co.kr->com): ${fn: replace(email, 'co.kr', 'com') }</li>
	<li>문자열변경(o->e): ${fn:replace(email, 'o', 'e') }</li>		
	<li>대문자화: ${fn: toUpperCase(email) }</li>								
	<li>소문자화: ${fn: toLowerCase(title) }</li>
	<li>존재유무: ${fn: contains(email, 'co.kr') }</li>								
	<li>존재유무: <c:if test="${fn: contains(email, 'co.kr') }">
					co.kr 있음
				</c:if> 
				<c:if test="${not fn: contains(email, 'com') }">
					com 없음
				</c:if>
	</li>								
</ul>
<%
String[] fruits = { "귤", "배", "감" };
%>
<hr>
<c:set var='fruits' value='<%=fruits%>'/>
<h4>문자연결 및 분리</h4>
<ul>
	<li>문자연결: ${fn: join(fruits, ' + ') }</li>
	<li>문자연결: ${fn: join(fruits, '<br>') }</li>
</ul>
<%
String data = "java,oracle?html,css/jquery";
request.setAttribute("subject", data);
%>
<ul>
	<li>문자분리: </li>
	<c:forEach items="${fn: split(subject, ',/?') }" var="s">
	<div>${s}</div>
	</c:forEach>
</ul>








</body>
</html>
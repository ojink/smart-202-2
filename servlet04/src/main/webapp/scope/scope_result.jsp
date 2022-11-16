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
<div>page값: <%=pageContext.getAttribute("pageData") %>, ${pageData}</div>
<div>request값: <%=request.getAttribute("requestData") %>, ${requestData}</div>
<div>session값: <%=session.getAttribute("sessionData") %>, ${sessionData}</div>
<div>값(request): ${requestScope.data}</div>
<div>값(session): ${sessionScope.data}</div>
<div>값: ${data}</div>

</body>
</html>
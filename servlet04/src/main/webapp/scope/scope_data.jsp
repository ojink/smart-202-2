<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("pageData", 100);
request.setAttribute("requestData", 200);
session.setAttribute("sessionData", 300);

pageContext.setAttribute("data", 100);
request.setAttribute("data", 200);
session.setAttribute("data", 300);
%>
<div>page값: <%=pageContext.getAttribute("pageData") %>, ${pageData}</div>
<div>request값: <%=request.getAttribute("requestData") %>, ${requestData}</div>
<div>session값: <%=session.getAttribute("sessionData") %>, ${sessionData}</div>
<div>값: ${requestScope.data}</div>

<%
// RequestDispatcher rd = request.getRequestDispatcher("scope_result.jsp");
// rd.forward(request, response);
request.getRequestDispatcher("scope_result.jsp")
		.forward(request, response);
%>
</body>
</html>
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
 			<jsp:include page='/include/sidebar.jsp'/>
 			
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
 				<jsp:include page='/include/navigation.jsp'/>

                <!-- Page content-->
                <div class="container-fluid">
                    <h2 class="mt-4">고객정보</h2>
					<table class='w-px400'>
						<tr><th class='w-px140'>고객명</th>
							<td>${dto.name}</td>
						</tr>
						<tr><th>성별</th>
							<td>${dto.gender}</td>
						</tr>
						<tr><th>이메일</th>
							<td>${dto.email }</td>
						</tr>
						<tr><th>전화번호</th>
							<td>${dto.phone }</td>
						</tr>
					</table>

                </div>
            </div>
        </div>
</body>
</html>
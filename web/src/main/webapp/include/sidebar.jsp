<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
        
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/common.css?<%=new java.util.Date() %>" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script> 


<div class="border-end bg-white" id="sidebar-wrapper">
     <div class="sidebar-heading border-bottom bg-light"><a href='<c:url value="/"/>'>스마트 웹&amp;앱</a></div>
     <div class="list-group list-group-flush">
         <a class="${category eq 'cu' ? 'category' : ''} list-group-item list-group-item-action list-group-item-light p-3" href="list.cu">고객관리</a>
         <a class="${category eq 'hr' ? 'category' : ''} list-group-item list-group-item-action list-group-item-light p-3" href="list.hr">사원관리</a>
         <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Overview</a>
         <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
         <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
         <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
     </div>
 </div>
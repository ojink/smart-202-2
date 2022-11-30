<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
        <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                <li class="nav-item active"><span style='margin-right: 20px'>${loginInfo.name}</span></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <!-- 로그인하지 않은 경우 -->
                    <c:if test='${empty loginInfo}'>
                        <a class="dropdown-item" href="login.mb">로그인</a>
                        <a class="dropdown-item" href="#!">회원가입</a>
					</c:if>                        
                    <!-- 로그인한 경우 -->
                    <c:if test='${not empty loginInfo}'>
                        <a class="dropdown-item" href="#!">My Page</a>
                        <a class="dropdown-item" href="logout.mb">로그아웃</a>
					</c:if>                        
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#!">Something else here</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
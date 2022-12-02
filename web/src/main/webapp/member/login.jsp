<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />        
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/common.css?<%=new java.util.Date() %>" rel="stylesheet" />
<style>
.naver { 
	background: url("images/naverlogin.png") center; 
	background-size:cover;  
	border:none;
}
.kakao {
	background: url("images/kakaologin.png") center; 
	background-size:cover;  
	border:none;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>

</head>
<body>
<div class="d-flex" id="wrapper">
<!-- Sidebar-->
 
<!-- Page content wrapper-->
<div id="page-content-wrapper">
	<!-- Top navigation-->

	<!-- Page content-->
	<div class="container-fluid center">
		<a href='<c:url value="/"/>'><img src='<c:url value="/images/hanul.logo.png"/>'></a>
		<div class='box'>
		<ul>
			<li><input type='text' class='chk' id='userid' placeholder="아이디"></li>
			<li><input type='password' class='chk' id='userpw' placeholder="비밀번호"></li>
			<li><input onclick="console.log('button'); fn_login()" class='btn btn-primary' type='button' value='로그인'> </li>
			<li><hr></li>
			<li><input type='button' class='btn btn-secondary naver'></li>
			<li><input type='button' class='btn btn-secondary kakao'></li>
		</ul>
		</div>
	</div>
</div>
</div>
<script>
function emptyCheck(){
	var ok = true;
	$('.chk').each(function(){
		if( $(this).val()=='' ){
			var tag = $(this).attr('placeholder');
			alert(tag + ' 입력하세요');
			$(this).focus();
			ok = false;
			return ok;
		}		
	});
	return ok;
}
//네이버로그인 버튼 클릭시
$('.naver').click(function(){
	location='naverlogin.mb';
});
//카카오로그인 버튼 클릭시
$('.kakao').click(function(){
	location='kakaologin.mb';
});

//아이디에서 enter 키를 누를때 비번으로 커서이동
$('#userid').keypress(function(e){
	if( e.keyCode==13 )	$('#userpw').focus();
});

$('#userpw').keypress(function(e){
	//비번에서 enter 키를 누를때만 로그인처리되게
	if( e.keyCode==13 )	fn_login();
});


function fn_login(){
	//아이디, 비번이 모두 입력되어 있는지 확인
	if( ! emptyCheck() ) return;
	
	$.ajax({
		url: 'smartLogin.mb',
		data: { id: $('#userid').val(), pw:$('#userpw').val() },
		success: function( response ){
			if( JSON.parse(response) )
				location = '<c:url value="/"/>';
			else{
				alert("아이디나 비밀번호가 일치하지 않습니다");
			}
			
		},error: function(req, text){
			alert(text+':'+req.status);
		}
	});
}
</script>
</body>
</html>
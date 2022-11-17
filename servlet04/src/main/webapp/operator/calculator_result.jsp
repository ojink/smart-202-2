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
<div><a href='calculator.jsp'>계산기</a></div>
<hr>

<h3>EL 논리연산자</h3>
<div>no1: 값이 ${ empty param.no1 ? '없다' : '있다' }</div>
<div>no3: 값이 ${ empty param.no3 ? '없다' : '있다' }</div>
<div>no1 값 과 no2 값이 ${ !empty param.no1 and !empty param.no2 
							? '둘 다 있다' : '둘 다 있지는 않다'}  </div>
<div>no1값 과 no2 값이 ${empty param.no1 || empty param.no2 
							? '둘 중 적어도 한 개는 값이 없다'
							: '둘 다 값이 있다'}  </div>
<hr>

<h3>EL 비교연산자</h3>
<div>${param.no1} 와 ${param.no2} 중 더 큰 수는</div>
<div>숫자비교1: ${param.no1 gt (param.no2-0) ? param.no1 : param.no2}</div> 
<div>숫자비교2: ${param.no1 - param.no2 lt 0 ? param.no2 : param.no1}</div>
<hr>

<h3>EL 산술연산자</h3>
<div>${param.no1} + ${param.no2} = ${param.no1 + param.no2}</div>
<div>${param.no1} - ${param.no2} = ${param.no1 - param.no2}</div>
<div>${param.no1} * ${param.no2} = ${param.no1 * param.no2}</div>
<div>${param.no1} / ${param.no2} 
					= ${param.no2==0 ? 0 : param.no1 div param.no2}</div>
<div>${param.no1} % ${param.no2} 
					= ${param.no2==0 ? 0 : param.no1 mod param.no2}</div>









</body>
</html>
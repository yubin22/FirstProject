<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
</head>
<body>
<!-- 
1. 회원가입 성공 
2. 메인으로 넘어감 / 로그인 화면으로 넘어감
 -->
 <jsp:useBean id="login" class="model.LoginDTO" scope = "session"/>
<jsp:getProperty property="id" name="login"/>님,
 회원가입을 축하드립니다.
<br>

<form action="index.html">
<input type="button" value="홈으로">
</form>

<form action="registerAction.sp">
<input type="button" value="로그인">
</form>
</body>
</html>
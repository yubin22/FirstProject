<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<!-- 회원 정보 변경 / 탈퇴 -->
<!-- ${login.id} -->
<jsp:useBean id="login" class="model.LoginDTO" scope = "session"/>
당신의 id = <jsp:getProperty property="id" name="login"/>
<br>

<form action="deleteForm.sp">
<input type="submit" value="회원 탈퇴">
</form>

<form action="update.sp">
<input type="submit" value="회원 정보 수정">
</form>
</body>
</html>
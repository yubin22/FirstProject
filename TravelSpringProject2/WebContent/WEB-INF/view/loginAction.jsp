<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 
1. 아이디, 비밀번호가 잘못됐습니다. 경고창
2. 확인누르면 로그인폼으로
 -->
<jsp:useBean id="login" type="model.LoginDTO" scope = "session"/>
<head>

<script type="text/javascript">
	alert('아이디/비밀번호가 틀립니다.');
	history.back();
</script>

<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>

</body>
</html>



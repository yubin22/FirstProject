<!-- ${login.id} --><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script type="text/javascript">
        // 로그아웃 담당으로 이동
        function logout(){
            location.href="logoutAction.sp";
        }
</script>
</head>
<body>
<h2>메인 페이지</h2>
<!-- 로그인 후, 아이디 선택 시 afterLogin으로  -->
	<jsp:useBean id="login" type="model.LoginDTO" scope = "session"/>
	<a href="mainAction.sp">
		당신의 id = <jsp:getProperty property="id" name="login"/>
	</a>
<!-- 로그아웃 -->
<input type="button" value="로그아웃" onclick="logout()" />
</body>
</html>



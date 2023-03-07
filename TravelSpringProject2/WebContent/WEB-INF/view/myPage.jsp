<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript">
        // 로그아웃 담당으로 이동
        function logout(){
            location.href="logoutAction.sp";
        }
</script>
</head>
<body>
<!-- 회원 정보 변경 / 탈퇴 -->
<!-- ${login.id} -->
<jsp:useBean id="login" class="model.LoginDTO" scope = "session"/>
당신의 id = ${login.id}
<br>

<input type="button" value="회원 탈퇴" onclick="javascript:window.location='deleteForm.sp'">

<input type="button" value="회원 정보 수정" onclick="javascript:window.location='update.sp'">

<input type="button" value="로그아웃" onclick="logout()" />
</body>
</html>
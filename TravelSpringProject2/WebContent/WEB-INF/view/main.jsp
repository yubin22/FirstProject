<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:useBean id="login" type="model.LoginDTO" scope = "session"/>
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
	<a href="mainAction.sp">
		당신의 id = ${login.id}
	</a>
	<br>
	
<!-- 로그인 후, 여행지 저장 리스트로  -->
	<input type="button" value="저장한 여행지" onclick="javascript:window.location='myList.sp'" />
	
<!-- 로그인 후, 여행지 저장 리스트로  -->
	<input type="button" value="여행지 목록" onclick="javascript:window.location='spotList.sp'" />
	
<!-- 로그아웃 -->
<input type="button" value="로그아웃" onclick="logout()" />

</body>
</html>



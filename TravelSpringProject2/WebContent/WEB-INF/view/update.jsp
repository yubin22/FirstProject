<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 확인</title>
</head>
<body>
<h2>회원 확인</h2>
<!-- 회원 정보 수정 전 비밀번호 체크 -->
<form action="updateForm.sp" method="get">
<!-- 일반 회원 정보 변경:session에 로그인 필수 -->
<jsp:useBean id="login" type="model.LoginDTO" scope = "session"/>
<table>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="hidden" name="id" value='<jsp:getProperty property="id" name="login"/>' />
			<input type="password" name="pwd" size="12" maxlength="12"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type = "submit" value="수정하기" />
		</td>
	</tr>
</table>
</form>
</body>
</html>



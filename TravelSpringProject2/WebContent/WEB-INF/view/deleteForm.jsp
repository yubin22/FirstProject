<!-- ${login.id} --><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script type="text/javascript">
        // 비밀번호 미입력시 경고창
        function checkValue()
        {
            if(document.deleteForm.pwd.value ==""){
                alert("비밀번호를 입력하지 않았습니다.");
    			document.deleteForm.pwd.focus();
            }
        }
      //취소 시 main.sp로 이동
        function mypage(){
            location.href="main.sp";
        }
</script>
</head>
<body>
<h2>회원 탈퇴</h2>
<form name="deleteForm" action="deleteAction.sp" method="get">
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
			<input type = "submit" value="탈퇴" />
		</td>
	</tr>
	<tr>
		<td>
			<input type = "button" value="취소" onclick="mypage()" />
		</td>
	</tr>
</table>
</form>
</body>
</html>



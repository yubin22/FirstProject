<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script type="text/javascript">
        function checkLogin()
        {
            if(document.login.id.value =="")
            {//아이디 
                alert("아이디를 입력하세요");    
                document.login.id.focus();
            }else if(document.login.pwd.value =="")
            {//비밀번호
                alert("비밀번호를 입력하세요");    
                document.login.pwd.focus();
            }else{
            	document.login.submit();
            }
        }
    
        // 회원가입 버튼 클릭시 회원가입 화면으로 이동
        function goRegisterForm() {
            location.href="register.sp";
        }    
    </script>
</head>
<body>
<div id="wrap">
<!-- form -->
<h2>Login</h2>
	<form action="loginAction.sp" name="login" method="get">
				<table>
	                <tr>
	                    <td>아이디</td>
	                    <td><input type="text" name="id" maxlength="50"></td>
	                </tr>
	                <tr>
	                    <td>비밀번호</td>
	                    <td><input type="password" name="pwd" maxlength="50"></td>
	                </tr>
	            </table>
	            
	            <input type="button" value="로그인" onclick="checkLogin()"/>
            	<input type="button" value="회원가입" onclick="goRegisterForm()" />
	</form>
</div>
</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 변경</title>
<script type="text/javascript">
	//변경 시 메인 페이지로
	function goMain(){
		location.href="main.sp"
	}
</script>
</head>
<body>
<h2>회원 정보 변경</h2>
	<form action="updateAction.sp" method="get">
		<jsp:useBean id="login" type="model.LoginDTO" scope = "request"/>
			<table>
				<tr>
					<th>id : </th>
					<td>
						<input type="text" name="id" value='<jsp:getProperty property="id" name="login"/>' />
					</td>
				</tr>
				<tr>
					<th>비밀번호 : </th>
					<td>
						<input type="password" name="pwd" value='<jsp:getProperty property="pwd" name="login"/>'  size="12" maxlength="12"/>
					</td>
				</tr>
				<tr>
					<th>이름 : </th>
					<td>
						<input type="text" name="name" value='<jsp:getProperty property="name" name="login"/>'  size="12" maxlength="12"/>
					</td>
				</tr>
				
				<tr>
			        <th id="title">생년월일 : </th>
			        <td>
			        	<input type="text" name="birth" value='<jsp:getProperty property="birth" name="login"/>' >
			        </td>
			    </tr>
			                    
				<tr>
					<th id="title">성별 : </th>
					<td>
						<input name="gender" value='<jsp:getProperty property="gender" name="login"/>'>
					</td>
				</tr>
			                
				<tr>
					<th>mail : </th>
					<td>
						<input type="text" name="mail" value='<jsp:getProperty property="mail" name="login"/>' size="12" maxlength="50"/>
					</td>
				</tr>
			                    
				<tr>
					<th id="title">휴대전화 : </th>
					<td>
						<input  type="text" name="phone" value='<jsp:getProperty property="phone" name="login"/>'>
					</td>
				</tr>
				
				<tr>
					<th>주소 : </th>
					<td>
						<input type="text" name="address" value='<jsp:getProperty property="address" name="login"/>'  size="50" maxlength="50"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type = "submit" value="저장" onclick="goMain()"/>
					</td>
				</tr>
			</table>
	</form>
</body>
</html>



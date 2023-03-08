<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관광지 상세 페이지</title>
</head>
<body>
<!-- 비회원이 보는 관광지 설명 페이지 -->
관광지 설명
<br>

	<table>
		<tr>
			<td>지명</td>
		</tr>
	
		<tr>
			<td>${save.region}</td>
		</tr>
	</table>
<input type="hidden" name="id" value='${login.id}' />
<input type="hidden" name="id" value='${save.locationNum}' />

<input type = "button" value="저장" onclick="javascript:window.location='spot.sp'"/>

</body>
</html>
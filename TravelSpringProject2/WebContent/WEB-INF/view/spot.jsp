<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관광지 상세 페이지</title>
<script type="text/javascript">

	//서버로 전송 할 데이터
	const form = {
			id : '${login.id != null}',
			locationNum : '${save.locationNum}'
	}
	
	function save() {
		alert("목록으로 가시겠습니까?");
		location.href="myList.sp?id="+document.id.value;
	}
</script>
</head>
<body>
관광지 설명
<br>

<!-- 로그인 안 됐을때 -->
<c:if test = "${login eq null}">
	<script type="text/javascript">
		location.href="loginForm.sp";
	</script>
</c:if>

<input type = "button" value="저장" onclick="save()"/>
<input type="hidden" name="id" value='${login.id}' />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관광지 목록 페이지</title>
</head>
<body>
<!-- db에서 뿌려지는 -->
관광지 목록
<br>

<input type = "button" value="상세 보기" onclick="javascript:window.location='spotInfo.sp'"/>
<input type="hidden" name="id" value='${login.id}' />
</body>
</html>
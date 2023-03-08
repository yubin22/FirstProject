<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:useBean id="dto" class="model.SaveLocationDTO"  scope="request" />
<jsp:useBean id="map" type="java.util.Collection"  scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv = "Content-Type">
<title>관광지 목록 페이지</title>
</head>
<body>
<!-- 비회원용-->
관광지 목록
<br>
<table border="1">
		<tr>
			<td colspan='2'>지명</td>
		</tr>

		<c:forEach items="${map}" var = "map">
			<tr>
				<td>${map.region}</td>
				<td>
					<input type="hidden" name="locationNum" value='${map.locationNum}' /><!-- '<jsp:getProperty name="dto" property="locationNum" />' -->
				</td>
				
				<td><span>
					<input type = "button" value="상세 보기" onclick="javascript:window.location='spotInfo.sp?locationNum='"+{map.locationNum}/>
				</span></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
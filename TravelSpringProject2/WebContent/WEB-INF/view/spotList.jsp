<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:useBean id="dto" class="model.SaveLocationDTO"  scope="request" />
<jsp:useBean id="list" type="java.util.Collection"  scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv = "Content-Type">
<title>여행지 목록 페이지</title>
</head>
<body>
여행지 목록
<br>
<table>
		<tr>
			<td colspan='2'>여행지</td>
		</tr>

		<c:forEach items="${list}" var = "list">
			<tr>
				<td>${list.picture}</td>
				<td>${list.locationName}</td>
				<td>${list.prefecture}</td>
				<td>${list.region}</td>
				<td>
					<input type="hidden" name="locationNum" value='${list.locationNum}' /><!-- '<jsp:getProperty name="dto" property="locationNum" />' -->
				</td>
				
				<td><span>
					<input type = "button" value="상세 보기" onclick="javascript:window.location='spotInfo.sp?locationNum=${list.locationNum}'"/>
				</span></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
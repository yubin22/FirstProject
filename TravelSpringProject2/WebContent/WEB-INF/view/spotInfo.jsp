<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 상세 페이지</title>
</head>
<body>
여행지 설명
<br>
<form name="spotInfo" action="saveAction.sp" method="get" onsubmit="return confirm('저장한 목록 보시겠습니까?')">
	
	<table>
		<tr>
			<td></td>
		</tr>
	
		<tr>
			<td>${info.picture}</td>
			<td>${info.locationName}</td>
			<td>${info.prefecture}</td>
			<td>${info.region}</td>
			<td>${info.type}</td>
			<td>${info.season}</td>
		</tr>
	</table>
	
		<input type="hidden" name="id" value='${login.id}' />
		<input type="hidden" name="locationNum" value='${info.locationNum}' />
		
		<input type = "submit" value="저장" class = "btn_cart"/>		<!-- onclick="javascript:window.location='spotAction.sp'"  spot.sp -->
		
		<!-- 다시 여행지 페이지로  -->
		<input type="button" value="여행지" onclick="javascript:window.location='spotList.sp'" />
		
</form>
<script type="text/javascript">

	//서버로 전송 할 데이터
	const form = {
		id : '${login.id}',
		locationNum : '${info.locationNum}'
	};
	
	//저장버튼 누르면
	//$(".btn_cart").on("click", function(e){
	//$(document).on("click", '.btn_cart', function(e){
	$('.btn_cart').click(function(){
		$.ajax({
			url : 'saveAction.sp',
			type : 'GET',
			data : form,
			success : function(result) {
				cartAlert(result);
			}
		})
	});

	function cartAlert(result){
		if(result == '0'){
			alert("추가를 하지 못하였습니다.");
		} else if(result == '1'){
			alert("추가되었습니다.");
		} else if(result == '2'){
			alert("이미 추가되어져 있습니다.");
		} 
	};
	
	/*function save() {
		alert("저장한 여행지 보러 가시겠습니까?");
		location.href="myList.sp?id="+${login.id};
	}*/
	
</script>
</body>
</html>
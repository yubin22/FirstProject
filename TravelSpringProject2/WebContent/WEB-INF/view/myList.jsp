<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<div class="section">
<!-- 체크 박스 전체 -->
				<div class = "all_check">
					<input type="checkbox" class = "all_check_input" checked="checked"><span class = "all_check_span">전체선택</span>
				</div>
				
				<table class="subject_table">
					<tbody>
						<tr>
							<th class="td_width_1"> </th>
							<th class="td_width_2"></th>
							<th class="td_width_3">관광지명</th>
							<th class="td_width_4">삭제</th>
						</tr>
					</tbody>
				</table>
				
				<table class="cart_table">
					<tbody>
						<c:forEach items="${cartInfo}">		<!-- 내 장바구니에 있는 기본 정보 가져옴. 장바구니에 저장된 개수만큼 -->
							<tr>
								<td class="td_width_1">
									<input type="checkbox" class="individual_checkbox" checked="checked">
								</td>
								
								<!-- 이미지 -->
								<td class="td_width_2"></td>
								
								<td class="td_width_3">${cartInfo.region}</td>
								
								<td class="td_width_4 table_text_align_center delete_btn">
									<button class = "delete_btn" data-cartid = "${cartId}">삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 삭제 form -->
				<form action="delete.sp" method = "get" class = "delete_form">
					<input type = "hidden" name = "cartId" class ="delete_cartId">
					<input type = "hidden" name = "id" value="${login.id}">
				</form>
				
				<!-- 계획 만들기 -->
				<input type = "button" value="계획세우기" onclick="javascript:window.location='makeList.sp'"/>
				
				<!-- 목록 가기 -->
				<input type = "button" value="여행지 추가하기" onclick="javascript:window.location='spotList.sp'"/>
</div>

	<script type="text/javascript">
	
		//체크 박스 전체선택에서
		$(".all_check_input").on("click", function() {
			
			if($("all_check_input").prop("checked")){
				
				//개별 전체 체크
				$(".individual_checkbox").attr("checked", true);
				
			}else{
				
				//전체 체크 해제
				$(".individual_checkbox").attr("checked", false);
			}
		});
		
		//장바구니 삭제
		$(".delete_btn").on("click", function(e) {
			
			//기본 동작 x
			e.preventDefault();
			//id변수 선언 -> 해당 객체의 locationNum 대입
			const id = ${save.locationNum};
			$(".delete_cartId").val(cartId);
			$(".delete_form").submit();
			
		});
	
	</script>
</body>
</html>
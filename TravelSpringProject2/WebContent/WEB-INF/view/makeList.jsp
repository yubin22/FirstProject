<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 계획</title>
</head>
<body>
<div class="section">
				
				<table class="subject_table">
					<tbody>
						<tr>
							<th class="td_width_1"></th>
							<th class="td_width_2"></th>
							<th class="td_width_3">여행지명</th>
							<th class="td_width_4">삭제</th>
						</tr>
					</tbody>
				</table>
				
				<table class="cart_table">
					<tbody>
						<c:forEach items="${save}">		<!-- 내 장바구니에 있는 기본 정보 가져옴 -->
							<tr>
								<td class="td_width_1"></td>
								<td class="td_width_2"></td>
								<td class="td_width_3">${save.region}</td>
								<td class="td_width_4 table_text_align_center delete_btn"><button>삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 계획 만들기 -->
				<input type = "button" value="계획세우기" onclick="javascript:window.location='spotList.sp'"/>
				
				<!-- 목록 가기 -->
				<input type = "button" value="여행지 추가하기" onclick="javascript:window.location='spotList.sp'"/>
</div>
</body>
</html>
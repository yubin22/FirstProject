<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<%!
	// 변수 선언

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String user = "c##scott";
	String password = "tiger";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String sql = "select region from location where location_num=1";
	String region="";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관광지 상세 페이지</title>
</head>
<%
		try {
			// 데이터베이스를 접속하기 위한 드라이버 SW 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스에 연결하는 작업 수행
			con = DriverManager.getConnection(url, user, password);
			// 쿼리를 생성gkf 객체 생성
			stmt = con.createStatement();
			// 쿼리 생성
			rs = stmt.executeQuery(sql);
%>
<body>
	<!-- 비회원이 보는 관광지 설명 페이지 -->
		관광지 설명
	<br>

<!-- 로그인 안 됐을때 -->
<c:if test = "${login eq null}">
	<script type="text/javascript">
		alert("로그인 후 이용해주세요.");
		location.href="loginForm.sp";
	</script>
</c:if>

<table>
		<tr>
			<td>지명</td>
		</tr>
		
		<%
			//Seoul에 해당하는 값만 가져오려면...? -> sql에서 where로 하는거 말고...
			while (rs.next()) 
			{
				region = rs.getString("region");
		%>
		
		<tr>
			<td><%=region%></td>
		</tr>
		
		<%
			}
		} catch (Exception e) {
			e.printStackTrace();
			} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	%>
</table>

<input type = "button" value="저장" class = "btn_cart" />			<!-- onclick="save()" -->
<input type="hidden" name="id" value='${login.id}' />

<script type="text/javascript">

	//서버로 전송 할 데이터
	const form = {
		id : '${login.id}',
		region : '<%=region%>'
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
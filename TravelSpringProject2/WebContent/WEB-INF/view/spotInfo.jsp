<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%!
	// 변수 선언

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String user = "c##scott";
	String password = "tiger";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String sql = "select region from location where location_num=1";
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

<table>
		<tr>
			<td>지명</td>
		</tr>
		
		<%
			//Seoul에 해당하는 값만 가져오려면...? -> sql에서 where로 하는거 말고...
			while (rs.next()) 
			{
		%>
		
		<tr>
			<td><%=rs.getString("region")%></td>
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
	
<input type = "button" value="저장" onclick="javascript:window.location='spot.sp'"/>
<input type="hidden" name="id" value='${login.id}' />

</body>
</html>
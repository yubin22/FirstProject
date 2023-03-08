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
	String sql = "select region from location";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv = "Content-Type">
<title>관광지 목록 페이지</title>
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
<!-- 회원용-->
관광지 목록
<br>
<table border="1">
		<tr>
			<td colspan='2'>지명</td>
		</tr>
		
		<%
			while (rs.next()) 
			{
		%>
		
		<tr>
			<td><%=rs.getString("region")%></td>
			<td><span>
			<input type = "button" value="상세 보기" onclick="javascript:window.location='spot.sp'"/>
			</span></td>
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

<input type="hidden" name="id" value='${login.id}' />
</body>
</html>
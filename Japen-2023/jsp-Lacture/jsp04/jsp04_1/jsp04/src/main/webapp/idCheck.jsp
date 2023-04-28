<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>
<%

request.setCharacterEncoding("UTF-8");

String userID = request.getParameter("userID");


String driver = "oracle.jdbc.OracleDriver";

String url = "jdbc:oracle:thin:@localhost:1521:xe";

String id = "KIMJIEUN99";

String pw = "1112";


Connection conn = null;

PreparedStatement pstmt = null;

ResultSet rs = null;


String sql = "SELECT COUNT(*)AS COUNT FROM MEMBER02 WHERE USERID = ?";

int result = 0;

try {

//1. 드라이버 찾기

Class.forName(driver);

//2. db 연결

conn = DriverManager.getConnection(url, id, pw);

// 쿼리 날리기.

pstmt = conn.prepareStatement(sql);

pstmt.setString(1,userID);

rs = pstmt.executeQuery();
if(rs.next()){
	result = rs.getInt("COUNT");
	System.out.println(result);
	out.println(result);
}

} catch (Exception e) {

e.printStackTrace();

} finally {

if(pstmt!=null) pstmt.close();

if(conn!=null) conn.close();

}

%>
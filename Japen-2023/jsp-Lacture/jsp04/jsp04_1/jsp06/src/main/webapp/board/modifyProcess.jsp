<%@page import="com.kimjieun99.utils.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
// 넘어온 데이터 받기
int idx = Integer.parseInt(request.getParameter("idx"));
String userPW = request.getParameter("userPW");
String userName = request.getParameter("userName");
String subject = request.getParameter("subject");
String contents = request.getParameter("contents");

System.out.println(idx);

// db연결
String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "KIMJIEUN99";
String pw = "1112";

Connection conn = null;
PreparedStatement pstmt = null;

String sql = "UPDATE BOARD SET CONTENTS = ? WHERE NO = ? AND USERPW = ?";

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,contents);
	pstmt.setInt(2,idx);
	pstmt.setString(3,userPW);
	
	int result = pstmt.executeUpdate();
	if(result>0){
		ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "패스워드를 확인해 주세요.");
	}
	
} catch(Exception e){
	e.printStackTrace();
} finally {
	if(pstmt!=null) pstmt.close();
	if(conn!=null) conn.close();
	
}
%>
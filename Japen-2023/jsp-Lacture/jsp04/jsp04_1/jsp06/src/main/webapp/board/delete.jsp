<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%
// 1. 서버로 데이터 보내기 
// => form을 이용<from action="서버주소" method="">, queryString 이용 url주소?키=값&키=값,
// ajax $.ajax({url:서버주소,data:{키:값,키:값})

//String idx = request.getParameter("idx"); 
%>
<%
String userPW = request.getParameter("userPW");
int idx = Integer.parseInt(request.getParameter("idx"));

System.out.println(userPW+"==="+idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteProcess.jsp" method="POST">
<input type="hidden" name="idx" value="<%= idx %>">
<input type="password" name="userPW">
<div>
<button>삭제</button>
<button type="reset">취소</button>
<a href="list.jsp">목록</a>
</div>
</form>
</body>
</html>
<%@ include file="../include/footer.jsp" %>
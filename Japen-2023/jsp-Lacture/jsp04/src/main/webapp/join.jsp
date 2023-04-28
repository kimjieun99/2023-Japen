<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/jsp04_1/js/jquery-3.6.3.min.js"></script>
</head>
<body>
<header id="header" class="header">
<h1 id="logo">
<a href="">KIM JIEUN`S MEDIA LAB</a>
</h1>
<nav id="gnb">
<h2 class="blind">global navigation</h2>
<ul class="list">
<li><a href="">회원가입</a>
<li><a href="">로그인</a>
</ul>
</nav>
</header>
<form action="joinProcess.jsp" method="POST">
<table>
<colgroup>
<col style="width:20%">
<col style="width:80%">
</colgroup>
<tbody>
<tr>
<th>아이디</th>
<td>
<input type="text" name="userID" id="userID" placeholder="아이디를 입력하세요." required />
</td>
</tr>
<tr>
<th>패스워드</th>
<td>
<input type="password" name="userPW" id="userPW" placeholder="비밀번호를 입력하세요.">
</td>
</tr>
<tr>
<th>패스워드 확인</th>
<td>
<input type="password" name="userPWConfirm" id="userPWConfirm" placeholder="패스워드를 입력하세요.">
</td>
</tr>
<tr>
<th>이름</th>
<td>
<input type="text" name="userName" id="userName" placeholder="이름을 입력하세요.">
</td>
</tr>
<tr>
<th>이메일</th>
<td>
<input type="text" name="userEmail" id="userEmail" placeholder="메일을 입력하세요.">
</td>
</tr>
<tr>
<th>전화번호</th>
<td>
<input type="text" name="userHp" id="userHp" placeholder="전화번호를 입력하세요.">
</td>
</tr>
<tr>
<th>주소</th>
<td>
<div><input type="text" name="userZipcode" id="userZipcode" placeholder="우편번호를 입력하세요." readonly/>
<button class="btn zipCode">우편번호</button>
</div>
<div><input type="text" name="userAddr01" id="userAddr01" placeholder="기본주소" readonly/>
<span>기본주소</span></div>
<div><input type="text" name="userAddr02" id="userAddr02" placeholder="상세주소" readonly/>
<div><input type="text" name="userAddr03" id="userAddr03" placeholder="참고사항" readonly/>
</div>
</td>
</tr>
</tbody>
</table>
<div>
<button>회원가입</button>
<button type="reset">취소</button>
</div>
</form>
<script>
// jQuery alias $
const userID = document.querySelector("#userID");
const jUserID = $("#userID"); //wrapping 함수
console.log(userID); // 정확하게 선택된 돔 결과만 보여준다.
console.log(jUserID); // jQuery로 래핑한 결과를 보여준다.

$(".zipCode").on("click", function() {
	return false;
});

$(".confirm").on("click", function(){
	if($("#userID").val()==="") {
		alert("아이디를 확인해주세요.");
		$("#userID").focuse();
		return false;
	}
	if($("#userPW").val()==="") {
		alert("패스워드를 확인해주세요.");
		$("#userPW").focuse();
		return false;
	}
	if($("#userPWConfirm").val()==="") {
		alert("패스워드를 다시 입력해주세요.");
		$("#userPWConfirm").focuse();
		return false;
	}
	if($("#userPWConfirm").val()!==$("#userPW").val()) {
		alert("패스워드가 같지 않습니다..");
		$("#userPWConfirm").focuse();
		return false;
	}
});
</script>
</body>
</html>
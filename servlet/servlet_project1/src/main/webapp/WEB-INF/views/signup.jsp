<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<!-- 아이디, 비번, 비번확인, 이메일을 입력받아 서버로 전송하는 코드 -->
	<form action="<%=request.getContextPath() %>/signup" method="post">
		<input type="text" name="id" placeholder="아이디">
		<br>
		<input type="password" name="pw" placeholder="비밀번호">
		<br>
		<input type="password" name="pw2" placeholder="비밀번호확인">
		<br>
		<input type="email" name="email" placeholder="이메일">
		<br>
		<button>회원가입</button>
	</form>
</body>
</html>
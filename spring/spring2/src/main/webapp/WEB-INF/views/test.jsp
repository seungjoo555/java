<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>테스트</title>
</head>
<body>
	<!-- 객체.변수명을 호출하면 멤버변수가 호출되는 것이 아니라 멤버변수의 getter가 호출 됨 -->
	<h1>아이디 : ${user.id}</h1>
	<h1>비밀번호 : ${user.pw}</h1>
	<h1>둘다 : ${user.idPw }</h1>
	<!--
		축구, 야구, 농구, 테니스, 음악감상 중에서 취미를 선택해서 서버에 전송하고,
		서버에서는 화면에서 보낸 취미를 콘솔에 출력하고 메인 페이지로 리다이렉트
		- 다중 선택이 가능
		- 첨부 파일
	-->
	<form action="<c:url value="/hobby"/>" method="get">
		<h1>당신의 취미는?</h1>
		<label for="football">
			<input type="checkbox" name="hobby" id="football" value="축구">축구
		</label>
		<label for="baseball">
			<input type="checkbox" name="hobby" id="baseball" value="야구">야구
		</label>
		<label for="basket">
			<input type="checkbox" name="hobby" id="basket" value="농구">농구
		</label>
		<label for="tenis">
			<input type="checkbox" name="hobby" id="tenis" value="테니스">테니스
		</label>
		<label for="music">
			<input type="checkbox" name="hobby" id="music" value="음악감상">음악감상
		</label>
		<button type="submit">전송</button>
	</form>
</body>
</html>
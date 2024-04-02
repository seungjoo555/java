<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>샌드오브젝트</title>
</head>
<body>
	<form action="<c:url value="/send/object"/>" method="post">
		<label>아이디1 :</label>
		<input type="text" name="list[0].id" placeholder="아이디 입력">
		<br>
		<label>비번1 :</label>
		<input type="password" name="list[0].pw" placeholder="비밀번호 입력">
		<br>
		<label>아이디2 :</label>
		<input type="text" name="list[1].id" placeholder="아이디 입력">
		<br>
		<label>비번2 :</label>
		<input type="password" name="list[1].pw" placeholder="비밀번호 입력">
		<br>
		<label>아이디3 :</label>
		<input type="text" name="list[2].id" placeholder="아이디 입력">
		<br>
		<label>비번3 :</label>
		<input type="password" name="list[2].pw" placeholder="비밀번호 입력">
		<br>
		<button type="submit">전송</button>
	</form>
</body>
</html>
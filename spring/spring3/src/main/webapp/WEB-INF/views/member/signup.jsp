<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<form action="<c:url value="/signup"/>" method="post">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" name="me_id" class="form-control" placeholder="아이디" id="id" required>
		</div>
		<div class="form-group">
			<label for="pw">비밀번호:</label>
			<input type="password" name="me_pw" class="form-control" placeholder="비밀번호" id="pw" required>
		</div>
		<div class="form-group">
			<label for="pw2">비밀번호 확인:</label>
			<input type="password" class="form-control" placeholder="비밀번호 확인" id="pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="text" name="me_email" class="form-control" placeholder="이메일" id="email" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
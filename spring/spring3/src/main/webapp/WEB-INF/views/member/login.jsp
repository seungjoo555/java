<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<form action="<c:url value="/login"/>" method="post">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" name="me_id" class="form-control" placeholder="아이디" id="id" required>
		</div>
		<div class="form-group">
			<label for="pw">비밀번호:</label>
			<input type="password" name="me_pw" class="form-control" placeholder="비밀번호" id="pw" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
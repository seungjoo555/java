<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>글쓰기!!!</h1>
	<form action="<c:url value="/post/insert"/>" method="post">
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" name="bo_title" class="form-control" placeholder="제목입력" id="title" required>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea name="bo_content" rows="10" class="form-control" id="content"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-success">글 등록</button>
	</form>
</div>
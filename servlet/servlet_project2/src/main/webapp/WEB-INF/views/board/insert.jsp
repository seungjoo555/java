<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
	<div class="container mt-3">
		<form action="<c:url value="/board/insert"/>" method="post">
			<h1>게시글 등록</h1>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">제목</label>
				<input type="text" class="form-control" id="title" placeholder="제목 입력" name="title">
			</div>
			<div class="mb-3 mt-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" rows="10" id="content" name="content"></textarea>
			</div>
			<button type="submit" class="btn btn-success col-12">글 등록</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>글 쓰기</title>
	 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form action="<c:url value="/board/insert"/>" method="post" enctype="multipart/form-data">
		<h1>글 등록하기</h1>
		<hr>
		<div class="form-group">
			<label for="coName">게시판:</label>
			<select id="coName" name="bo_co_num" class="form-control">
				<c:forEach items="${list}" var="community">
					<option value="${community.co_num}">${community.co_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
		  <label for="bo_title">제목:</label>
		  <input type="text" class="form-control" id="bo_title" name="bo_title">
		</div>
		<div class="form-group">
		  <label for="bo_content">내용:</label>
		  <textarea type="text" class="form-control" id="bo_content" name="bo_content"></textarea>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control" name="file"/>
			<input type="file" class="form-control" name="file"/>
			<input type="file" class="form-control" name="file"/>
		</div>
		<button class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
<script type="text/javascript">
//서버에 전송하기 전에 제목, 내용 글자수 확인
$("form").submit(function(){
	let title = $("[name=bo_title]").val();
	if(title.length == 0){
		alert("제목은 1글자 이상 입력해야 합니다.");
		$("[name=bo_title]").focus();
		return false;
	}
	let content = $("[name=bo_content]").val();
	if(content.length == 0){
		alert("내용은 1글자 이상 입력해야 합니다.");
		$("[name=bo_content]").focus();
		return false;
	}
});

$('[name=bo_content]').summernote({
	placeholder : 'Hello Bootstrap 5',
	tabsize : 2,
	height : 100
});
</script>
</body>
</html>
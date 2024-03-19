<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<div>
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div>
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div>
		<label>조회수</label>
		<div class="form-control">${board.bo_view}</div>
	</div>
	<div class="input-group mb-3 mt-3">
		<button class="btn btn-outline-success btn-up col-6">good</button>
		<button class="btn btn-outline-success btn-down col-6">bad</button>
	</div>
	<div>
		<label>내용</label>
		<div class="form-control" style="min-height: 300px">${board.bo_content}</div>
	</div>
	<div>
		<c:choose>
			<c:when test="${fileList.size() != 0}">
				<label>첨부파일</label>
				<c:forEach items="${fileList}" var="file">
					<a href="<c:url value="/download/${file.fi_name}"/>"
						class="form-control"
						download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>첨부파일 없음</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="container-comment mt-3 mb-3">
		<h2>댓글(<span class="comment-total">2</span>)</h2>
		<div class="box-comment-list">
			<div class="box-comment row">
				<div class="col-3">아이디</div>
				<div class="col-9">내용</div>
			</div>
		</div>
		<div class="box-pagination">
			<ul class="pagination justify-content-center"></ul>
		</div>
		<div class="box-commnt-insert">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<textarea class="form-control textarea-comment"></textarea>
					<button class="btn btn-outline-success btn-comment-insert">댓글등록</button>
				</div>
			</div>
		</div>
		<hr>
	</div>
	
	<c:url value="/board/list" var="url">
		<c:param name="page" value="${cri.page}"/>
		<c:param name="type" value="${cri.type}"/>
		<c:param name="search" value="${cri.search}"/>
	</c:url>
	<a href="${url}" class="btn btn-outline-dark">목록으로</a>
	<c:if test="${user.me_id == board.bo_me_id}">
		<a href="<c:url value="/board/delete?boNum=${board.bo_num}"/>" class="btn btn-outline-success">삭제</a>
		<a href="<c:url value="/board/update?boNum=${board.bo_num}"/>" class="btn btn-outline-warning">수정</a>
	</c:if>
<!-- 댓글 리스트 조회 -->
<script type="text/javascript">
//댓글 페이지 정보를 가지고 있는 객체를 선언
let cri = {
	page : 1,
	search : "${board.bo_num}"
}

getCommentList(cri);

function getCommentList(cri){
	$.ajax({
		async : true,
		url : '<c:url value="/comment/list"/>', 
		type : 'post', 
		data : JSON.stringify(cri),
		//서버로 보낼 데이터 타입
		contentType : "application/json; charset=utf-8",
		//서버에서 보낸 데이터의 타입
		dataType : "json", 
		success : function (data){
			displayCommentList(data.list);
			displayCommentPagination(data.pm);
			$('.comment-total').text(data.pm.totalCount);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
}

function displayCommentList(list){
	let str = '';
	if(list == null || list.length == 0){
		str = '<h3>등록된 댓글이 없습니다.</h3>';
		$('.box-comment-list').html(str);
		return;
	}
	for(item of list){
		str += 
		`
			<div class="box-comment row">
				<div class="col-3">\${item.cm_me_id}</div>
				<div class="col-9">\${item.cm_content}</div>
			</div>
		`
	}
	$('.box-comment-list').html(str);
}
function displayCommentPagination(pm){
    
	let str = '';
	if(pm.prev){
		str += `
		<li class="page-item">
			<a class="page-link" href="javascript:void(0);" data-page="\${pm.startPage - 1}">이전</a>
		</li>`;		
	}
	for(let i = pm.startPage; i<= pm.endPage; i++){
		let active = pm.cri.page == i ? 'active' : '';
		str += `
		<li class="page-item \${active}">
			<a class="page-link" href="javascript:void(0);" data-page="\${i}">\${i}</a>
		</li>`;	
	}
	
	if(pm.next){
		str += `
		<li class="page-item">
			<a class="page-link" href="javascript:void(0);" data-page="\${pm.endPage + 1}">다음</a>
		</li>`;	
	}
	$('.box-pagination>ul').html(str);
}
$(document).on('click','.box-pagination .page-link',function(){
	cri.page = $(this).data('page');
	getCommentList(cri);
})
</script>
<!-- 댓글 등록 -->
<script type="text/javascript">
//댓글 등록 버튼의 클릭 이벤트를 등록
$(".btn-comment-insert").click(function(){
	//서버에 보낼 데이터를 생성 => 댓글 등록을 위한 정보 => 댓글 내용, 게시글 번호
	let comment = {
		cm_content : $('.textarea-comment').val(),
		cm_bo_num : '${board.bo_num}'
	}
	console.log(comment);
	//서버에 데이터를 전송
	$.ajax({
		async : true,
		url : '<c:url value="/comment/insert"/>', 
		type : 'post',
		data : JSON.stringify(comment), 
		contentType : "application/json; charset=utf-8",
		dataType : "json", 
		success : function (data){
			console.log(data);
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log(xhr);
			console.log(textStatus);
		}
	});
});
</script>
</body>
</html>
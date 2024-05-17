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
		    <input type="file" class="form-control" name="file" id="fileInput" multiple>
		</div>
		<div id="fileList"></div>
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
	height: 400,
	callbacks: {
 		// 이미지를 업로드할 경우 이벤트를 발생
	   	onImageUpload: function(files, editor, welEditable) {
	   		sendFile(files[0], this);
		},
		// 미디어(이미지 포함)을 삭제할 경우 이벤트를 발생
		onMediaDelete: function ($target, editor, $editable) {
			//이미지 경로를 추출
	    	var deletedImageUrl = $target
	    	.attr('src')
	        .replace("<c:url value='/download'/>","");
			//해당 이미지를 서버에서 삭제해달라고 요청(ajax로)
	     	removeImg(deletedImageUrl)
		}
	}
});

function sendFile(file, editor) {
	data = new FormData();
	data.append("file", file);
	//첨부파일을 ajax로 보내는 예제		
	$.ajax({
		data: data,
    	type: "post",
    	url: '<c:url value="/img/upload"/>',
 		cache : false,
    	contentType : false,	
    	processData : false,
    	success : function(data){
    		console.log(data);
    		$(editor).summernote('editor.insertImage', "<c:url value='/download'/>"+data.url);
    	}
	});
}
//업로드된 이미지를 삭제하는 함수
function removeImg(imageName){
	data = new FormData()
	data.append('file', imageName)
	$.ajax({
    	data: data,
      	type: 'POST',
      	url: '<c:url value="/img/delete"/>',
      	contentType: false,
      	processData: false,
      	success : function(data){
    		console.log(data);
      }
  })
}

const dataTransfer = new DataTransfer();

$("#fileInput").change(function(){
    let fileArr = document.getElementById("fileInput").files;
    let fileList = document.getElementById('fileList');
    
    if(fileArr != null && fileArr.length > 0){

        // Add new files to dataTransfer
        for(let i = 0; i < fileArr.length; i++){
            dataTransfer.items.add(fileArr[i]);
        }
    }
    
    fileList.innerHTML = '';
    
    for (let i = 0; i < dataTransfer.files.length; i++) {
        let listItem = document.createElement('div');
    	let deleteButton = document.createElement('button');
    	deleteButton.type = "button";
    	deleteButton.setAttribute('data-index', i); // 삭제할 파일의 인덱스 저장
        
        // 파일 이름 표시
        listItem.textContent = dataTransfer.files[i].name;
        // 삭제 버튼 생성 및 속성 설정
        deleteButton.textContent = '삭제';
        deleteButton.classList.add('remove_button');
        
        
        listItem.appendChild(deleteButton);
        fileList.appendChild(listItem);
    }

    // Update file input with new files
    document.getElementById("fileInput").files = dataTransfer.files;
    console.log("dataTransfer =>", dataTransfer.files);
    console.log("input Files =>", document.getElementById("fileInput").files);
    
});

$("#fileList").on("click", ".remove_button", function(event){
	let fileList = document.getElementById('fileList');
	
    if(event.target.className=='remove_button'){
        //console.log(event.target.dataset.index )
        targetFile = event.target.dataset.index;
        console.log(targetFile);
    	dataTransfer.items.remove(targetFile);
    	//fileList.removeChild(fileList.childNodes[targetFile]);
    }
    
    fileList.innerHTML = ''; // 이전 목록 지우기
    
    for (let i = 0; i < dataTransfer.files.length; i++) {
    	let listItem = document.createElement('div');
    	let deleteButton = document.createElement('button');
    	deleteButton.type = "button";
    	deleteButton.setAttribute('data-index', i); // 삭제할 파일의 인덱스 저장
        // 파일 이름 표시
        listItem.textContent = dataTransfer.files[i].name;
        // 삭제 버튼 생성 및 속성 설정
        deleteButton.textContent = '삭제';
        deleteButton.classList.add('remove_button'); // file-del 클래스 추가
        
        listItem.appendChild(deleteButton);
        fileList.appendChild(listItem);
    }

    // Update file input with new files
    document.getElementById("fileInput").files = dataTransfer.files;
    console.log("dataTransfer =>", dataTransfer.files);
    console.log("input Files =>", document.getElementById("fileInput").files);
    
});

/*function updateFileList() {
    let fileList = document.getElementById('fileList');
    fileList.innerHTML = ''; // 이전 목록 지우기
    
    let files = document.getElementById('fileInput').files;
    for (let i = 0; i < files.length; i++) {
    	let listItem = document.createElement('div');
    	let deleteButton = document.createElement('a');
        
        // 파일 이름 표시
        listItem.textContent = files[i].name;
        // 삭제 버튼 생성 및 속성 설정
        deleteButton.textContent = '삭제';
        deleteButton.classList.add('.remove_button'); // file-del 클래스 추가
        deleteButton.setAttribute('data-index', i); // 삭제할 파일의 인덱스 저장
        
        listItem.appendChild(deleteButton);
        fileList.appendChild(listItem);
        
        // 삭제 버튼 클릭 이벤트 리스너 추가
        deleteButton.addEventListener('click', function() {
        	let index = parseInt(this.getAttribute('data-index'));
        	let input = document.getElementById('fileInput');
        	let files = Array.from(input.files);
            files.splice(index, 1); // 파일 배열에서 해당 파일 제거
            let newFileList = new DataTransfer(); // 새로운 DataTransfer 객체 생성
            files.forEach(function(file) {
                newFileList.items.add(file); // 새로운 객체에 파일 추가
            });
            input.files = newFileList.files; // 입력 파일 업데이트
            updateFileList(); // 파일 목록 다시 표시
        });
    }
}
*/
</script>
</body>
</html>
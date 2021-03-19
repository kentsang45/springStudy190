<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<br></br>

<div class="container">
<h1>
	Write what you think!
</h1>


<!-- 제목 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Title</span>
  </div>
  <input name="boardTitle" type="text" class="form-control"
  aria-label="title" aria-describedby="basic-addon1">

</div>


<!-- 내용 
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">내용</span>
  </div>
  <input name="boardContent" type="text" class="form-control" placeholder="${board.content}" 
  aria-label="content" aria-describedby="basic-addon1" value="내용">
</div>
-->


<!-- 글쓴이 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">ID</span>
  </div>
  <input name="boardWriter" type="text" class="form-control" placeholder="${board.writer}" 
  aria-label="writer" aria-describedby="basic-addon1" readonly value="TESTWRITER">
</div>

<!-- 내용 -->
<div class="form-group">
    <label for="exampleFormControlTextarea1"></label>
    <textarea class="form-control textArea" id="exampleFormControlTextarea1" rows="5" style="resize: none"></textarea>
</div>

<!-- 파일 업로드 -->
<div class="input-group">
  <div class="custom-file uploadDiv">
    <input name='uploadInput' type="file" multiple='multiple' class="custom-file-input" id="inputGroupFile04">
    <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
  </div>
  <!--
  <div class="input-group-append">
    <button class="uploadButton btn btn-outline-secondary" type="button">Upload</button>
  </div>
  -->
</div>

<!-- 업로드한 파일 리스트 -->
<div class="uploadList list-group">
</div>

<br></br>
<!-- BUTTONS -->
<div class="btn-group" role="group" aria-label="Third group">
    <button class="registerButton btn btn-primary" type="button">Write</button>
</div>
<div class="btn-group" role="group" aria-label="Third group">
	<button class="listButton btn btn-secondary" type="button">Back To List</button>
</div>
</div>


<div class="modal" id="registerModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>게시글이 등록되었습니다.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary closeButton" data-dismiss="modal" >Close</button>
            </div>
        </div>
    </div>
</div>

<form class='actionForm' action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
    <input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
    <input type="hidden" name="type" value="${pageDTO.type}">
    <input type="hidden" name="keyword" value="${pageDTO.keyword}">
</form>

<script>
	window.addEventListener('DOMContentLoaded', (e)=>{

	var actionForm = document.querySelector(".actionForm");
	var uploadList = document.querySelector(".uploadList");
	var uploadInput = document.querySelector("input[name='uploadInput']");
	var formData = new FormData();
	function backToList(){
		actionForm.submit();
	}


	//==========================
	// REGISTER AJAX
	//==========================
	function registerAjax(data){
		return fetch("/board/register", {
			method:'post',
			headers:{'Content-Type':'application/json'},
			body:JSON.stringify(data)				
		})
		.then(res=>{			
			if(!res.ok){
				throw new Error(res);
			}
			console.log("=========== fetch done ==========")
			return res.json();
		})
		.catch(res=>{
			console.log("============ catch ===============");
			console.log(res);
			return res;
		})
	}
		
	//==========================
	// REGISTER BUTTON
	//==========================
	document.querySelector(".registerButton").addEventListener("click", function(e){
		e.preventDefault();
		// ajax
		// 1. DOM 데이터 불러오기
		var titleValue = document.querySelector("input[name='boardTitle']").value;
		// var contentValue = document.querySelector("input[name='boardContent']").value;
		var contentValue = document.querySelector(".textArea").value;
		var writerValue = document.querySelector("input[name='boardWriter']").value;
		console.log("contentValue : " + contentValue);
		
		// 2. 보낼 데이터
		var fileArr=[
			{fileName:'aaa.jpg', uuid:'1111', uploadPath:'2021/03/18'},	
			{fileName:'bbb.jpg', uuid:'2222', uploadPath:'2021/03/18'}
		];
		
		var data={title:titleValue, content:contentValue, writer:writerValue, fileList:fileArr}
		
		// 3. AJAX 보내기
		var regResult = registerAjax(data);
		regResult.then(res=>{
			var regModal = $("#registerModal");
			
			// modal에 띄울 메시지			
			if(res.result == "success"){
				regModal.find(".modal-body").html(res.bno+ "번 게시글이 등록되었습니다.");
				// Close 눌러서 list로 돌아가기
				document.querySelector(".closeButton").setAttribute("onclick", "backToList()");
			} else{	
				regModal.find(".modal-body").html(res.message);
				// 그대로 머물기
			}

			regModal.modal('show')
		})	
	})
	
	//==========================
	// LIST BUTTON
	//==========================
	document.querySelector(".listButton").addEventListener("click", function(e){
		e.preventDefault();
		backToList();
	})
	
	
	//==========================
	// FILE UPLOAD BUTTON
	//==========================
	document.querySelector(".uploadButton").addEventListener("click", function(e){
		// 1. input에 있는 file들 불러오기
		var input = document.querySelector("input[name='uploadInput']");
		var files = input.files;
		// 2. formData에 넣기
		
		
		
		
		// 3. AJAX로 보내기
		fetch("http://localhost:8080/board/upload", {
			method: 'post',
			body: formData
		}).then(res=>res.json())
		.then(jsonMap=>{
			if("fail" == jsonMap.message){
				
			} else{
				// 성공한 경우
				var list = jsonMap.list;
				var innerStr = "";
				for(var i = 0; i < list.length; ++i){
					innerStr += "<button type='button' class='list-group-item list-group-item-action'>"+ list[i].fileName + "</button>";
				}
				
				uploadList.innerHTML += innerStr;
			}
		})
		
		
	})
	
	//========================================
	// UPLOAD INPUT ONCHANGE
	//========================================
	document.querySelector(".uploadDiv").addEventListener("change", function(e){
		console.log("INPUT CHANGE");
		console.log(this);
		var target = e.target;
		// uploadDiv
		console.log(target);
		// input[name='uploadInput'
		
		// 성공한 경우
		var list = target.files;
		console.log(list);
		var innerStr = "";

		for(var i = 0; i < list.length; ++i){
			innerStr += "<button type='button' class='list-group-item list-group-item-action'>"+ list[i].name + "</button>";
			formData.append("files", list[i]);
		}
		
		uploadList.innerHTML += innerStr;
		e.target = uploadInput.cloneNode(true);
		console.log(e.target);
	})
	
	// END OF WINDOW ONLOADED
	})

</script>

<%@include file="../includes/footer.jsp" %>


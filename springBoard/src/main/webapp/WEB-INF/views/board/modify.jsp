<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<div class="container">

<h1>
	 Editing... #${board.bno} 
</h1>

<!-- 글쓴이 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">ID</span>
  </div>
  <input name="boardWriter" type="text" class="form-control" placeholder="${board.writer}" aria-label="writer" 
  aria-describedby="basic-addon1" readonly value="${board.writer}">
</div>

<!-- 등록일 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Register date</span>
  </div>
  <input type="text" class="form-control" placeholder="${board.regdate}" aria-label="regdate" aria-describedby="basic-addon1" readonly >
</div>

<!-- 마지막 수정일 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Last Update</span>
  </div>
  <input type="text" class="form-control" placeholder="${board.updatedate}" aria-label="updatedate" aria-describedby="basic-addon1" readonly >
</div>

<!-- 제목 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Title</span>
  </div>
  <input name="boardTitle" type="text" class="form-control" placeholder="${board.title}" 
  aria-label="title" aria-describedby="basic-addon1" value="${board.title}">
  
</div>

<!-- 내용 -->
<div class="form-group">
    <label for="exampleFormControlTextarea1"></label>
    <textarea class="form-control textArea" id="exampleFormControlTextarea1" rows="5" style="resize: none">${board.content}</textarea>
  </div>


<!-- 수정하기 버튼 -->
<div class="btn-group" role="group" aria-label="Third group">
    <button class="modifyButton btn btn-success" type="button">Modify</button>
</div>
<div class="btn-group" role="group" aria-label="Third group">
	<button class="deleteButton btn btn-danger" type="button">Delete</button>
</div>
<div class="btn-group" role="group" aria-label="Third group">
	<button class="toListButton btn btn-secondary" type="button">Go Back</button>
</div>

<!-- CONTAINER OVER -->
<!-- CONTAINER OVER -->
<!-- CONTAINER OVER -->
</div>


<!-- MODAL -->
<!-- MODAL -->
<!-- MODAL -->
<div class="modal" id="modifyModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Hello world!</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary closeButton" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- ACTION FORM -->
<!-- ACTION FORM -->
<!-- ACTION FORM -->
<form class='actionForm' action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
    <input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
    <input type="hidden" name="type" value="${pageDTO.type}">
    <input type="hidden" name="keyword" value="${pageDTO.keyword}">
    <input type="hidden" name="bno" value="${board.bno}">
</form>



<script>
	var actionForm = document.querySelector(".actionForm");
	function submit(){
	    // 윈도우창의 주소를 바꿔준다.
		actionForm.submit();
	}
	
	//=================================//
	// 수정 아작스
	//=================================//
	function modifyAjax(data){
		console.log("============ MODIFY AJAX ON ============")
		return fetch("/board/modify", {
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
				console.log("============ catch : " + res + " ===============");
				return res;
			})
	}
	
	//=================================//
	// 수정하기 버튼
	//=================================//
	document.querySelector(".modifyButton").addEventListener("click", 
		function(e){
			e.preventDefault();
			
			var bnoInput = actionForm.querySelector("input[name='bno']");
			var titleInput = document.querySelector("input[name='boardTitle']");
			var contentInput = document.querySelector(".textArea");
			var data = {bno: bnoInput.value,
						title: titleInput.value,
						content: contentInput.value}
			console.log(data);
				
			// ajax로 결과 받아오기
			var modifyResult = modifyAjax(data);
			// 결과 받아와서 처리하기
			modifyResult.then(json =>{
				var modModal = $("#modifyModal");
				
				// success라면
				if("success" == json.result){
					modModal.find(".modal-body").html("수정이 완료되었습니다.");		
					actionForm.setAttribute("action", "/board/view")
					modModal.find(".closeButton").attr("onclick", "submit()");
				} else{
					// 실패라면
					modModal.find(".modal-body").html(json.message);	
				}
		
				// modal창 띄우기
				modModal.modal('show');
			})		
	}, false)
	
	//=================================//
	// 삭제 아작스
	//=================================//
	function deleteAjax(data){
		console.log("============ DELETE AJAX ON ============")
		return fetch("/board/delete", {
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
				console.log("============ catch : " + res + " ===============");
				return res;
			})
	}
	
	// 삭제하기 버튼
	document.querySelector(".deleteButton").addEventListener("click", function(e){
		e.preventDefault();
		
		var bnoInput = actionForm.querySelector("input[name='bno']");
		
		var data = {bno: bnoInput.value}
			
		// ajax로 결과 받아오기
		var deleteResult = deleteAjax(data);
		// 결과 받아와서 처리하기
		deleteResult.then(json =>{
			var modModal = $("#modifyModal");
			console.log(modModal);
			
			// success라면
			if("success" == json.result){
				modModal.find(".modal-body").html(data.bno + "번 게시글이 삭제되었습니다.");
				// close 누르면 list 창으로 돌아가기
				modModal.find(".closeButton").attr("onclick", "submit()");
			}
	
			// modal창 띄우기
			modModal.modal('show');
		})		
	}, false)
	
	
	//=================================//
	// 목록으로 가기 버튼
	//=================================//
	document.querySelector(".toListButton").addEventListener("click", function(e){
		e.preventDefault();
		submit();
	}, false)
	
	
	
</script>




<%@include file="../includes/footer.jsp" %>


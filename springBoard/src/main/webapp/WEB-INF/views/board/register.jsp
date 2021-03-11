<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>
	게시글을 등록하세요!  
</h1>


<!-- 제목 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">제목</span>
  </div>
  <input name="boardTitle" type="text" class="form-control"
  aria-label="title" aria-describedby="basic-addon1" value="제목">
  
</div>


<!-- 내용 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">내용</span>
  </div>
  <input name="boardContent" type="text" class="form-control" placeholder="${board.content}" 
  aria-label="content" aria-describedby="basic-addon1" value="내용">
</div>

<!-- 글쓴이 -->
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">ID</span>
  </div>
  <input name="boardWriter" type="text" class="form-control" placeholder="${board.writer}" 
  aria-label="writer" aria-describedby="basic-addon1" readonly value="TESTWRITER">
</div>

<button class="registerButton">등록하기</button>
<button class="listButton">목록으로</button>



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
                <button class="closeButton" type="button" class="btn btn-secondary" data-dismiss="modal" >Close</button>
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
	var actionForm = document.querySelector(".actionForm");

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
		var titleValue = document.querySelector("input[name='boardTitle']").value;
		var contentValue = document.querySelector("input[name='boardContent']").value;
		var writerValue = document.querySelector("input[name='boardWriter']").value;

		var data={title:titleValue, content:contentValue, writer:writerValue}
		
		var regResult = registerAjax(data);
		regResult.then(res=>{
			var regModal = $("#registerModal");
			
			// modal에 띄울 메시지			
			if(res.result == "success"){
				regModal.find(".modal-body").html("게시글이 등록되었습니다.");
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

</script>

<%@include file="../includes/footer.jsp" %>


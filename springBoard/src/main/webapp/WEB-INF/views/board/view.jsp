<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
<button class="btn btn-default btn-lg active">
	#${board.bno} 게시글!
</button>


<div class="input-group">
  <div class="input-group-prepend">
 <span class="input-group-text">#${board.bno}</span>
 </div>
  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" value="${board.title}" disabled
   	style="background: #ffffff;">
  <div class="input-group-prepend">
    <span class="input-group-text">Writer : ${board.writer}</span>
    <span class="input-group-text">Last update : ${board.updatedate}</span>
  </div>
</div>

<div class="form-group">
    <textarea class="form-control textArea" id="exampleFormControlTextarea1" rows="10" 
    style="resize: none; background: #ffffff; border: none;" readonly style="">${board.content}</textarea>
</div>


<div class="btn-group editButton" role="group" aria-label="Third group">
    <button class="editButton btn btn-primary" type="button">Edit</button>
</div>
<div class="btn-group" role="group" aria-label="Third group">
	<button class="toListButton btn btn-secondary" type="button">Go back</button>
</div>

</div>

<!-- ACTION FORM -->
<!-- ACTION FORM -->
<!-- ACTION FORM -->
<form class='actionForm' action="/board/modify" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
    <input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
    <input type="hidden" name="type" value="${pageDTO.type}">
    <input type="hidden" name="keyword" value="${pageDTO.keyword}">
    <input type="hidden" name="bno" value="${board.bno}">
</form>

<script>
	var actionForm = document.querySelector(".actionForm");
	
	// 목록으로 가기 버튼
	document.querySelector(".toListButton").addEventListener("click", function(e){
		e.preventDefault();
		actionForm.setAttribute("action", "/board/list")
		actionForm.submit();
	}, false)
	
	// 게시글 수정 버튼
	document.querySelector(".editButton").addEventListener("click", function(e){
		e.preventDefault();
		actionForm.submit();
	}, false)

</script>


<%@include file="../includes/footer.jsp" %>


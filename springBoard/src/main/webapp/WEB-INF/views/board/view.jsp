<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>
	Board view : ${board.bno}  
</h1>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">CONTENT</th>
      <th scope="col">WRITER</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE</th>
    </tr>
  </thead>
  <tbody>
  
    <tr>
      <th scope="row">${board.bno}</th>
      <td>${board.title}</td>
      <td>${board.content}</td>
      <td>${board.writer}</td>
      <td>${board.regdate}</td>
      <td>${board.updatedate}</td>
    </tr>
    
  </tbody>
</table>

<button class="editButton">게시글 편집</button>
<button class="toListButton">목록으로</button>

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


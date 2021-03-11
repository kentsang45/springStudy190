<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1> Read </h1>

<button class="listButton">목록으로</button>
<button class="modButton">글 수정하기</button>

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

<form class='actionForm' action="/board/modify" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
    <input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
    <input type="hidden" name="type" value="${pageDTO.type}">
    <input type="hidden" name="keyword" value="${pageDTO.keyword}">
    <input type="hidden" name="bno" value="${board.bno}">
</form>

<script>
	var actionForm = document.querySelector(".actionForm");

 	// 이부분을 함수로 만들어서 util로 빼기...
    document.querySelector(".listButton").addEventListener("click",
    		e=>{
    			console.log("List BUTTON ON");
    			e.preventDefault();
    			actionForm.setAttribute("action", "/board/list");
    			actionForm.submit();		    		    
    		})
    		
     document.querySelector(".modButton").addEventListener("click",
    		e=>{
    			console.log("mod BUTTON ON");
    			e.preventDefault();
    
    			actionForm.submit();	 		    		    
    		})		
    
</script>




<%@include file="../includes/footer.jsp" %>

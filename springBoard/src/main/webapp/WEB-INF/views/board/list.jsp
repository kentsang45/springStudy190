<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>BOARD LIST</h1>
<button class="testButton">TEST</button>

<!-- LIST -->
<!-- LIST -->
<!-- LIST -->
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">WRITER</th>
      <th scope="col">UPDATE_DATE</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach items="${list}" var="board">
    	<tr>
      		<td>${board.bno}</td>
      		<td>${board.title}</td>
      		<td>${board.writer}</td>
      		<td>${board.updatedate}</td>
    	</tr>
    </c:forEach>
    
  </tbody>
</table>



<!-- PAGENATION -->
<!-- PAGENATION -->
<!-- PAGENATION -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
  <c:if test="${pageMaker.prev}">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.start-1}" tabindex="-1">Previous</a>
    </li>
  </c:if>
    
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
    	<li class="page-item ${pageMaker.pageDTO.page == num ? 'active' : '' }"><a class="page-link" href="${num}">${num}</a></li>
	</c:forEach>

    <c:if test="${pageMaker.next}">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.end+1}">Next</a>
    </li>
     </c:if>
  </ul>
</nav>

<!-- ACTION FORM -->
<!-- ACTION FORM -->
<!-- ACTION FORM -->
<form class="actionForm" action="/board/list" method="get">
	<input type="hidden" name="page" value="${pageDTO.page}">
	<input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
	<input type="hidden" name="type" value="${pageDTO.type}">
	<input type="hidden" name="keyword" value="${pageDTO.keyword}">
</form>




<!-- UTIL -->
<!-- UTIL -->
<!-- UTIL -->
    
<script>

	var actionForm = document.querySelector(".actionForm");
	
	// pagination
	document.querySelector(".pagination").addEventListener("click", function(e){
		e.preventDefault()
		var target = e.target;
		// 페이지 버튼을 누르면 해당 페이지 숫자를 가져온다.
		var pageNum = target.getAttribute("href");
		if(null==pageNum){pageNum = 0;}
		
		// 가져온 숫자를 actionForm에 넣어준다
		actionForm.querySelector("input[name='page']").value = pageNum;
		actionForm.submit();		
	}, false)
</script>



<%@include file="../includes/footer.jsp" %>


<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>BOARD LIST</h1>

<div class="searchDiv">
	<select class="searchType" name="searchType">
		<option>없음</option>
		<option value='t' ${pageDTO.type=='t' ? "selected" : ""}>제목</option>
		<option value='c' ${pageDTO.type=='c' ? "selected" : ""}>내용</option>
		<option value='w' ${pageDTO.type=='w' ? "selected" : ""}>작성자</option>
		<option value='tc' ${pageDTO.type=='tc' ? "selected" : ""}>제목 + 내용</option>
		<option value='tcw' ${pageDTO.type=='tcw' ? "selected" : ""}>제목 + 내용 + 작성자</option>
	</select>
	<input name="searchKeyword" type='text' value="<c:out value='${pageDTO.keyword}'/>">
	<button class="searchButton">Search</button>	
</div>


<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">WRITER</th>
      <th scope="col">UPDATE</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${list}" var="board">
    <tr>
      <th scope="row">${board.bno}</th>
      <td> <a class="boardEle" href="<c:out value="${board.bno}"/>">${board.title}</a></td>
      <td>${board.writer}</td>
      <td>${board.updatedate}</td>
    </tr>
      </c:forEach>
  </tbody>
</table>



<ul class="pagination justify-content-center">
    <!-- previous button -->
    <li class="page-item ${pageMaker.prev ? '' : 'disabled'}">
        <a class="page-link" href="${(pageMaker.start - 1)}" tabindex="-1" >Previous</a>
    </li>


    <!-- page button -->
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
    <li class="page-item ${num == pageMaker.pageDTO.page? 'active' : ''}"><a class="page-link" href="${num}">${num}</a></li>
    </c:forEach>

    <!-- next button -->
    <c:if test="${pageMaker.next}">
    <li class="page-item">
        <a class="page-link" href="${pageMaker.end + 1}">Next</a>
    </li>
    </c:if>
</ul>

<form class="actionForm" action="/board/list" method="get">
    <input type="hidden" name="page" value="${pageDTO.page}">
    <input type="hidden" name="perSheet" value="${pageDTO.perSheet}">
    <input type="hidden" name="type" value="${pageDTO.type}">
    <input type="hidden" name="keyword" value="${pageDTO.keyword}">
</form>

<script>
    var actionForm = document.querySelector(".actionForm");

    // page 누르면 발생하는 이벤트
    document.querySelector(".pagination").addEventListener("click",
        e=>{
            e.preventDefault();
            // 클릭한 대상
            var target = e.target;
            var pageNum = target.getAttribute("href");

            if(pageNum == null){
            	pageNum = 1;
            }
            
            // actionForm 밑에 이름이 page인 input
            actionForm.querySelector("input[name='page']").value = pageNum;
            
            actionForm.submit();
        }
    , false);
    
 	// 게시글 누르면 발생하는 이벤트
    document.querySelectorAll('.boardEle').forEach(
        a=>{
            a.addEventListener("click", function(e){
                e.preventDefault();
                var bno = e.target.getAttribute("href");
                actionForm.setAttribute("action", "/board/read");
                actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
                actionForm.submit();
            }, false)
        }
    )
    
    // Search버튼 누르면 발생하는 이벤트
    document.querySelector(".searchButton").addEventListener("click",
    		function(e){
    	
    			e.preventDefault();
    			
    			var searchType = document.querySelector(".searchType"); 
    			var index = searchType.selectedIndex;
    			var type = searchType[index].value;
    			
    			actionForm.querySelector("input[name='type']").value = type;
    			actionForm.querySelector("input[name='keyword']").value 
    				= document.querySelector("input[name='searchKeyword']").value;
    			
    			actionForm.submit();
    			
    			// callback end
    		} ,false)
    
</script>

<%@include file="../includes/footer.jsp" %>

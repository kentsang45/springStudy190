<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
<div class="listNav">
<div class="listNavEle">
	<button class="registerButton btn btn-outline-dark btn" type="button">Write</button>
</div>
<div class="btn-toolbar listNavEle" role="toolbar" aria-label="Toolbar with button groups">
	<div class="input-group mb-3">
  		<select class="custom-select searchType" name="searchType">
    	<option>None</option>
		<option value='t' ${pageDTO.type=='t' ? "selected" : ""}>Title</option>
		<option value='c' ${pageDTO.type=='c' ? "selected" : ""}>Contents</option>
		<option value='w' ${pageDTO.type=='w' ? "selected" : ""}>ID</option>
		<option value='tc' ${pageDTO.type=='tc' ? "selected" : ""}>Title + Contents</option>
		<option value='tcw' ${pageDTO.type=='tcw' ? "selected" : ""}>Title + Contents + ID</option>
  		</select>
   		<input type="text" name="searchKeyword" aria-label="Text input with segmented dropdown button"
   			value="<c:out value='${pageDTO.keyword}'/>">
   		<div class="input-group-append">
   			<button class="btn btn-outline-secondary searchButton" type="button">Search</button>
   		</div>
   </div>
</div>
</div>
<!-- LIST -->
<!-- LIST -->
<!-- LIST -->
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">No</th>
      <th scope="col">Title</th>
      <th scope="col">ID</th>
      <th scope="col">Lastest update</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach items="${list}" var="board">
    	<tr>
      		<td>${board.bno}</td>
      		<td><a class="boardView" href="<c:out value="${board.bno}"/>">${board.title}</a></td>
      		<td>${board.writer}</td>
      		<td class="dateArea" data-toggle="popover" data-content="${board.updatedateStr}" >
      			${board.updatedateWord}</td>
    	</tr>
    </c:forEach>
    
  </tbody>
</table>



<!-- PAGINATION -->
<!-- PAGINATION -->
<!-- PAGINATION -->
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
</div>
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
	//======================
	// pagination
	//======================
	document.querySelector(".pagination").addEventListener("click", function(e){
		e.preventDefault()
		var target = e.target;
		
		// 페이지 버튼을 누르면 해당 페이지 숫자를 가져온다.
		var pageNum = target.getAttribute("href");
		if(null==pageNum){pageNum = 0; return;}
		
		// 가져온 숫자를 actionForm에 넣어준다
		actionForm.querySelector("input[name='page']").value = pageNum;
		actionForm.submit();		
	}, false)
	
	//======================
	// board view
	//======================
	document.querySelectorAll(".boardView").forEach(
		v=>{v.addEventListener("click", function(e){
			e.preventDefault();
			// bno를 가져온다.
			var bno = e.target.getAttribute("href");
	    	actionForm.setAttribute("action", "/board/view")
	    	actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
			actionForm.submit();
			}, false)
		}
	)
	
	//======================
	// DATE AREA Popup
	//======================
	document.querySelectorAll(".dateArea").forEach(
		v=>{v.addEventListener("click", function(e){
			// e.preventDefault();
			// date를 가져온다.
			// var date = e.target.getAttribute("data-date");
	    	// console.log("DATE : " + date);
	    		$this = $(this);
	    		$this.popover('show')
	    		
	    		setTimeout(function(){
	    			$this.popover('hide')
	    			console.log("setTimeOut");
	    		}, 1500)
	    		
			}, false)
		}
	)
		
		
	//======================
	// REGISTER BUTTON
	//======================
	document.querySelector(".registerButton").addEventListener("click", function(e){
		e.preventDefault();
		console.log("register Button on");
		actionForm.setAttribute("action", "/board/register");
		actionForm.submit();
	}, false)
	
	//======================
	// SEARCH BUTTON
	//======================
	document.querySelector(".searchButton").addEventListener("click", function(e){
		e.preventDefault();
		// searchType의 select 불러오기
		var searchType = document.querySelector(".searchType");
		var index = searchType.selectedIndex;
		// 현재 option의 값 가져오기
		var selectedValue = searchType[index].value;
		
		// option값을 pateDTO type에 넣기
		// 검생창 input에 있던 값을 pageDTO keyword에 넣기
		actionForm.querySelector("input[name='type']").value = selectedValue;
		actionForm.querySelector("input[name='keyword']").value 
			= document.querySelector("input[name='searchKeyword']").value;
		
		actionForm.submit();
		
	}, false)
</script>



<%@include file="../includes/footer.jsp" %>


<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
	.boarder{
		border-bottom: 1em;
		line-height: 1.5;
	}
</style>

<div class="container">
<button class="btn btn-default btn-lg active">
	${board.bno} 게시글!
</button>



<div class="input-group boarder">
  <div class="input-group-prepend">
 <span class="input-group-text">${board.bno}</span>
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

<!-- REPLY -->
<table class="table replyTable">
 
</table>

<!-- PAGINATION -->
<nav aria-label='Page navigation example' class="replyPagination">
</nav>


<!-- BUTTONS -->
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
	
	//======================
	// 목록으로 가기 버튼
	//======================
	document.querySelector(".toListButton").addEventListener("click", function(e){
		e.preventDefault();
		actionForm.setAttribute("action", "/board/list")
		actionForm.submit();
	}, false)
	//======================
	// 게시글 수정 버튼
	//======================
	document.querySelector(".editButton").addEventListener("click", function(e){
		e.preventDefault();
		actionForm.submit();
	}, false)

	
	//======================
	// REPLY AJAX
	//======================
	function getReplyList(data){
		return fetch("http://localhost:8080/replies/pages/"+data.page+"/"+data.bno ,
	            { method: "get" }
	        ).then(res=>{				
				if(!res.ok){ throw new Error(res); }
				console.log("=========== fetch done ==========")
				return res.json();
			})
			.catch(res=>{
				console.log("============ catch ===============");
				console.log(res);
				return res;
			})
	}	
		
	//======================
	// REPLY LIST
	//======================
	function makeList(list, pageMaker){
		console.log("===========PM============");
		console.log(pageMaker);
		// start = 1
		// end = 5
		console.log("===========PM============");
		var table = document.querySelector(".replyTable");
		
		var tableStr = "<thead class='thead-dark'>"+
	    "<tr><th scope='col'>No</th><th scope='col'>Reply</th>"+
	    "<th scope='col'>ID</th><th scope='col'>Lastest update</th>"+
	    "</tr></thead><tbody>";
	  
	  for(var i = 0; i < list.length; ++i){
		  var reply = list[i];
		  tableStr += "<tr><td>"+reply.rno+"</td>"+
	      		"<td><a class='boardView'>"+reply.reply+"</a></td>"+
	      		"<td>"+reply.replyer+"</td>"+
	      		"<td class='dateArea' data-toggle='popover'>"+reply.updateDateStr+"</td></tr>";
	  }
	  
	  // PAGINATION
	  var pageNav = document.querySelector(".replyPagination");
	  var length = pageMaker.start - pageMaker.end;
	  var pageStr = "<ul class='pagination justify-content-center'>"
	    
	    if(pageMaker.prev){
	    	  pageStr += "<li class='page-item'>"+
		        "<a class='page-link=' href='"+(pageMaker.start-1)+"' tabindex='-1'>Previous</a></li>";	   
	    }
	    
	    
	  for(var i = pageMaker.start; i < pageMaker.end+1; ++i){
		  pageStr += "<li class='page-item "+ (pageMaker.pageDTO.page == i ? 'active' : '' ) +"'><a class='page-link' href='"+i+"'>"+i+"</a></li>"	  		  	
	  }
	  
	  if(pageMaker.next){
    	  pageStr += "<li class='page-item'>"+
	        "<a class='page-link=' href='"+(pageMaker.end+1)+"' tabindex='-1'>Next</a></li>";	   
    }
	  
	  pageStr += "</ul>";
  
	  tableStr+="</tbody>";	  
	  table.innerHTML = tableStr;
	  pageNav.innerHTML = pageStr;
	}
	
	// content loaded
	window.addEventListener('DOMContentLoaded', (e)=>{
		// list 불러오기
	    var bnoVal = document.querySelector("input[name='bno']").value;
		var data = {page:1, bno:bnoVal};
		var replyResult = getReplyList(data);
		
		replyResult.then(res=>{
			console.log(res);
			var list = res.list;
			var pm = res.pageMaker;
			// size가 0인 것도 확인
			if(0 != list.length) {
				makeList(list, pm);	
			}
		})
		
		// pagenation click
	document.querySelector(".replyPagination").addEventListener("click", function(e){
		e.preventDefault()
		var target = e.target;
		
		// 페이지 버튼을 누르면 해당 페이지 숫자를 가져온다.
		var pageNum = target.getAttribute("href");
		
		if(null==pageNum){pageNum = 0; return;}
		
		// list 다시 불러오기1
		var bnoVal= document.querySelector("input[name='bno']").value;
		var data = {page:pageNum, bno:bnoVal};
		var replyResult = getReplyList(data);
		
		replyResult.then(res=>{
			console.log(res);
			var list = res.list;
			var pm = res.pageMaker;
			// size가 0인 것도 확인
			if(0 != list.length) {
				makeList(list, pm);	
			}
		})
	}, false)
	
	// onloaded over
	})	
	
	
	
	
	
</script>


<%@include file="../includes/footer.jsp" %>


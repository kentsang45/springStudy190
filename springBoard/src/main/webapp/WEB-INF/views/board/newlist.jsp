<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body {
            margin: 0;
            padding: 0;
        }
    </style>
</head>


<body>

<style>

    .container{
        background-color: gray;
        width:100%;
        height:100%;
        display:flex;
        justify-content: center;
        flex-direction: column;
    }

    .topNav{
        background-color: black;

        width:100%;
        height:10vh;

        margin-left: 0;
        margin-top: 0;
        margin-bottom:0;
        margin-right: 0;
    }
    
     .footNav{
        background-color: black;

        width:100%;
        height:30vh;

        margin-left: 0;
        margin-top: 0;
        margin-bottom:0;
        margin-right: 0;
    }
    

    .bodyNav{
        background-color: gray;
        width:100%;
        min-height:90vh;
        display: flex;
        flex-direction: row;
        justify-content: center;
    }

    .mainBody{
        width:60%;
        min-height:90vh;
        display: flex;
        flex-direction: column;

    }

    .image{
        margin-top:1em;
        background-color: white;
        width:100%;
        height:40vh;
    }

    .boards{
        width:100%;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .board{
        margin-top:1em;
        margin-bottom:1em;
        background-color: white;
        width:33%;
        height:40vh;
    }

</style>



<div class="container">
    <div class="topNav"></div>
    <div class="bodyNav">
        <div class="mainBody">
            <div class="image"></div>
            <div class="boards" data-page="1" data-type="" data-keyword="">
            	<c:forEach items="${list}" var="board">	
    	 			<div class="board">${board.bno} , ${board.title}</div>
    			</c:forEach>
            </div>
        </div>
    </div>
</div>



<div class="footNav">

</div>



<script>
	var boards = document.querySelector(".boards");

	//===============================
	// AJAX로 List 로딩
	//===============================
	function getListAjax(pageData){
		return fetch("/board/getMoreList", {
			method:'post',
			headers:{'Content-Type':'application/json'},
			body:JSON.stringify(pageData)				
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
	
	// boards 페이지 증가
	function increasePage(){
		var cur = boards.getAttribute("data-page");
		boards.setAttribute("data-page", parseInt(cur) + 1);
	}
	
	// boards에 list 추가하기
	function setList(list){
		console.log(list);
		list.forEach(b=>{
		 	boards.innerHTML += "<div class='board'>"+b.bno+" , "+b.title+"</div>"
		})
		
	}
	
	//===============================
	// 스크롤이 가장 아래에 있을 때
	//===============================
	window.onscroll = function() {
    	if ((window.innerHeight + window.pageYOffset) >= document.body.offsetHeight) {
    		var data= { page: boards.getAttribute("data-page"), type: boards.getAttribute("data-type"), keyword: boards.getAttribute("data-keyword")}
    		
    		console.log("page bottom");
    		console.log(data);
    		
    		var result = getListAjax(data);
    		
    		result.then(res=>{
    			increasePage();
    			console.log(res);
    			setList(res);
    		})
    	}
	};
</script>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>

<form action="/todo/add" method='post'>
	
	<div>
		<input type='text' name='title' value='${todoDTO.title}'>
			
	</div>

	<div>
		<button class="button">SAVE</button>	
	</div>
	
</form>


<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous">
</script>

<script>

	function showResult(){
		alert("SHOW RESULT");
		self.location="/todo/list";
	}

	
	
	
	$(document).ready(function(){
		
		// save 버튼
		$(".button").on("click", function(e){
			// 1. 이벤트의 기본동작을 막아라
			e.preventDefault();
			
			// form 섭밋
			// $("form").submit();
			
			// 2. js객체 만들어서 전송!
			var data = {title:$("input[name='title']").val(), complete:false };
			console.log(data);
		
			// 3. AJAX
			// 인자1) url, 보낼 데이터, callback함수
			// 이것을 vanilla로도 만들어보자.
			$.post('/todo/addTwo', data, function(result){
				console.log(result);
			})
		})
	})


</script>


</body>
</html>
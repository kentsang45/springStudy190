<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous">
</script>
</head>

<body>

<form action="/todo/add" method='post'>
	<div>
		<input type='text' name='input' value='${todoDTO.title}' >
		<button class='button'> SAVE </button>
		<ul class='ulAnswer'> 
		</ul>
	</div>
</form>



<script>
/*
	$(document).ready(function(){
		$('.button').on('click', function(e){
			e.preventDefault();  //기본동작이 뭔지 확인. 
			 
			//키:값, 키:값                                         
			{title:$("input[name='input']").val(), complete:false };
			console.log(data);
			
			
		$.post('/todo/addTwo', data, function(result){
			console.log(result);
			})
		})
	});
*/
</script>


</body>
</html>
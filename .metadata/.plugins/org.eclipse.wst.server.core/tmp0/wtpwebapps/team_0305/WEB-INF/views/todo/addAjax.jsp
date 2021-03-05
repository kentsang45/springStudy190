<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   

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

	<div>
		<input type='text' name='title' value='${todoDTO.title}' >
		
		<strong class='errortext'></strong>
	</div>

	<div>
		<button class = "button">ADD</button>
	</div>


<script>

	$(document).ready(function(){
		$('.button').on('click', function(e){
			e.preventDefault();  //기본동작이 뭔지 확인. 
			 
			//키:값, 키:값                                         
			var data = {title:$("input[name='title']").val(), complete:false };
			// console.log(data);
			
			
		$.post('/todo/addAjax', data, function(result){
				// console.log("AJAX CALLBACK : ", result[0].defaultMessage);
				$(".errortext").html(result[0].defaultMessage);
			})
		})
	});

</script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/todo/addTwo" method="post">
		<!-- <input type='hidden' name='complete' value='true'> -->
		<div>
			<input type='text' name='title'>
		</div>
		<div>
			<button class='btn'>SAVE</button>
		</div>
	</form>
	
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous">
</script>
<script>
	
	function showResult() {
		alert("showResult")
		self.location ="/todo/list";
	}
	
	$(document).ready(function() {

	})
</script>
</body>
</html>
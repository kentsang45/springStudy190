<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>
	Let's add My Todo!
</h1>

<input name="addInput">
<button class="addButton">ADD</button>

</body>

<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous">
</script>

<script>
	$(document).ready(function(){
		var addInput = $("input[name='title']");
		var addButton = $(".addButton");
	
		addButton.on("click", function(e){
			// 1. 이벤트의 기본동작을 막아라
			e.preventDefault();
			
			
		}
		// ready ends
	})
	
</script>

</html>

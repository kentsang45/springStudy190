<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
	<h2>LIST</h2>
	<ul>
	<c:forEach items="${list}" var="todoDTO">
		<li>${todoDTO}</li>	
	</c:forEach>
	</ul>
</div>


<script>


</script>


</body>
</html>
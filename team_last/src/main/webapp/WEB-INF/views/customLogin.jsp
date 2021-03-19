<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method='post' action='/login'> 
	<input type='text' name='username' value='admin'> 
	<input type='password' name='password' value='admin'> 
	<input type='submit'> 	
	<input type='hidden' name="${_csrf.parameterName }" value="${_csrf.token}"> 
</form>

</body>
</html>
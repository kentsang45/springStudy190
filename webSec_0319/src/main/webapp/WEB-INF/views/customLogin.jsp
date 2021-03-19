<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Please Login!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="/login" method='post'>
	<label>id</label>
	<input type='text' name='username'>
	<label>pw</label>
	<input type='text' name='password'>
	
	<input type='text' name='_csrf' value='${_csrf.token}'>
	
	<button>sign in</button>
</form>

</body>
</html>

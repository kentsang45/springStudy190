<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello, do you want to log out?
</h1>


<form action="/customLogout" method='post'>

	
	<input type='hidden' name='_csrf' value='${_csrf.token}'>
	
	<button>yes</button>
</form>

</body>
</html>

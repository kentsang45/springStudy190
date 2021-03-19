<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form name="server">
  <input type='file' id="imgInp" />
  <img id="blah" src="#" alt="your image" />
</form>



<script>
	function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      document.querySelector('#blah').setAttribute('src', e.target.result);
	    }
	    
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
	}

	document.querySelector("#imgInp").("change", (function(e) {
	  readURL(this);
	});
</script>

</body>
</html>

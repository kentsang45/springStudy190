<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>input</title>
</head>
<body>
<h1>
	Hello Input!  
</h1>

<input type='file' name='uploadFile' multiple='multiple'>

<button class='uploadButton'>Upload</button>

<!-- 업로드 결과 출력 -->
<ul class="uploadResult"></ul>






<script>
	var uploadUL = document.querySelector(".uploadResult");

	// UPLOAD BUTTON
	document.querySelector(".uploadButton").addEventListener("click", function(e){
		// actionForm을 원래 써서 데이터를 저장하고 submit했다.
		// new FormData()를 쓰면 이게 그냥 바로 js에서 가능하다.
		var formData = new FormData();
		var input = document.querySelector("input[name='uploadFile']");
		var files = input.files; // vanilla에서 file 가져오는 법

		console.dir(input);
		
		for(var i = 0; i < files.length; ++i){
			// controller의 인자 이름과 맞춰라
			formData.append("files", files[i]);			
		}

		// 보내기 어디로?
		// Controller로 간다. upload post 를 찾아간다.
		fetch("http://localhost:8080/upload", {
			method: 'post',
			body: formData			
		}).then(res=>res.json())   //responseEntity  body 자체로 돌아온다
		  .then(jsonObj=>{         //jsonObj로 결과값을 다시 인자로 넣어준다
			// AttachFileDTO List를 ul에 담기
			var innerStr = "";
			for(var i = 0; i < jsonObj.length; ++i){
				fileObj = jsonObj[i];
				innerStr += "<li id='li_"+ fileObj.uuid +"' data-obj='"+JSON.stringify(fileObj)+"'><img src='/view?file=" + fileObj.thumbUrl + "'>"+
						"<button>Delete</button></li>";
			}
			
			uploadUL.innerHTML += innerStr;
			
		})
		
	}, false);
	
	function removeFile(jsonObj){
		console.log(jsonObj);
		console.log("REMOVE FILE");
		document.querySelector("#li_" + jsonObj.uuid).remove();
	}
	
	// <ul class="uploadResult">
	// <li><button></li>
	// </ul>
	document.querySelector(".uploadResult").addEventListener("click", function(e){	
		var target = e.target;
		console.log(target.parentNode);
		
		fetch("http://localhost:8080/removeFile", {
			method : 'delete',
			headers : {'Content-Type' : 'application/json'},
			body : target.parentNode.getAttribute("data-obj")
		})	
		
		// li 삭제
		e.target.parentNode.remove();
		
	// end of .uploadResult Event
	})
	
</script>

</body>
</html>

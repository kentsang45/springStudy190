<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1> Read </h1>

<button class="listButton">Go Back To List</button>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">CONTENT</th>
      <th scope="col">WRITER</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE</th>
    </tr>
  </thead>
  <tbody>
  
    <tr>
      <th scope="row">${board.bno}</th>
      <td>${board.title}</td>
      <td>${board.content}</td>
      <td>${board.writer}</td>
      <td>${board.regdate}</td>
      <td>${board.updatedate}</td>
    </tr>
    
  </tbody>
</table>



<script>

    

    
    document.querySelector(".listButton").addEventListener("click",
    		e=>{
    			console.log("List BUTTON ON");
    			e.preventDefault();
    			self.location = "/board/list";  		    		    
    		})
    
</script>




<%@include file="../includes/footer.jsp" %>

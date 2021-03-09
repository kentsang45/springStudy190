<%@ include file="../includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1> register </h1>
<button class="ajaxButton">Send Ajax</button>

<div class="modal" id="registerModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="movePage()">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    function movePage(){
        // 윈도우창의 주소를 바꿔준다.
        self.location = "/board/list";
    }
    

    //==================AJAX================//
    //==================AJAX================//
    //==================AJAX================//

    
    function sendAjax(data){
    	console.log("=========== sendAjax is on ============");
    	return fetch("/board/register", {
    		method : 'post',
    		headers : {'Content-Type' : 'application/json'},
    		body : JSON.stringify(data)
    	})
    	.then(res => {
    		if(!res.ok){
    			throw new Error(res);
    		}
    		return res.text();
    	})
    	.catch(res => {
    		 console.log("================= catch ==============")
             console.log("================= "+ res +" ==============")
             return res;
    	})
    }
    

    
    document.querySelector(".ajaxButton").addEventListener("click",
    		e=>{
    			console.log("AJAX BUTTON ON");
    			e.preventDefault();
    		    var data = {title:"테스트 제목", content:"테스트 내용", writer:"테스트 글쓴이"}
    		    var ajaxResult = sendAjax(data);
    		    
    		    ajaxResult.then(res => {
    		    	$("#registerModal").modal('show');
    		    })
    		})
    
</script>




<%@include file="../includes/footer.jsp" %>

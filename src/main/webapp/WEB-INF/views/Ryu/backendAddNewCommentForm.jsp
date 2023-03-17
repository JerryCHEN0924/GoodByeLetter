<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增回覆留言 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container w-75 text-center">





<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">

<hr>





<div class="card mt-3">
  <div class="card-header">
    留言發布時間： <span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${board.createTime}" /></span>
  </div>
  <div class="card-body">
  	
	${board.boardMessage}
  	
  </div>
  
  <div class="edit-place m-2" style="display:flex">
  
	<form action="${contextRoot}/topGun/board/edit" method="get" >
		<input type="hidden" name="boardId" value="${board.boardId}" />
		<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
	</form>
	
	<form action="${contextRoot}/topGun/board/delete" method="post" >
		<input type="hidden" name="_method" value="delete" />
		<input type="hidden" name="boardId" value="${board.boardId}" />
		<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" />
	</form>
	<div>
			<form action="${contextRoot}/topGun/comment/add" method="get" >
				<input type="hidden" name="boardId" value="${board.boardId}" />
				<input type="submit" class="btn btn-outline-warning btn-sm ms-2" value="回覆" />
			</form>
	</div>
	
  </div>
  
  
</div>







<hr>




</div>

</div>







<div class="row ">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">

  <div class="card-header">
    新增回覆留言
  </div>
  
  <div class="card-body">
  	
	<form:form action="${contextRoot}/topGun/comment/post" modelAttribute="comment" method='POST'>
  		
  		
  		<div class="mb-3 row">
			
				<div class="offset-sm-1 col-sm-10 ">
				
					<input type="hidden" name="bId" value="${board.boardId}" />
				
				</div>			
			 </div>	
  		
  		
  		
<!--   		<div class="mb-3 row"> -->
<!-- 		    <label for="inputTitleName" class="col-sm-2 col-form-label">Title</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="title" class="form-control" id="inputTitleName" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
  		<div class="mb-3 row">
		    <label for="inputBoardMessage" class="col-sm-2 col-form-label">回覆留言</label>
		    <div class="col-sm-10">
		    	<form:textarea path="reply" class="form-control" id="inputBoardMessage" rows="" cols="" />
		    </div>
		  </div>
  		
  		
  		
  		
  		<div class="mt-3">
	  		<button type="submit" class="btn btn-primary">送出</button>
  		</div>
  		
  	</form:form>
  	
  	
  </div>
  
  
</div>





</div>
</div>





<div class="row ">

<div class="offset-sm-2 col-sm-8 ">




<div class="card mt-3">

  <div class="card-header">
    貼文回覆時間： <span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${latestComment.createTime}" /></span>
  </div>
  
  <div class="card-body">
  	
	${latestComment.reply}
  	
  </div>
  
  
  
	</div>


</div>

</div>














</div>
</body>
</html>
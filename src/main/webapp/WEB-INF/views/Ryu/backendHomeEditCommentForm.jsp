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
<title>編輯回覆留言 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container text-center">





<div class="row">

<div class="offset-sm-3 col-sm-6">



</div>
</div>



<hr class="border border-dark border-3 opacity-75">






<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">

<%-- <span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span> --%>


<div class="row">

<div class="offset-sm-2 col-sm-8">




<div class="card text-dark mt-5">

  <div class="card-header">
    編輯回覆留言
  </div>
  
  <div class="card-body">
  	
	<form:form action="${contextRoot}/topGun/comment/editPostByAccount" modelAttribute="comment" method='put'>
  		
  		
  		<form:input path="commentId" type="hidden" />
  		<form:input path="createTime" type="hidden" />
  		<form:input path="board" type="hidden" />
  		<form:input path="register" type="hidden" />
  		
<!--   		<div class="mb-3 row"> -->
<!-- 		    <label for="inputTitleName" class="col-sm-2 col-form-label">Title</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="title" class="form-control" id="inputTitleName" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
  		<div class="mb-3 row">
		    <label for="inputReply" class="col-sm-2 col-form-label">回覆內容</label>
		    <div class="col-sm-10">
		    	<form:textarea path="reply" class="form-control" id="inputReply" rows="" cols="" />
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









<div class="row my-5">
		
			<div class="offset-sm-5 col-sm-2">
		
				<form action="${contextRoot}/topGun/board/queryLikeAccount" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="返回查詢留言" />
				</form>
		
			</div>
			
  		</div>











</div>

<hr class="border border-dark border-3 opacity-75">











</div>
</body>
</html>
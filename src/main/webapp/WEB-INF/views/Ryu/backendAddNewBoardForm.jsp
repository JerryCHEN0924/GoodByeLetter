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
<title>新增等級 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container w-75 text-center">





<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">

<hr>

</div>

</div>







<div class="row ">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">

  <div class="card-header">
    新增留言
  </div>
  
  <div class="card-body">
  	
	<form:form action="${contextRoot}/topGun/board/post" modelAttribute="board" method='POST'>
  		
  		
  		<div class="mb-3 row">
		    <label for="inputTitleName" class="col-sm-2 col-form-label">Title</label>
		    <div class="col-sm-10">
		    	<form:input path="title" class="form-control" id="inputTitleName" />
		    </div>
		  </div>
		  
  		<div class="mb-3 row">
		    <label for="inputBoardMessage" class="col-sm-2 col-form-label">BoardMessage</label>
		    <div class="col-sm-10">
		    	<form:textarea path="boardMessage" class="form-control" id="inputBoardMessage" rows="" cols="" />
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
    <span>（最新留言）留言主題： </span><span>${latestBoard.title}</span>
    <hr>
   <span> 留言發布時間： </span><span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${latestBoard.createTime}" /></span>
  </div>
  
  <div class="card-body">
  	
	${latestBoard.boardMessage}
  	
  </div>
  
  
  
	</div>


</div>

</div>





























</div>
</body>
</html>
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
<title>編輯部門 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container w-75 text-center">


<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">

<h1>編輯部門 Page</h1>




</div>
</div>










<div class="row ">

<div class="offset-sm-2 col-sm-8 ">


<div class="card">
  <div class="card-header">
    編輯部門 Page
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/levelByRyu/editPost" modelAttribute="levelByRyu" method="put">
  		
  		<form:input path="pLevel" type="hidden" />
  		<form:input path="createTime" type="hidden" />
  		
  		
  		<div class="mb-3 row">
		    <label for="inputPLevel" class="col-sm-2 col-form-label">Level</label>
		    <div class="col-sm-10">
		    	<input name="pLevel" class="form-control" id=inputPLevel value="${levelByRyu.pLevel}" disabled />
		    </div>
		  </div>
		  
		  <div class="mb-3 row">
		    <label for="inputLevelName" class="col-sm-2 col-form-label">LevelName</label>
		    <div class="col-sm-10">
		    	<form:input path="levelName" class="form-control" id="inputLevelName" />
		    </div>
		  </div>
		  
  		
  		
  		<div class="mb-3 row">
		    <label for="inputCreateTime" class="col-sm-2 col-form-label">CreateTime</label>
		    <div class="col-sm-10">
		    	<input name="createTime" class="form-control" id="inputCreateTime" value="${levelByRyu.createTime}" disabled />
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












</div>
</body>
</html>
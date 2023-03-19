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





<div class="row mt-5 ">

<div class="offset-sm-3 col-sm-6">


</div>

</div>


<hr class="border border-dark border-3 opacity-75">




<div class="row mt-5">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">

  <div class="card-header">
    新增權限等級資料
  </div>
  
  <div class="card-body">
  	
	<form:form action="${contextRoot}/topGun/level/post" modelAttribute="level" method='POST'>
  		
  		
  		<div class="mb-3 row">
		    <label for="inputLevelName" class="col-sm-2 col-form-label">權限名稱</label>
		    <div class="col-sm-10">
		    	<form:input path="levelName" class="form-control" id="inputLevelName" placeholder="超級管理員" />
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
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

<title>模擬會員登入介面(留言板) Page</title>

<link href="${contextRoot}/css/ryuzStyle01.css" rel="stylesheet" />

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />

<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%-- <jsp:include page="../layout/backendNavbar.jsp"></jsp:include> --%>

<div class="container w-75 text-center">





<div class="row mt-5 ">

<div class="offset-sm-3 col-sm-6 my-3">


</div>

</div>

<div class="row mt-5 ">

<div class="offset-sm-3 col-sm-6 my-3">


</div>

</div>







<div class="row mt-5">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">

  <div class="card-header">
    模擬會員登入介面(留言板)
  </div>
  
  <div class="card-body">
  	
	<form action="<c:url value='/topGun/register/LoginProcessWithBoard' />" method='POST'>
  		
  		
  		<div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">帳號</label>
		    <div class="col-sm-10">
		    	<input name="account" class="form-control" id="inputAccount" />
		    </div>
		  </div>
		  
		  
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">密碼</label>
		    <div class="col-sm-10">
		    	<input name="password" class="form-control" id="inputPassword" />
		    </div>
		  </div>
		  
		  
		  
		  
  		
  		
  		
  		
  		<div class="mt-3">
	  		<button type="submit" class="btn btn-primary">登入</button>
  		</div>
  		
  	</form>
  	
  	
  </div>
  
  
</div>





</div>
</div>


















</div>
</body>
</html>
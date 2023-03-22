<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     
     
     
     


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>







<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Spring Security</title>


<link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet" />

<script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>








<style>

	body{
		
		background-color: #3e3e3e;
		color: white;
		
	}
	
	
	
	
	
	
	
	
</style>







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



<div class="card text-dark mt-1 fs-5">

  <div class="card-header">
    後臺管理登入介面
  </div>
  
  <div class="card-body">
  	
	<form action="<c:url value='/user/login' />" method='POST'>
	
<%-- 	<form action="${contextRoot}/user/login" method='POST'> --%>
  		
  		
  		<div class="mb-3 row">
		    <label for="inputUsername" class="col-sm-2 col-form-label">帳號</label>
		    <div class="col-sm-10">
		    	<input name="username" class="form-control" id="inputUsername" placeholder="請輸入超級管理員之帳號" />
		    </div>
		  </div>
		  
		  
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">密碼</label>
		    <div class="col-sm-10">
		    	<input name="password" class="form-control" id="inputPassword" placeholder="請入超級管理員之密碼" />
		    </div>
		  </div>
		  
		  
		  
		  
		  <div class="mb-3 row">
		  
			  	<div class="offset-sm-4 col-sm-4">
			  	
				  <div class="form-check form-switch">
					  <input class="form-check-input" name="remember-me" type="checkbox" value="true" role="switch" id="flexSwitchCheckDefault">
					  <label class="form-check-label" for="flexSwitchCheckDefault">Remember Me</label>
					</div>
					
				</div>
			
			</div>
			
			
			
			
			
			
			
			
		  
		  
<!-- 		  <div class="mb-3 row"> -->
<!-- 			  <label for="remember-me">Remember Me</label> -->
<!-- 			  <input type="checkbox" name="remember-me" id="remember-me"> -->
<!-- 		  </div> -->
		  
		  
<!-- 		  <div class="mb-3 row"> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<input type="text" value="${_csrf.token}" name="_csrf"  /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
		  
  		
  		
  		<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
  		
<!--   		<div class="mt-3"> -->
	  		<button type="submit" class="btn btn-primary">登入</button>
<!--   		</div> -->
  		
  			</div>
  			
  			
  		</div>
  		
  	</form>
  		
  	
  </div>
  
  
</div>





</div>
</div>


















</div>
</body>
</html>
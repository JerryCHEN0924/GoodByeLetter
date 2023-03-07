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
<title>新增會員 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container w-75 text-center">





<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">

<h1>新增會員 Page</h1>

</div>

</div>







<div class="row ">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">
  <div class="card-header">
    新增會員
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/register/post" modelAttribute="register" method='POST'>
  		
  		
  		
		  
		  
		
			
			<div class="mb-3 row">
			
				<div class="offset-sm-1 col-sm-10 ">
			
					<form:select path="pId" class="form-select form-select-lg mb-1 text-center"  aria-label=".form-select-lg example" >
						<form:option value="2" >請選部門</form:option>
						<form:options items="${plevelList}" />
					</form:select>
				
				</div>			
			 </div>	
			 
			 
			 
		
		
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">Account</label>
		    <div class="col-sm-10">
		    	<form:input path="account" class="form-control" id="inputAccount" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
		    <div class="col-sm-10">
		    	<form:input path="password" class="form-control" id="inputPassword" />
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
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
    編輯廠商細項資料
  </div>
  <div class="card-body">
  	
  	<form:form enctype='multipart/form-data' action="${contextRoot}/topGun/vendorDetails/put/${vendorDetails.vendorDetailsId}" modelAttribute="vendorDetails" method='post'>
  		
<!--   		<input type='hidden' name = '_method' value='put'> -->
  		
  		<form:hidden path="vendorDetailsId" class="form-control" id="inputVendorDetailsId" />
  		
  		<c:if test='${vendorDetails.vendorDetailsId != null}'>
  		 <div class="mb-3 row">
		    <label for="inputVendorDetailsId" class="col-sm-2 col-form-label">VendorDetailsId</label>
		    <div class="col-sm-10">
		    	<input name="vendorDetailsId" value="${vendorDetails.vendorDetailsId}" class="form-control" id="inputVendorDetailsId" disabled />
		    </div>
		  </div>
		 </c:if>
		  
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputCompanyName" class="col-sm-2 col-form-label">CompanyName</label>
		    <div class="col-sm-10">
		    	<form:input path="companyName" class="form-control" id="inputCompanyName" />
		    	<form:errors path="companyName" class="form-control" id="inputCompanyName" cssClass="error" />
		    </div>
		  </div>
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputCompanyType" class="col-sm-2 col-form-label">CompanyType</label>
		    <div class="col-sm-10">
		    	<form:input path="companyType" class="form-control" id="inputCompanyType" />
		    	<form:errors path="companyType" class="form-control" id="inputCompanyType" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
		    <div class="col-sm-10">
		    	<form:input path="email" class="form-control" id="inputEmail" />
		    	<form:errors path="email" class="form-control" id="inputEmail" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputAddress" class="col-sm-2 col-form-label">Address</label>
		    <div class="col-sm-10">
		    	<form:input path="address" class="form-control" id="inputAddress" />
		    	<form:errors path="address" class="form-control" id="inputAddress" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputVendorDetailsImage" class="col-sm-2 col-form-label">VendorDetailsImage</label>
		    <div class="col-sm-10">
		    	<form:input path="image" class="form-control" id="inputVendorDetailsImage" type='file' />
		    	<form:errors path="image" class="form-control" id="inputVendorDetailsImage" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputFileName" class="col-sm-2 col-form-label">FileName</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="fileName" class="form-control" id="inputFileName" /> --%>
<%-- 		    	<form:errors path="fileName" class="form-control" id="inputFileName" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputAddress" class="col-sm-2 col-form-label">Address</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="address" class="form-control" id="inputAddress" /> --%>
<%-- 		    	<form:errors path="address" class="form-control" id="inputAddress" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
		  
		  
		  
  		
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
		
				<form action="${contextRoot}/topGun" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="回後台首頁" />
				</form>
		
			</div>
			
  		</div>



</div>

<hr class="border border-dark border-3 opacity-75">















</div>
</body>
</html>
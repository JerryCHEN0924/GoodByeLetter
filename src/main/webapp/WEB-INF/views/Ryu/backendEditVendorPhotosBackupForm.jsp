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
<title>編輯廣告文案 Page</title>
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
    編輯廣告文案
  </div>
  
  <div class="card-body">
  	
  	<form:form enctype='multipart/form-data' action="${contextRoot}/topGun/vendorPhotosBackup/put/${vendorPhotos.id}" modelAttribute="vendorPhotos" method='POST'>
  		
  		
  		<form:hidden path="id" class="form-control" id="inputVendorPhotosId" />
<%--   		<form:hidden path="yJCustomerDetail" class="form-control" id="inputVendorPhotosFk_companydetail_id" /> --%>
  		<form:hidden path="photoFile" class="form-control" id="inputVendorPhotosPhotoFile" />
  		<form:hidden path="customerDetail" class="form-control" id="inputVendorPhotosPhotoFile" />
  		
  		
  		<c:if test='${vendorPhotos.id != null}'>
  		 <div class="mb-3 row">
		    <label for="inputVendorPhotosId" class="col-sm-2 col-form-label">文案編號</label>
		    <div class="col-sm-10">
		    	<input name="id" value="${vendorPhotos.id}" class="form-control" id="inputVendorPhotosId" disabled />
		    </div>
		  </div>
		 </c:if>
		  
		  
		  
		  
<!-- 		   <div class="mb-3 row"> -->
<!-- 		    <label for="inputTitle" class="col-sm-2 col-form-label">文案標題</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="title" class="form-control" id="inputTitle" placeholder="好好說再見" /> --%>
<%-- 		    	<form:errors path="title" class="form-control" id="inputTitle" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputDescription" class="col-sm-2 col-form-label">文案描述</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:textarea path="description" class="form-control" id="inputDescription" rows="15" cols="" /> --%>
<%-- 		    	<form:errors path="description" class="form-control" id="inputDescription" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
<!-- 		  <div class="mb-3 row"> -->
<!-- 		    <label for="inputEnabled" class="col-sm-2 col-form-label">審核狀態</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="enabled" class="form-control" id="inputEnabled" /> --%>
<%-- 		    	<form:errors path="enabled" class="form-control" id="inputEnabled" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputEnabled" class="col-sm-2 col-form-label">審核狀態</label>
		    <div class="col-sm-10">
		    	<form:input path="enable" class="form-control" id="inputEnabled" />
<%-- 		    	<form:errors path="enable" class="form-control" id="inputEnabled" cssClass="error" /> --%>
		    </div>
		  </div>
		  
		  
		   <div class="mb-3 row">
		    <label for="inputVendorDetailsImage" class="col-sm-2 col-form-label">文案圖片</label>
		    <div class="col-sm-10">
		    
<%-- 		    	<form:input path="image" class="form-control" id="inputVendorDetailsImage" type='file' /> --%>
		    	
<%-- 		    	<input name="image" class="form-control" id="inputVendorDetailsImage" type='file' value="${vendorPhotos.photoFile}" multiple /> --%>
		    	<form:input path="image" class="form-control" id="inputVendorDetailsImage" type='file'  />
		    	
<%-- 		    	<form:input path="productImage" type='file'/><br>&nbsp; --%>
		    	
<%-- 		    	<form:errors path="image" class="form-control" id="inputVendorDetailsImage" cssClass="error" /> --%>
		    </div>
		  </div>
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputVendorDetailsImage" class="col-sm-2 col-form-label">文案圖片</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="image" class="form-control" id="inputVendorDetailsImage" type='file' /> --%>
<%-- 		    	<form:errors path="image" class="form-control" id="inputVendorDetailsImage" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputFileName" class="col-sm-2 col-form-label">FileName</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="fileName" class="form-control" id="inputFileName" /> --%>
<%-- 		    	<form:errors path="fileName" class="form-control" id="inputFileName" cssClass="error" /> --%>
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
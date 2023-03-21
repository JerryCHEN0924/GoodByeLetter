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
<title>新增廣告文案 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>



<div class="container text-center">






<div class="row my-3">

<div class="offset-sm-3 col-sm-6">



</div>
</div>



<hr class="border border-dark border-3 opacity-75">






<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">

<span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span>

<div class="row">

<div class="offset-sm-2 col-sm-8">



<div class="card text-dark mt-5">

  <div class="card-header">
    新增廣告文案
  </div>
  
  <div class="card-body">
  	
  	<form:form enctype='multipart/form-data' action="${contextRoot}/topGun/vendorPhotosBackup/post" modelAttribute="vendorPhotos" method='POST'>
  		
  		
  		<c:if test='${vendorPhotos.id != null}'>
  		 <div class="mb-3 row">
		    <label for="inputVendorPhotosId" class="col-sm-2 col-form-label">VendorPhotosId</label>
		    <div class="col-sm-10">
		    	<form:input path="id" class="form-control" id="inputVendorPhotosId" />
		    </div>
		  </div>
		 </c:if>
		  
		  
<!-- 		  <div class="mb-3 row"> -->
<!-- 		    <label for="inputAccount" class="col-sm-2 col-form-label">帳號</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="account" class="form-control" id="inputAccount" placeholder="請輸入已存在之廠商帳號" /> --%>
<%-- 		    	<form:errors path="account" class="form-control" id="inputAccount" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
<!-- 		  <div class="mb-3 row"> -->
<!-- 		    <label for="inputTitle" class="col-sm-2 col-form-label">文案標題</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="title" class="form-control" id="inputTitle" placeholder="好好說再見" /> --%>
<%-- 		    	<form:errors path="title" class="form-control" id="inputTitle" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputDescription" class="col-sm-2 col-form-label">文案描述</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:textarea path="description" class="form-control" id="inputDescription" rows="15" cols="" placeholder="「尋找人生目標，其實有一個非常簡單的方法，那就是，一直想，一直想，一直想。如果每天給自己一些時間，持續問自己：我的人生目標是什麼？我的夢想是什麼？我的理想是什麼？我相信，不超過一年，人人都會找到自己的人生目標。但實際上，大多數人別說完成人生目標，甚至捨不得在尋找人生目標上花一點點時間。就像，一個人走出家門，漫無目的遊蕩，寧可從白天遊蕩到天黑，寧可日複一日，年複一年地遊蕩，也不願意問自己一個問題，自己出門是為了什麼？」" /> --%>
<%-- 		    	<form:errors path="description" class="form-control" id="inputDescription" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputVendorDetailsImage" class="col-sm-2 col-form-label">文案圖片</label>
		    <div class="col-sm-10">
		    	<form:input path="image" class="form-control" id="inputVendorDetailsImage" type='file' />
		    	<form:errors path="image" class="form-control" id="inputVendorDetailsImage" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputVendorDetailsImage" class="col-sm-2 col-form-label">文案圖片</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="photoFile" class="form-control" id="inputVendorDetailsImage" type='file' /> --%>
<%-- 		    	<form:errors path="photoFile" class="form-control" id="inputVendorDetailsImage" cssClass="error" /> --%>
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
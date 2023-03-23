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
<title>編輯會員註冊資料 Page</title>
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
   審核廣告商啟用狀態
  </div>
  
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/vendorDetailsBackup/enableEditPost" modelAttribute="register" method="put">
  		
  		<form:input path="memberId" type="hidden" />
  		<form:input path="registerTime" type="hidden" />
  		<form:input path="FK_Plevel" type="hidden" />
  		
  		
  		
  		
  		<div class="mb-3 row">
		    <label for="inputMemberId" class="col-sm-2 col-form-label">編號</label>
		    <div class="col-sm-10">
		    	<input name="memberId" class="form-control" id="inputMemberId" value="${register.memberId}" disabled />
		    </div>
		  </div>
		  
		  
		  
  		
  		
  		
  		<div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">帳號</label>
		    <div class="col-sm-10">
		    	<form:input path="account" class="form-control" id="inputAccount" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">密碼</label>
		    <div class="col-sm-10">
		    	<form:input path="password" class="form-control" id="inputPassword" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEnabled" class="col-sm-2 col-form-label">啟用狀態</label>
		    <div class="col-sm-10">
		    	<form:input path="enabled" class="form-control" id="inputEnabled" />
		    </div>
		  </div>
		  
		  
		  <div class="mb-3 row">
		    <label for="inputRegisterTime" class="col-sm-2 col-form-label">註冊時間</label>
		    <div class="col-sm-10">
		    	<input name="registerTime" class="form-control" id="inputRegisterTime" value="${register.registerTime}" disabled />
		    </div>
		  </div>
		  
  		<div class="mb-3 row">
		    <label for="inputFK_Plevel" class="col-sm-2 col-form-label">權限編號</label>
		    <div class="col-sm-10">
		    	<input name="FK_Plevel" class="form-control" id="inputFK_Plevel" value="${register.FK_Plevel.plevel}" disabled />
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
		
				<form action="${contextRoot}/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="回審核廣告商頁面" />
				</form>
		
			</div>
			
  		</div>



</div>

<hr class="border border-dark border-3 opacity-75">















</div>
</body>
</html>
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
<title>審核會員啟用狀態 Page</title>
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
    審核會員啟用狀態
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/registerEnabled/editPost" modelAttribute="register" method="put">
  		
  		<form:input path="memberId" type="hidden" />
  		<form:input path="account" type="hidden" />
  		<form:input path="password" type="hidden" />
  		<form:input path="registerTime" type="hidden" />
  		<form:input path="FK_Plevel" type="hidden" />
  		
  		
  		
  		
  		<div class="mb-3 row">
		    <label for="inputMemberId" class="col-sm-2 col-form-label">會員編號</label>
		    <div class="col-sm-10">
		    	<input name="memberId" class="form-control" id="inputMemberId" value="${register.memberId}" disabled />
		    </div>
		  </div>
		  
		  
		  
  		
  		
  		
  		<div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">帳號</label>
		    <div class="col-sm-10">
		    	<input name="account" class="form-control" id="inputAccount" value="${register.account}" disabled />
<%-- 		    	<form:input path="account" class="form-control" id="inputAccount" disabled /> --%>
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">密碼</label>
		    <div class="col-sm-10">
		    	<input name="password" class="form-control" id="inputPassword" value="${register.password}" disabled />
<%-- 		    	<form:input path="password" class="form-control" id="inputPassword" disabled /> --%>
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
		    <label for="inputFK_Plevel" class="col-sm-2 col-form-label">權限等級</label>
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












</div>
</body>
</html>
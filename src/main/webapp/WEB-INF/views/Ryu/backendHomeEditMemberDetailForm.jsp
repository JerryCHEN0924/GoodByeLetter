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
<title>編輯會員細項資料 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container text-center">


<div class="row my-3 ">

<div class="offset-sm-3 col-sm-6">



</div>
</div>






<hr class="border border-dark border-3 opacity-75">


<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-3">




<div class="row ">

<div class="offset-sm-2 col-sm-8 ">


<div class="card text-dark mt-5">
  <div class="card-header">
    編輯會員細項資料
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/backendHome/memberDetail/editPost" modelAttribute="memberDetail" method="put">
  		
  		<form:input path="id" type="hidden" />
  		<form:input path="FK_memberId" type="hidden" />
  		<form:input path="FK_Plevel" type="hidden" />
  		
  		
  		
  		
  		<div class="mb-3 row">
		    <label for="inputMemberDetailId" class="col-sm-2 col-form-label">編號</label>
		    <div class="col-sm-10">
		    	<input name="id" class="form-control" id="inputMemberDetailId" value="${memberDetail.id}" disabled />
		    </div>
		  </div>
		  
		  
		  
  		
  		
  		
  		<div class="mb-3 row">
		    <label for="inputName" class="col-sm-2 col-form-label">姓名</label>
		    <div class="col-sm-10">
		    	<form:input path="name" class="form-control" id="inputName" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputGender" class="col-sm-2 col-form-label">性別</label>
		    <div class="col-sm-10">
		    	<form:input path="gender" class="form-control" id="inputGender" />
		    </div>
		  </div>
		  
  		 <div class="mb-3 row">
		    <label for="inputBirthday" class="col-sm-2 col-form-label">生日</label>
		    <div class="col-sm-10">
		    	<form:input path="birthday" class="form-control" id="inputBirthday" />
		    </div>
		  </div>
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
		    <div class="col-sm-10">
		    	<form:input path="email" class="form-control" id="inputEmail" />
		    </div>
		  </div>
		  
  		 <div class="mb-3 row">
		    <label for="inputCounty" class="col-sm-2 col-form-label">國家</label>
		    <div class="col-sm-10">
		    	<form:input path="County" class="form-control" id="inputCounty" />
		    </div>
		  </div>
		  
  		 <div class="mb-3 row">
		    <label for="inputAddress" class="col-sm-2 col-form-label">地址</label>
		    <div class="col-sm-10">
		    	<form:input path="address" class="form-control" id="inputAddress" />
		    </div>
		  </div>
		  
		  
		  <div class="mb-3 row">
		    <label for="inputFK_memberId" class="col-sm-2 col-form-label">會員編號</label>
		    <div class="col-sm-10">
		    	<input name="FK_memberId" class="form-control" id="inputFK_memberId" value="${memberDetail.FK_memberId.memberId}" disabled />
		    </div>
		  </div>
		  
  		<div class="mb-3 row">
		    <label for="inputFK_Plevel" class="col-sm-2 col-form-label">權限</label>
		    <div class="col-sm-10">
		    	<input name="FK_Plevel" class="form-control" id="inputFK_Plevel" value="${memberDetail.FK_Plevel.plevel}" disabled />
		    </div>
		  </div>
		  
  		
  		<div class="mt-3">
  		
	  		<button type="submit" class="btn btn-primary">編輯</button>
	  		
  		</div>
  		
  	</form:form>
  	
  	
  	
  	
  	
  </div>
</div>



</div>
</div>










		<div class="row my-3">
		
			<div class="offset-sm-5 col-sm-2">
		
				<form action="${contextRoot}/topGun" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="回後台首頁" />
				</form>
		
			</div>
			
<!-- 			<div class="offset-sm-5 col-sm-1"> -->
			
			
<%-- 			<form action="${contextRoot}/topGun/backendHome/memberDetail/delete" method="post" > --%>
<!-- 				<input type="hidden" name="_method" value="delete" /> -->
<%-- 				<input type="hidden" name="id" value="${memberDetail.id}" /> --%>
<!-- 				<input type="submit" class="btn btn-outline-danger" value="刪除" /> -->
<%-- 			</form> --%>
			
<%-- 			<form:form action="${contextRoot}/topGun/backendHome/memberDetail/delete?id=${memberDetail.id}" method="delete" > --%>
<!-- 				<input type="submit" class="btn btn-outline-danger btn-sm" value="刪除" /> -->
<%-- 			</form:form> --%>
			
			
			
<!--   			</div> -->
  			
  			
  			
  			
<!--   			<div class="col-sm-1"> -->
  			
  			
  			
<%-- 			  	<form action="${contextRoot}/topGun" method="get" > --%>
<!-- 					<input type="submit" class="btn btn-outline-warning" value="回後台首頁" /> -->
<%-- 				</form> --%>
				
				
				
<!-- 			</div> -->
  			
	  		
  		</div>



</div>

<hr class="border border-dark border-3 opacity-75">







</div>
</body>
</html>
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
<title>新增會員細項資料 Page</title>
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

<div class="offset-sm-2 col-sm-8 ">



<div class="card text-dark mt-5">

  <div class="card-header">
    新增會員細項資料
  </div>
  
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/memberDetail/post" modelAttribute="memberDetail" method='POST'>
  		
  		
  		<c:if test='${memberDetail.id != null}'>
  		 <div class="mb-3 row">
		    <label for="inputMemberDetailId" class="col-sm-2 col-form-label">編號</label>
		    <div class="col-sm-10">
		    	<form:input path="id" class="form-control" id="inputMemberDetailId" />
		    </div>
		  </div>
		 </c:if>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">帳號</label>
		    <div class="col-sm-10">
		    	<form:input path="account" class="form-control" id="inputAccount" placeholder="請輸入已存在之帳號"/>
		    	<form:errors path="account" class="form-control" id="inputAccount" cssClass="error" />
		    </div>
		  </div>
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputName" class="col-sm-2 col-form-label">姓名</label>
		    <div class="col-sm-10">
		    	<form:input path="name" class="form-control" id="inputName" placeholder="楊過" />
		    	<form:errors path="name" class="form-control" id="inputName" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputGender" class="col-sm-2 col-form-label">性別</label> -->
<!-- 		    <div class="col-sm-10"> -->
<%-- 		    	<form:input path="gender" class="form-control" id="inputGender" placeholder="男" /> --%>
<%-- 		    	<form:errors path="gender" class="form-control" id="inputGender" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
<!--   		 <div class="mb-3 row"> -->
<!-- 		    <label for="inputGender" class="col-sm-2 col-form-label">性別</label> -->
<!-- 		    <div class="col-sm-10"> -->
<!-- 		    	<input name="gender" class="form-control" id="inputGender" placeholder="男" /> -->
<%-- 		    	<form:errors path="gender" class="form-control" id="inputGender" cssClass="error" /> --%>
<!-- 		    </div> -->
<!-- 		  </div> -->
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputGender" class="col-sm-2 col-form-label">性別</label>
		    <div class="col-sm-8">
		    
		    
		    		<input type="radio" class="btn-check" name="gender" id="inputGender01" autocomplete="off" value="male" checked>
					<label class="btn btn-outline-primary" for="inputGender01">男性</label>
					
					<input type="radio" class="btn-check" name="gender" id="inputGender02" autocomplete="off" value="female">
					<label class="btn btn-outline-danger" for="inputGender02">女性</label>
					
					<input type="radio" class="btn-check" name="gender" id="inputGender03" autocomplete="off" value="nonbinary">
					<label class="btn btn-outline-success" for="inputGender03">中性</label>
					
					<input type="radio" class="btn-check" name="gender" id="inputGender04" autocomplete="off" value="secret">
					<label class="btn btn-outline-secondary" for="inputGender04">保密</label>
		    	
		    	
		    	<form:errors path="gender" class="form-control" id="inputGender" cssClass="error" />
		    	
		    	
		    	
		    </div>
		  </div>
		  
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputBirthday" class="col-sm-2 col-form-label">生日</label>
		    <div class="col-sm-10">
		    
<%-- 		    	<form:input path="birthday" class="form-control" id="inputBirthday" placeholder="yyyy-MM-dd" /> --%>
		    	
		    	<input name="birthday" type="date" class="form-control" id="inputBirthday" placeholder="yyyy-MM-dd" />
		    	<form:errors path="birthday" class="form-control" id="inputBirthday" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
		    <div class="col-sm-10">
		    	<form:input path="Email" class="form-control" id="inputEmail" placeholder="test@gmail.com" />
		    	<form:errors path="Email" class="form-control" id="inputEmail" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputCounty" class="col-sm-2 col-form-label">國家</label>
		    <div class="col-sm-10">
		    	<form:input path="County" class="form-control" id="inputCounty" placeholder="台灣" />
		    	<form:errors path="County" class="form-control" id="inputCounty" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputAddress" class="col-sm-2 col-form-label">地址</label>
		    <div class="col-sm-10">
		    	<form:input path="address" class="form-control" id="inputAddress" placeholder="高雄市前金區中正四路211號8號樓之1" />
		    	<form:errors path="address" class="form-control" id="inputAddress" cssClass="error" />
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
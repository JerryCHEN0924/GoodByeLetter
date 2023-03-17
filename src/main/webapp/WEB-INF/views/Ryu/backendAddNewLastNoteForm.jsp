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
<title>新增 GoodBye Letter Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container w-75 text-center">





<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">



<div class="card my-5">

  <div class="card-header">
    <h1>模擬會員登入(GoodBye Letter)</h1>
  </div>
  
  <div class="card-body">
  
  
  
  
  	<div>
   	<c:choose>
	    <c:when test="${not empty existing}">
	        <!-- member 物件存在，顯示登出按鈕 -->
	        <a class="btn btn-warning" type="button" href="${contextRoot}/topGun/register/LogoutProcessWithLastNote">${existing.account} 登出</a>
	    </c:when>
	    <c:otherwise>
	        <!-- member 物件不存在，顯示登入按鈕 -->
	        <a class="btn btn-secondary" type="button" href="${contextRoot}/topGun/register/addLoginFormWithLastNote">${existing.account} 登入</a>
	    </c:otherwise>
	</c:choose>
	</div>
	
	
	
	
	
  	
  </div>
  
  
</div>








<hr>















</div>

</div>







<div class="row ">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">
  <div class="card-header">
    新增 GoodBye Letter 內容
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/lastNote/post" modelAttribute="lastNote" method='POST'>
  		
  		
  		<c:if test='${lastNote.noteId != null}'>
  		 <div class="mb-3 row">
		    <label for="inputNoteId" class="col-sm-2 col-form-label">編號</label>
		    <div class="col-sm-10">
		    	<form:input path="noteId" class="form-control" id="inputNoteId" />
		    </div>
		  </div>
		 </c:if>
		  
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">收件人信箱</label>
		    <div class="col-sm-10">
		    	<form:input path="recipientEmail" class="form-control" id="inputRecipientEmail" placeholder="想把這封信寄給誰呢？" />
		    	<form:errors path="recipientEmail" class="form-control" id="inputRecipientEmail" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">第一驗證人信箱</label>
		    <div class="col-sm-10">
		    	<form:input path="verify1" class="form-control" id="inputVerify1" placeholder="test@gmail.com" />
		    	<form:errors path="verify1" class="form-control" id="inputVerify1" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">第二驗證人信箱</label>
		    <div class="col-sm-10">
		    	<form:input path="verify2" class="form-control" id="inputVerify2" placeholder="test@gmail.com" />
		    	<form:errors path="verify2" class="form-control" id="inputVerify2" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputCounty" class="col-sm-2 col-form-label">信件內容</label>
		    <div class="col-sm-10">
		    	<form:textarea path="notedetail" class="form-control" id="inputNotedetail" rows="15" cols="" placeholder="「遇到困難時，不要總想著避開，要想如何主動解決。因為逃避會成為習慣，讓我們一遇到困難，就縮回自己的世界舔傷口。直到有一天，遇到你這一生最想擁有的東西，或者是那個人，你會習慣性逃避，習慣性縮回自己的世界。等你發現徹底失去的時候，追悔莫及，然後繼續縮在自己的世界，耗盡一生的時間後悔。在那個時候，哪怕有人用盡一切力量，甚至用他的生命擊碎你的小世界，向你伸出手，要拉你出去……“你也會因為低著頭，沒能看到。”」" />
		    	<form:errors path="notedetail" class="form-control" id="inputNotedetail" cssClass="error" />
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
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

<h1>新增LastNote內容 Page</h1>

</div>

</div>







<div class="row ">

<div class="offset-sm-2 col-sm-8 ">



<div class="card">
  <div class="card-header">
    新增LastNote內容
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/lastNote/post" modelAttribute="lastNote" method='POST'>
  		
  		
  		<c:if test='${lastNote.noteId != null}'>
  		 <div class="mb-3 row">
		    <label for="inputNoteId" class="col-sm-2 col-form-label">NoteId</label>
		    <div class="col-sm-10">
		    	<form:input path="noteId" class="form-control" id="inputNoteId" />
		    </div>
		  </div>
		 </c:if>
		  
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">RecipientEmail</label>
		    <div class="col-sm-10">
		    	<form:input path="recipientEmail" class="form-control" id="inputRecipientEmail" />
		    	<form:errors path="recipientEmail" class="form-control" id="inputRecipientEmail" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">Verify1</label>
		    <div class="col-sm-10">
		    	<form:input path="verify1" class="form-control" id="inputVerify1" />
		    	<form:errors path="verify1" class="form-control" id="inputVerify1" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">Verify2</label>
		    <div class="col-sm-10">
		    	<form:input path="verify2" class="form-control" id="inputVerify2" />
		    	<form:errors path="verify2" class="form-control" id="inputVerify2" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputCounty" class="col-sm-2 col-form-label">Notedetail</label>
		    <div class="col-sm-10">
		    	<form:textarea path="notedetail" class="form-control" id="inputNotedetail" rows="15" cols="" />
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
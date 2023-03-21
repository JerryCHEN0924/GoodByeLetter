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
<title>編輯 Goodbye Letter 內容 Page</title>
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
    編輯 Goodbye Letter 內容
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/lastNote/editPostByAccount" modelAttribute="lastNote" method='PUT'>
  		
  		<form:input path="noteId" type="hidden" />
  		<form:input path="FK_memberId" type="hidden" />
  		<form:input path="createTime" type="hidden" />
  		<form:input path="verifyTime" type="hidden" />
  		
  		<c:if test='${lastNote.noteId != null}'>
  		 <div class="mb-3 row">
		    <label for="inputNoteId" class="col-sm-2 col-form-label">編號</label>
		    <div class="col-sm-10">
<%-- 		    	<form:input path="noteId" class="form-control" id="inputNoteId" /> --%>
		    	<input name="noteId" class="form-control" id="inputNoteId" value="${lastNote.noteId}" disabled />
		    </div>
		  </div>
		 </c:if>
		 
		 
		 
		 <c:if test='${lastNote.FK_memberId != null}'>
  		 <div class="mb-3 row">
		    <label for="inputFK_memberId" class="col-sm-2 col-form-label">會員編號</label>
		    <div class="col-sm-10">
<%-- 		    	<form:input path="FK_memberId" class="form-control" id="inputFK_memberId" /> --%>
		    	<input name="FK_memberId" class="form-control" id="inputFK_memberId" value="${lastNote.FK_memberId.memberId}" disabled />
		    </div>
		  </div>
		 </c:if>
		 
		 
		 
		  <c:if test='${lastNote.createTime != null}'>
  		 <div class="mb-3 row">
		    <label for="inputCreateTime" class="col-sm-2 col-form-label">新增時間</label>
		    <div class="col-sm-10">
<%-- 		    	<form:input path="createTime" class="form-control" id="inputCreateTime" /> --%>
		    	<input name="createTime" class="form-control" id="inputCreateTime" value="${lastNote.createTime}" disabled />
		    </div>
		  </div>
		 </c:if>
		 
		 
		 <c:if test='${lastNote.verifyTime != null}'>
  		 <div class="mb-3 row">
		    <label for="inputVerifyTime" class="col-sm-2 col-form-label">驗證時間</label>
		    <div class="col-sm-10">
<%-- 		    	<form:input path="verifyTime" class="form-control" id="inputVerifyTime" /> --%>
		    	<input name="verifyTime" class="form-control" id="inputVerifyTime" value="${lastNote.verifyTime}" disabled />
		    </div>
		  </div>
		 </c:if>
		  
		  
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">收件人信箱</label>
		    <div class="col-sm-10">
		    	<form:input path="recipientEmail" class="form-control" id="inputRecipientEmail" />
		    	<form:errors path="recipientEmail" class="form-control" id="inputRecipientEmail" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
  		 <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">第一驗證人信箱</label>
		    <div class="col-sm-10">
		    	<form:input path="verify1" class="form-control" id="inputVerify1" />
		    	<form:errors path="verify1" class="form-control" id="inputVerify1" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputEmail" class="col-sm-2 col-form-label">第二驗證人信箱</label>
		    <div class="col-sm-10">
		    	<form:input path="verify2" class="form-control" id="inputVerify2" />
		    	<form:errors path="verify2" class="form-control" id="inputVerify2" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputEnabled" class="col-sm-2 col-form-label">啟用狀態</label>
		    <div class="col-sm-10">
		    	<form:input path="enabled" class="form-control" id="inputEnabled" />
		    	<form:errors path="enabled" class="form-control" id="inputEnabled" cssClass="error" />
		    </div>
		  </div>
		  
		  
		  
		  
		  
		  
		  <div class="mb-3 row">
		    <label for="inputCounty" class="col-sm-2 col-form-label">信箱內容</label>
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










<div class="row my-5">
		
			<div class="offset-sm-5 col-sm-2">
		
				<form action="${contextRoot}/topGun/lastNote/queryLikeAccount" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="返回查詢 GoodBye Letter" />
				</form>
		
			</div>
			
  		</div>



</div>

<hr class="border border-dark border-3 opacity-75">

















</div>
</body>
</html>
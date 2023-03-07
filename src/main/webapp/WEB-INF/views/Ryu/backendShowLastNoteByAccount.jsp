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
<title>查看留言訊息 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container w-75 text-center">



<div class="row mt-3">

<div class="offset-sm-3 col-sm-6">



<hr>











<div class="card">
  <div class="card-header">
  
  依Account查詢使用者
  
  </div>
  <div class="card-body">
  	
  	<c:forEach var="register" items="${register}">
  	
  	<table class="table table-dark table-striped-columns table-hover">
  	
	  <thead>
	  
	  
	    <tr class="table-secondary table-active">
	      <th scope="col">memberId</th>
	      <th scope="col">account</th>
	      <th scope="col">password</th>
	      <th scope="col">Email</th>
	      <th scope="col">name</th>
	      <th scope="col">Edit</th>
	    </tr>
	    
	    
	    
	  </thead>
	  
	  
	  
	  <tbody>
	  
	  
	  
	    <tr>
	      <td>${register.memberId}</td>
	      <td>${register.account}</td>
	      <td>${register.password}</td>
	      <td>${register.lastnote}</td>
	      <td>${register.boards}</td>
	      <td>${register.comments}</td>
	      <td>${register.memberId}</td>
	      
<%-- 	      <a href="<c:url value='/ch04/ex02/queryCategoryById.do?catId=${category.categoryId}'  />">${category.name}</a> --%>
	      
<%-- 	      <td>${register.verifyTime}</td> --%>
<%-- 	      <td>${register.createTime}</td> --%>
<%-- 	      <td>${register.notedetail}</td> --%>
<%-- 	      <td>${lastNote.FK_memberId.memberId}</td> --%>



<!-- 	      <td> -->
<!-- 	      	<div class="d-flex justify-content-center"> -->
<!-- 	      		<div class="mx-1"> -->
<%-- 		  	<form action="${contextRoot}/topGun/lastNote/edit" method="get" > --%>
<%-- 				<input type="hidden" name="noteId" value="${lastNote.noteId}" /> --%>
<!-- 				<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" /> -->
<%-- 			</form> --%>
<!-- 				</div> -->
<!-- 				<div> -->
<%-- 			<form action="${contextRoot}/topGun/lastNote/delete" method="post" > --%>
<!-- 				<input type="hidden" name="_method" value="delete" /> -->
<%-- 				<input type="hidden" name="noteId" value="${lastNote.noteId}" /> --%>
<!-- 				<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" /> -->
<%-- 			</form> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 	      </td> -->
	      
	      
	      
	      
	    </tr>
	    
	    
	    
	    
	  </tbody>
	</table>
  	
  	</c:forEach>
  	
  	
  </div>
</div>































</div>

</div>





















<div class="row ">

<div class="offset-sm-2 col-sm-8 ">


<div class="card">
  <div class="card-header">
    查詢和編輯權限等級
  </div>
  <div class="card-body">
  	
  		
	<form action="${contextRoot}/topGun/lastNote/queryLikeAccountPost" method="get" >
		
		
		
		<div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">依帳號查詢</label>
		    <div class="col-sm-10">
		    	<input name="account" class="form-control" id=inputAccount  />
		    </div>
		  </div>
		  
		  
  		
  		
  		
  		
  		<div class="mt-3">
  		
	  		<button type="submit" class="btn btn-primary">送出</button>
	  		
  		</div>
		
		
		
		
		
		
		
		
	</form>
  	
  	
  	
  </div>
</div>



</div>
</div>
















<hr>






<div class="row mt-3">

<div>



<div class="card">
  <div class="card-header">
  
  查看LastNote
  
  </div>
  <div class="card-body">
  	
<%--   	<c:forEach var="lastNote" items="${register}"> --%>
  	
<!--   	<table class="table table-dark table-striped-columns table-hover"> -->
  	
<!-- 	  <thead> -->
	  
	  
<!-- 	    <tr class="table-secondary table-active"> -->
<!-- 	      <th scope="col">noteId</th> -->
<!-- 	      <th scope="col">recipientEmail</th> -->
<!-- 	      <th scope="col">verify1</th> -->
<!-- 	      <th scope="col">verify2</th> -->
<!-- 	      <th scope="col">verifyTime</th> -->
<!-- 	      <th scope="col">createTime</th> -->
<!-- 	      <th scope="col">notedetail</th> -->
<!-- 	      <th scope="col">FK_memberId</th> -->
<!-- 	      <th scope="col">Edit</th> -->
<!-- 	    </tr> -->
	    
	    
	    
<!-- 	  </thead> -->
	  
	  
	  
<!-- 	  <tbody> -->
	  
	  
	  
<!-- 	    <tr> -->
<%-- 	      <td>${lastNote.noteId}</td> --%>
<%-- 	      <td>${lastNote.recipientEmail}</td> --%>
<%-- 	      <td>${lastNote.verify1}</td> --%>
<%-- 	      <td>${lastNote.verify2}</td> --%>
<%-- 	      <td>${lastNote.verifyTime}</td> --%>
<%-- 	      <td>${lastNote.createTime}</td> --%>
<%-- 	      <td>${lastNote.notedetail}</td> --%>
<%-- 	      <td>${lastNote.FK_memberId.memberId}</td> --%>
<!-- 	      <td> -->
<!-- 	      	<div class="d-flex justify-content-center"> -->
<!-- 	      		<div class="mx-1"> -->
<%-- 		  	<form action="${contextRoot}/topGun/lastNote/edit" method="get" > --%>
<%-- 				<input type="hidden" name="noteId" value="${lastNote.noteId}" /> --%>
<!-- 				<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" /> -->
<%-- 			</form> --%>
<!-- 				</div> -->
<!-- 				<div> -->
<%-- 			<form action="${contextRoot}/topGun/lastNote/delete" method="post" > --%>
<!-- 				<input type="hidden" name="_method" value="delete" /> -->
<%-- 				<input type="hidden" name="noteId" value="${lastNote.noteId}" /> --%>
<!-- 				<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" /> -->
<%-- 			</form> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 	      </td> -->
<!-- 	    </tr> -->
	    
	    
	    
	    
<!-- 	  </tbody> -->
<!-- 	</table> -->
  	
<%--   	</c:forEach> --%>
  	
  	
  </div>
</div>


</div>
</div>










<div>

<hr>

</div>













</div>
</body>
</html>
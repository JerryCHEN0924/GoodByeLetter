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
<title>依Account查詢Board Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container w-75 text-center">




<div class="row mt-3">

<div class="offset-sm-2 col-sm-8 ">


<hr>




<div class="card">
  <div class="card-header">
    依Account查詢Board
  </div>
  <div class="card-body">
  	
  		
	<form action="${contextRoot}/topGun/board/queryLikeAccountPost" method="get" >
		
		
		
		<div class="mb-3 row">
		    <label for="inputAccount" class="col-sm-2 col-form-label">Account</label>
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











<div class="row my-3">

<div class="offset-sm-3 col-sm-6">



<hr>







<c:if test='${register != null}'>



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
	      <th scope="col">Board</th>
	    </tr>
	    
	    
	    
	  </thead>
	  
	  
	  
	  <tbody>
	  
	  
	  
	    <tr>
	      <td>${register.memberId}</td>
	      <td>${register.account}</td>
	      <td>
	      
<%-- 	      <a href="<c:url value='/topGun/lastNote/queryLikeAccountDetail?fkm=${register.memberId}'  />">查看LastNote</a> --%>
	      
	      <c:choose>
		    <c:when test="${not empty register.boards}">
		        <!-- member 物件存在，顯示登出按鈕 -->
		        <a class="btn btn-warning" type="button" href="<c:url value='/topGun/board/queryLikeAccountDetail?r=${register.memberId}'  />">查看Board</a>
		    </c:when>
		    <c:otherwise>
		        <!-- member 物件不存在，顯示登入按鈕 -->
		        <a class="btn btn-secondary" type="button" href="#">查無此紀錄</a>
		    </c:otherwise>
		</c:choose>
	      
	      </td>
	      
	      
	      
	      
	      
	      
	      
	      
	      
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








</c:if>


















</div>

</div>














<hr>






</div>
</body>
</html>
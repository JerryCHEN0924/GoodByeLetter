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
<title>查看會員註冊資料 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container text-center">



<div class="row mt-5">

<div class="offset-sm-3 col-sm-6">




<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center ">
  
    
    
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/register/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/register/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/register/page?p=${pageNumber }">${pageNumber }</a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item" >
				<a class="page-link active" href="#" >
					${pageNumber }
				</a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
		
		
		</c:forEach>
			
    
    
    <li class="page-item">
    	<c:choose>
    	
			<c:when test="${page.number+1 < page.totalPages}">
			
				<li class="page-item">
					<a class="page-link" href="${contextRoot }/topGun/register/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/register/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    </li>
    
  </ul>
</nav>








</div>
</div>







<hr class="border border-dark border-3 opacity-75">










<div class="row mt-3">

<div class="offset-sm-1 col-sm-10 ">



<div class="card">
  <div class="card-header">
  
  查看會員註冊資料
  
  </div>
  <div class="card-body">
  	
  	<c:forEach var="register" items="${page.content}">
  	
  	<table class="table table table-dark table-striped-columns table-hover">
  	
	  <thead>
	  
	  
	    <tr class="table-primary table-active">
	      <th scope="col">會員編號</th>
	      <th scope="col">帳號</th>
	      <th scope="col">密碼</th>
	      <th scope="col">啟用狀態</th>
	      <th scope="col">註冊時間</th>
	      <th scope="col">權限編號</th>
	      <th scope="col">編輯</th>
	    </tr>
	    
	    
	    
	  </thead>
	  
	  
	  
	  <tbody>
	  
	  
	  
	    <tr>
	      <td>${register.memberId}</td>
	      <td>${register.account}</td>
	      <td>${register.password}</td>
	      <td>${register.enabled}</td>
	      <td>${register.registerTime}</td>
	      <td>${register.FK_Plevel.plevel}</td>
	      <td>
	      	<div class="d-flex justify-content-center">
	      		<div class="mx-1">
		  	<form action="${contextRoot}/topGun/register/edit" method="get" >
				<input type="hidden" name="memberId" value="${register.memberId}" />
				<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
			</form>
				</div>
				<div>
			<form action="${contextRoot}/topGun/register/delete" method="post" >
				<input type="hidden" name="_method" value="delete" />
				<input type="hidden" name="memberId" value="${register.memberId}" />
				<input type="submit" class="btn btn-outline-danger btn-sm" value="刪除" />
			</form>
				</div>
			</div>
	      </td>
	    </tr>
	    
	    
	    
	    
	  </tbody>
	</table>
  	
  	</c:forEach>
  	
  	
  </div>
</div>


</div>
</div>


































</div>
</body>
</html>
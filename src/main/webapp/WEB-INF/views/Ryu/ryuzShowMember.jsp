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
<title>查看會員 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container w-75 text-center">



<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">

<h1>查看會員 Page</h1>



<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center ">
  
    
    
    <li class="page-item">
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/memberByRyu/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/memberByRyu/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    </li>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/memberByRyu/page?p=${pageNumber }">${pageNumber }</a>
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
					<a class="page-link" href="${contextRoot }/topGun/memberByRyu/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/memberByRyu/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    </li>
    
  </ul>
</nav>








</div>
</div>


















<div class="row mt-3">

<div class="offset-sm-1 col-sm-10 ">



<div class="card">
  <div class="card-header">
  
  查看會員 Page
  
  </div>
  <div class="card-body">
  	
  	<c:forEach var="memberByRyu" items="${page.content}">
  	
  	<table class="table">
  	
	  <thead>
	  
	  
	    <tr>
	      <th scope="col">memberId</th>
	      <th scope="col">account</th>
	      <th scope="col">password</th>
	      <th scope="col">registerTime</th>
	      <th scope="col">FK_Plevel</th>
	      <th scope="col">Edit</th>
	    </tr>
	    
	    
	    
	  </thead>
	  
	  
	  
	  <tbody>
	  
	  
	  
	    <tr>
	      <td>${memberByRyu.memberId}</td>
	      <td>${memberByRyu.account}</td>
	      <td>${memberByRyu.password}</td>
	      <td>${memberByRyu.registerTime}</td>
	      <td>${memberByRyu.levelByRyu.pLevel}</td>
	      <td>
	      	<div class="d-flex justify-content-center">
	      		<div class="mx-1">
		  	<form action="${contextRoot}/topGun/memberByRyu/edit" method="get" >
				<input type="hidden" name="memberId" value="${memberByRyu.memberId}" />
				<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
			</form>
				</div>
				<div>
			<form action="${contextRoot}/topGun/memberByRyu/delete" method="post" >
				<input type="hidden" name="_method" value="delete" />
				<input type="hidden" name="memberId" value="${memberByRyu.memberId}" />
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
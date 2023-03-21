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
<title>查詢會員細項資料 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>






<div class="container text-center">



<div class="row">

<div class="offset-sm-3 col-sm-6">



</div>
</div>



<hr class="border border-dark border-3 opacity-75">









<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/memberDetail/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/memberDetail/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/memberDetail/page?p=${pageNumber }">${pageNumber }</a>
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
			
    
    
    	<c:choose>
    	
			<c:when test="${page.number+1 < page.totalPages}">
			
				<li class="page-item">
					<a class="page-link" href="${contextRoot }/topGun/memberDetail/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/memberDetail/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
  </ul>
</nav>
















<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">



<span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span>







<table class="table table-striped table-hover table-bordered border-dark table-success caption-top align-middle">

  <caption class="text-center fs-3 text-white">查詢會員細項資料</caption>
  
	

  <thead class="table-dark">
  
    <tr class="table-active">
      <th scope="col">編號</th>
      <th scope="col">姓名</th>
      <th scope="col">性別</th>
      <th scope="col">生日</th>
      <th scope="col">Email</th>
      <th scope="col">國家</th>
      <th scope="col">地址</th>
      <th scope="col">會員編號</th>
      <th scope="col">權限編號</th>
      <th scope="col">編輯</th>
    </tr>
    
  </thead>
  
  
  
  <tbody class="table-group-divider">
  
  <c:forEach var="memberDetail" items="${page.content}">
    <tr>
      <th scope="row">${memberDetail.id}</th>
      <td>${memberDetail.name}</td>
      <td>${memberDetail.gender}</td>
      <td>${memberDetail.birthday}</td>
      <td>${memberDetail.email}</td>
      <td>${memberDetail.county}</td>
      <td>${memberDetail.address}</td>
      <td>${memberDetail.FK_memberId.memberId}</td>
      <td>${memberDetail.FK_Plevel.plevel}</td>
      <td>
      
      	<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
      		
					<form action="${contextRoot}/topGun/memberDetail/edit" method="get" >
						<input type="hidden" name="id" value="${memberDetail.id}" />
						<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
					</form>
				
			</div>
			
		</div>
      
      </td>
      
    </tr>
    
  </c:forEach>
  
  
    
  </tbody>
  
  
  
  
  
</table>


</div>











<hr class="border border-dark border-3 opacity-75">














</div>
</body>
</html>
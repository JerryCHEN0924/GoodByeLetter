<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看會員 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container w-75">
<h1>查看會員</h1>




<div class="row ">

<div class="offset-sm-3 col-sm-6 ">



<c:forEach var="levelByRyu" items="${page.content}">



<div class="card mt-3">
  <div class="card-header">
    部門階級建立時間： <span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${levelByRyu.createTime}" /></span>
  </div>
  <div class="card-body">
  	
	${levelByRyu.levelName}
  	
  </div>
  
  <div class="edit-place m-2" style="display:flex">
  
	<form action="${contextRoot}/topGun/levelByRyu/edit" method="get" >
		<input type="hidden" name="pLevel" value="${levelByRyu.pLevel}" />
		<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
	</form>
	
	<form action="${contextRoot}/topGun/levelByRyu/delete" method="post" >
		<input type="hidden" name="_method" value="delete" />
		<input type="hidden" name="pLevel" value="${levelByRyu.pLevel}" />
		<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" />
	</form>
	
  </div>
  
  
</div>



</c:forEach>






</div>

</div>












<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center ">
  
    
    
    <li class="page-item">
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/levelByRyu/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/levelByRyu/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    </li>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/levelByRyu/page?p=${pageNumber }">${pageNumber }</a>
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
					<a class="page-link" href="${contextRoot }/topGun/levelByRyu/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/levelByRyu/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    </li>
    
  </ul>
</nav>


















</div>
</body>
</html>
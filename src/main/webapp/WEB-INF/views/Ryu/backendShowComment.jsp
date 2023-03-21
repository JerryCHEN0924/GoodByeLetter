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
<title>查看全部回覆留言 Page</title>
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
  <ul class="pagination justify-content-center ">
  
    
    
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/comment/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/comment/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/comment/page?p=${pageNumber }">${pageNumber }</a>
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
					<a class="page-link" href="${contextRoot }/topGun/comment/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/comment/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
  </ul>
</nav>








<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">



  	<span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span>
<!--   <div> -->
<%--   <form class="d-flex mt-3" action="${contextRoot}/topGun/backendHome/getVendorPhotosByTitleQueryLikePageExecute" method="get" role="search"> --%>
<!--     <input class="form-control  me-2" name="title" type="search" placeholder="請輸入文案標題" aria-label="Search"> -->
<!--     <button class="btn btn-success" type="submit">Search</button> -->
<%--   </form> --%>
<!--   </div> -->
  
  

<table class="table table-striped table-hover table-bordered border-dark table-success caption-top align-middle">

  <caption class="text-center fs-3 text-white">查看全部回覆留言</caption>
  
	

  <thead class="table-dark">
  
    <tr class="table-active">
      <th scope="col">編號</th>
      <th scope="col">回覆內容</th>
      <th scope="col">新增時間</th>
      <th scope="col">更新時間</th>
      <th scope="col">留言編號</th>
      <th scope="col">會員編號</th>
      <th scope="col">編輯</th>
    </tr>
    
  </thead>
  
  
  
  <tbody class="table-group-divider">
  
  <c:forEach var="comment" items="${page.content}">
    <tr>
      <th scope="row">${comment.commentId}</th>
      <td>${comment.reply}</td>
      <td>${comment.createTime}</td>
      <td>${comment.updateTime}</td>
      <td>${comment.board.boardId}</td>
      <td>${comment.register.memberId}</td>
      <td>
      
      	<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
      		
<%--       			<a class="btn btn-outline-success" type="button" href="<c:url value='/topGun/vendorPhotos/put/${vendorPhotos.vendorPhotosId}' />">編輯</a> --%>
      		
				<form action="${contextRoot}/topGun/comment/edit" method="get" >
					<input type="hidden" name="commentId" value="${comment.commentId}" />
					<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
				</form>
				
			</div>
			
			<div class="mx-1">
			
<%-- 				<form:form action="${contextRoot}/topGun/vendorPhotos/delete/${vendorPhotos.vendorPhotosId}" method="post" > --%>
<!-- 				<input type="hidden" name="_method" value="delete" /> -->
<!-- 				<input type="submit" class="btn btn-outline-warning btn-sm" value="刪除" /> -->
<%-- 				</form:form> --%>
			
				<form action="${contextRoot}/topGun/comment/delete" method="post" >
				<input type="hidden" name="_method" value="delete" />
					<input type="hidden" name="commentId" value="${comment.commentId}" />
					<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" />
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
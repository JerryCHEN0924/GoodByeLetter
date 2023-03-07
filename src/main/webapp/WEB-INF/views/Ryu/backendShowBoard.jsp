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




<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center ">
  
    
    
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/board/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/board/page?p=${page.number - 0}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/board/page?p=${pageNumber }">${pageNumber }</a>
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
					<a class="page-link" href="${contextRoot }/topGun/board/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/board/page?p=${page.number + 2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
  </ul>
</nav>






</div>

</div>





<hr>






<div class="row mt-3">

<div class="offset-sm-1 col-sm-10 ">



<div class="card">
  <div class="card-header">
  
  查看留言訊息
  
  </div>
  <div class="card-body">
  	
  	<c:forEach var="board" items="${page.content}">
  	
  	<table class="table table-dark table-striped-columns table-hover">
  	
	  <thead>
	  
	  
	    <tr class="table-secondary table-active">
	      <th scope="col">boardId</th>
	      <th scope="col">title</th>
	      <th scope="col">boardMessage</th>
	      <th scope="col">createTime</th>
	      <th scope="col">updateTime</th>
	      <th scope="col">FK_memberId</th>
	      <th scope="col">Edit</th>
	    </tr>
	    
	    
	    
	  </thead>
	  
	  
	  
	  <tbody>
	  
	  
	  
	    <tr>
	      <td>${board.boardId}</td>
	      <td>${board.title}</td>
	      <td>${board.boardMessage}</td>
	      <td>${board.createTime}</td>
	      <td>${board.updateTime}</td>
	      <td>${board.register.memberId}</td>
	      <td>
	      	<div class="d-flex justify-content-center">
	      		<div class="mx-1">
		  	<form action="${contextRoot}/topGun/board/edit" method="get" >
				<input type="hidden" name="boardId" value="${board.boardId}" />
				<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
			</form>
				</div>
				<div>
			<form action="${contextRoot}/topGun/board/delete" method="post" >
				<input type="hidden" name="_method" value="delete" />
				<input type="hidden" name="boardId" value="${board.boardId}" />
				<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" />
			</form>
				</div>
				<div>
			<form action="${contextRoot}/topGun/comment/add" method="get" >
				<input type="hidden" name="boardId" value="${board.boardId}" />
				<input type="submit" class="btn btn-outline-info btn-sm ms-2" value="回覆" />
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










<div>

<hr>

</div>









<div class="row ">

<div class="offset-sm-2 col-sm-8 ">



<c:forEach var="board" items="${page.content}">



<div class="card mt-3">
  <div class="card-header">
    留言發布時間： <span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${board.createTime}" /></span>
    <br>
  </div>
  <div class="card-body">
  	
	${board.boardMessage}
  	
  </div>
  
  <div class="edit-place m-2" style="display:flex">
  
	<form action="${contextRoot}/topGun/board/edit" method="get" >
		<input type="hidden" name="boardId" value="${board.boardId}" />
		<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
	</form>
	
	<form action="${contextRoot}/topGun/board/delete" method="post" >
		<input type="hidden" name="_method" value="delete" />
		<input type="hidden" name="boardId" value="${board.boardId}" />
		<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" />
	</form>
	<div>
			<form action="${contextRoot}/topGun/comment/add" method="get" >
				<input type="hidden" name="boardId" value="${board.boardId}" />
				<input type="submit" class="btn btn-outline-info btn-sm ms-2" value="回覆" />
			</form>
	</div>
	
  </div>
  
  
</div>



</c:forEach>






</div>

</div>


























</div>
</body>
</html>
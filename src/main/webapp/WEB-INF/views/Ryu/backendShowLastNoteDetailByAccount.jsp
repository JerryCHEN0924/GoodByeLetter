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
<title>查詢信件紀錄 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container w-75 text-center">

<div class="row mt-5">

<div class="offset-sm-2 col-sm-8 ">

<div>
	<a class="btn btn-danger" type="button" href="<c:url value='/topGun/lastNote/queryLikeAccount'  />">返回上一頁</a>
</div>

</div>
</div>


<div class="row my-3">

<div class="offset-sm-2 col-sm-8 ">


<hr>


<c:forEach var="lastNoteDetail" items="${lastNoteDetail}">



<div class="card mt-3">
  <div class="card-header">
    信件建立時間： <span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${lastNoteDetail.createTime}" /></span>
    <br>
  </div>
  <div class="card-body">
  	
	${lastNoteDetail.notedetail}
  	
  </div>
  
  
  
  
<!--   <div class="edit-place m-2" style="display:flex"> -->
  
<%-- 	<form action="${contextRoot}/topGun/board/edit" method="get" > --%>
<%-- 		<input type="hidden" name="boardId" value="${board.boardId}" /> --%>
<!-- 		<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" /> -->
<%-- 	</form> --%>
	
<%-- 	<form action="${contextRoot}/topGun/board/delete" method="post" > --%>
<!-- 		<input type="hidden" name="_method" value="delete" /> -->
<%-- 		<input type="hidden" name="boardId" value="${board.boardId}" /> --%>
<!-- 		<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" /> -->
<%-- 	</form> --%>
<!-- 	<div> -->
<%-- 			<form action="${contextRoot}/topGun/comment/add" method="get" > --%>
<%-- 				<input type="hidden" name="boardId" value="${board.boardId}" /> --%>
<!-- 				<input type="submit" class="btn btn-outline-info btn-sm ms-2" value="回覆" /> -->
<%-- 			</form> --%>
<!-- 	</div> -->
	
<!--   </div> -->
  
  
  
  
  
</div>



</c:forEach>






</div>

</div>









<hr>








</div>
</body>
</html>
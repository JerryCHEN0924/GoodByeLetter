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
<title>查詢留言紀錄 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container text-center">



<div class="row">

<div class="offset-sm-3 col-sm-6">

<%-- <c:choose> --%>
<%--     <c:when test="${not empty authenticated}"> --%>
<!--         member 物件存在，顯示登出按鈕 -->
<%--         <a class="btn btn-outline-primary" type="button" href="${contextRoot}/topGun/memberByRyu/LogoutProcess">${authenticated.account} 登出</a> --%>
<%--     </c:when> --%>
<%--     <c:otherwise> --%>
<!--         member 物件不存在，顯示登入按鈕 -->
<%--         <a class="btn btn-outline-primary" type="button" href="${contextRoot}/topGun/memberByRyu/login">${authenticated.account} 登入</a> --%>
<%--     </c:otherwise> --%>
<%-- </c:choose> --%>

</div>
</div>  





<hr class="border border-dark border-3 opacity-75">











<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">



  	<span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span>
<!--   <div> -->
<%--   <form class="d-flex mt-3" action="${contextRoot}/topGun/backendHome/getVendorPhotosByTitleQueryLikePageExecute" method="get" role="search"> --%>
<!--     <input class="form-control  me-2" name="title" type="search" placeholder="請輸入文案標題" aria-label="Search"> -->
<!--     <button class="btn btn-success" type="submit">Search</button> -->
<%--   </form> --%>
<!--   </div> -->
  
  

<table class="table table-striped table-hover table-bordered border-dark table-success caption-top align-middle">

  <caption class="text-center fs-3 text-white">會員留言紀錄</caption>
  
	

  <thead class="table-dark">
  
    <tr class="table-active">
      <th scope="col">編號</th>
      <th scope="col">標題</th>
      <th scope="col">內容</th>
      <th scope="col">新增時間</th>
      <th scope="col">更新時間</th>
      <th scope="col">會員編號</th>
      <th scope="col">回覆紀錄</th>
      <th scope="col">編輯</th>
    </tr>
    
  </thead>
  
  
  
  <tbody class="table-group-divider">
  
  <c:forEach var="board" items="${boardDetail}">
    <tr>
      <th scope="row">${board.boardId}</th>
      <td>${board.title}</td>
      <td>${board.boardMessage}</td>
      <td>${board.createTime}</td>
      <td>${board.updateTime}</td>
      <td>${board.register.memberId}</td>
      <td>
      <div class="d-flex justify-content-center">
	      <div class="mx-1">
		      <c:choose>
				    <c:when test="${not empty board.comments}">
				        <!-- member 物件存在，顯示登出按鈕 -->
				        <a class="btn btn-warning" type="button" href="<c:url value='/topGun/comment/queryLikeAccountDetail?b=${board.boardId}'  />">查看回覆留言</a>
				    </c:when>
				    <c:otherwise>
				        <!-- member 物件不存在，顯示登入按鈕 -->
				        <a class="btn btn-secondary" type="button" href="#">查無回復紀錄</a>
				    </c:otherwise>
				</c:choose>
			</div>
      </div>
      </td>
      <td>
      
      	<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
      		
	      		<form action="${contextRoot}/topGun/board/editByAccount" method="get" >
					<input type="hidden" name="boardId" value="${board.boardId}" />
					<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
				</form>
				
			</div>
			
			<div class="mx-1">
			
				<form action="${contextRoot}/topGun/board/deleteByAccount" method="post" >
					<input type="hidden" name="_method" value="delete" />
					<input type="hidden" name="boardId" value="${board.boardId}" />
					<input type="submit" class="btn btn-outline-danger btn-sm ms-2" value="刪除" />
				</form>
			
			</div>
			
		</div>
      
      </td>
      
    </tr>
    
  </c:forEach>
  
  </tbody>
  
</table>








<div class="row my-5">
		
			<div class="offset-sm-5 col-sm-2">
		
				<form action="${contextRoot}/topGun/board/queryLikeAccount" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="返回查詢留言" />
				</form>
		
			</div>
			
  		</div>







</div>











<hr class="border border-dark border-3 opacity-75">












</div>
</body>
</html>
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
<title>依帳號查詢留言 Page</title>
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
  <div>
  <form class="d-flex mt-3" action="${contextRoot}/topGun/board/queryLikeAccountPost" method="get" role="search">
    <input class="form-control  me-2" name="account" type="search" placeholder="請輸入會員帳號" aria-label="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
  </div>

<table class="table table-striped table-hover table-bordered border-dark table-success caption-top align-middle">

  <caption class="text-center fs-3 text-white">依帳號查詢留言</caption>
  
	

  <thead class="table-dark">
  
    <tr class="table-active">
      <th scope="col">會員編號</th>
      <th scope="col">帳號</th>
      <th scope="col">權限等級</th>
      <th scope="col">註冊時間</th>
      <th scope="col">留言紀錄</th>
    </tr>
    
  </thead>
  
  
  
  <tbody class="table-group-divider">
  
  <c:forEach var="register" items="${register}">
    <tr>
      <th scope="row">${register.memberId}</th>
      <td>${register.account}</td>
      <td>${register.FK_Plevel.plevel}</td>
      <td>${register.registerTime}</td>
      <td>
      
      
      	<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
      		
	  	     <c:choose>
			    <c:when test="${not empty register.boards}">
			        <!-- member 物件存在，顯示登出按鈕 -->
			        <a class="btn btn-warning" type="button" href="<c:url value='/topGun/board/queryLikeAccountDetail?r=${register.memberId}'  />">查看留言紀錄</a>
			    </c:when>
			    <c:otherwise>
			        <!-- member 物件不存在，顯示登入按鈕 -->
			        <a class="btn btn-secondary" type="button" href="#">查無此紀錄</a>
			    </c:otherwise>
			</c:choose>
	      
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
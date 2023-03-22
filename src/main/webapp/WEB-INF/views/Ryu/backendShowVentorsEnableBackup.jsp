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
<title>GoodBye Letter 後臺管理介面</title>

  


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



<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center ">
  
    
    
    	<c:choose>
    	
			<c:when test="${page.number > 0}">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute?page=${page.number - 0}&account=${param.account}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute?page=${page.number - 0}&account=${param.account}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    
    
		
		
		<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

		<c:choose>
		
			
			<c:when test="${page.number+1 != pageNumber }">
			
				<li class="page-item">
				<a class="page-link" href="${contextRoot }/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute?page=${pageNumber }&account=${param.account}">${pageNumber }</a>
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
					<a class="page-link" href="${contextRoot }/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute?page=${page.number + 2}&account=${param.account}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
				
			</c:when>
			
			<c:otherwise>
			
			<li class="page-item disabled">
				<a class="page-link" href="${contextRoot }/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute?page=${page.number + 2}&account=${param.account}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			</li>
			
			</c:otherwise>
		
		</c:choose>
    </li>
    
  </ul>
</nav>






<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">
  	<span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span>
  <div>
  <form class="d-flex mt-3" action="${contextRoot}/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute" method="get" role="search">
    <input class="form-control  me-2" name="account" type="search" placeholder="請輸入廣告商帳號" aria-label="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
  </div>

<table class="table table-striped table-hover table-bordered border-dark table-success caption-top align-middle">

  <caption class="text-center fs-3 text-white">審核廣告商投放權限</caption>
  
	

  <thead class="table-dark">
  
    <tr class="table-active">
      <th scope="col">編號</th>
      <th scope="col">帳號</th>
      <th scope="col">密碼</th>
<!--       <th scope="col">文案圖片</th> -->
      <th scope="col">編輯</th>
    </tr>
    
  </thead>
  
  
  
  <tbody class="table-group-divider">
  
  <c:forEach var="register" items="${page.content}">
    <tr>
      <th scope="row">${register.memberId}</th>
      <td>${register.account}</td>
      <td>${register.password}</td>
<%--       <td><img width='200' height='200' src="<c:url value='/topGun/vendorPhotos/picture/${vendorPhotos.vendorPhotosId}' />" /></td> --%>
      <td>
      
      
      	<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
	  	    
	<%-- 	      <a href="<c:url value='/topGun/lastNote/queryLikeAccountDetail?fkm=${register.memberId}'  />">查看LastNote</a> --%>
		      
		      <c:choose>
			    <c:when test="${register.enabled}">
	<%-- 		    <c:when test="${not empty register.enable}"> --%>
			        <!-- member 物件存在，顯示登出按鈕 -->
			        <a class="btn btn-warning" type="button" href="<c:url value='/topGun/vendorDetailsBackup/enableEdit?memberId=${register.memberId}'  />">True</a>
			    </c:when>
			    <c:otherwise>
			        <!-- member 物件不存在，顯示登入按鈕 -->
			        <a class="btn btn-secondary" type="button" href="<c:url value='/topGun/vendorDetailsBackup/enableEdit?memberId=${register.memberId}'  />">False</a>
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
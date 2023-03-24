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
<title>查看廠商文案資料 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container text-center">




<div class="row">

<div class="offset-sm-3 col-sm-6">


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

  <caption class="text-center fs-3 text-white">搜尋廣告文案</caption>
  
	

  <thead class="table-dark">
  
    <tr class="table-active">
      <th scope="col">文案編號</th>
<!--       <th scope="col">文案標題</th> -->
<!--       <th scope="col">文案描述</th> -->
      <th scope="col">審核狀態</th>
<!--       <th scope="col">廣告商名稱</th> -->
<!--       <th scope="col">建立時間</th> -->
      <th scope="col">文案圖片</th>
      <th scope="col">編輯</th>
    </tr>
    
  </thead>
  
  
  
  <tbody class="table-group-divider">
  
  <c:forEach var="vendorPhotos" items="${vendorPhotos}">
    <tr>
      <th scope="row">${vendorPhotos.id}</th>
<%--       <td>${vendorPhotos.title}</td> --%>
<%--       <td>${vendorPhotos.description}</td> --%>
<%--       <td>${vendorPhotos.enabled}</td> --%>
      <td>${vendorPhotos.enable}</td>
<%--       <td>${vendorPhotos.vendorDetails.companyName}</td> --%>
<%--       <td>${vendorPhotos.createTime}</td> --%>

<%--       <td><img width='200' height='200' src="<c:url value='/topGun/vendorPhotosBackup/picture/${vendorPhotos.id}' />" /></td> --%>
      
      <td><img width='200' height='200' src="<c:url value='/topGun/vendorPhotosBackup/image?id=${vendorPhotos.id}' />" /></td>
      
      <td>
      
      	<div class="d-flex justify-content-center">
      	
      		<div class="mx-1">
      		
<%--       			<a class="btn btn-outline-success" type="button" href="<c:url value='/topGun/vendorPhotos/put/${vendorPhotos.vendorPhotosId}' />">編輯</a> --%>
      		
				<form:form action="${contextRoot}/topGun/vendorPhotosBackup/put2/${vendorPhotos.id}" method="get" >
					<input type="submit" class="btn btn-outline-info btn-sm" value="編輯" />
				</form:form>
				
			</div>
			
			<div class="mx-1">
			
<%-- 				<form:form action="${contextRoot}/topGun/vendorPhotos/delete/${vendorPhotos.vendorPhotosId}" method="post" > --%>
<!-- 				<input type="hidden" name="_method" value="delete" /> -->
<!-- 				<input type="submit" class="btn btn-outline-warning btn-sm" value="刪除" /> -->
<%-- 				</form:form> --%>
			
				<form:form action="${contextRoot}/topGun/vendorPhotosBackup/delete2/${vendorPhotos.id}" method="delete" >
				<input type="submit" class="btn btn-outline-danger btn-sm" value="刪除" />
				</form:form>
			
			</div>
			
		</div>
      
      </td>
      
      
      
      
      
    </tr>
    
  </c:forEach>
  
  
    
  </tbody>
  
  
  
  
  
</table>







<div class="row my-5">
		
			<div class="offset-sm-5 col-sm-2">
		
				<form action="${contextRoot}/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="回審核廣告商權限頁面" />
				</form>
		
			</div>
			
  		</div>







</div>












<hr class="border border-dark border-3 opacity-75">







</div>
</body>
</html>
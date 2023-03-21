<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<c:set var="contextUser" value="${pageContext.request.userPrincipal}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>輪播圖預覽</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<!-- <div class="container w-75 text-center my-5"> -->



<!-- <div class="row border bg-light text-dark"> -->
<!-- <div class="offset-sm-3 col-sm-6 p-3"> -->
<!-- <h2>你看不見！你看不見！！你看不見！！！</h2> -->
<!-- <hr class="border border-dark border-3 opacity-75"> -->
<!-- </div> -->
<!-- </div> -->


<!-- <hr class="border border-dark border-3 opacity-75"> -->






<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">



  <div class="carousel-inner">
  
  
  
    <div class="carousel-item active">
<!--       <img src="..." class="d-block w-100" alt="..."> -->
      <img class="d-block w-100" src="<c:url value='/topGun/vendorPhotos/picture/${allVendorPhotosByEnabledTrue[0].vendorPhotosId}' />" />
    </div>
    
    
    <c:forEach var="vendorPhotos" items="${allVendorPhotosByEnabledTrue}">
    
    <div class="carousel-item">
<!--       <img src="..." class="d-block w-100" alt="..."> -->
      <img class="d-block w-100" src="<c:url value='/topGun/vendorPhotos/picture/${vendorPhotos.vendorPhotosId}' />" />
    </div>
    
    </c:forEach>
    
    
    
    
    
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
  
  
  
</div>

























<!-- </div> -->
</body>
</html>
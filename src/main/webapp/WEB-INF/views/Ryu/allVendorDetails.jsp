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
<title>查看廠商細項資料 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>




<div class="container text-center">






<div class="row mt-3">

<div class="offset-sm-3 col-sm-6">


<div class="container" style="text-align: center" >


</div>

<div align='center'>
        <a class="btn btn-warning" type="button" href="<c:url value='/topGun' />">回首頁</a>
</div> 


</div>
</div>




<hr class="border border-dark border-3 opacity-75">




<div class="row row-cols-1 row-cols-md-3 g-4">


<c:forEach var="VendorDetails" items="${allVendorDetails}">









  <div class="col">
    <div class="card h-100">
    
<!--       <img src="..." class="card-img-top" alt="..."> -->
      <img src="<c:url value='/topGun/vendorDetails/picture/${VendorDetails.vendorDetailsId}' />" class="card-img-top" alt="...">
      
      <div class="card-body">
      
        <h5 class="card-title">公司名： ${VendorDetails.companyName}</h5>
        
        <p class="card-text">分類： ${VendorDetails.companyType}</p>
        <p class="card-text">信箱： ${VendorDetails.email}</p>
        <p class="card-text">地址： ${VendorDetails.address}</p>
        <p class="card-text">編號： ${VendorDetails.register.memberId}</p>
        <p class="card-text">權限： ${VendorDetails.level.plevel}</p>
        
      </div>
      
      
      <div class="card-footer">
      
        <small class="text-muted">建立時間： ${VendorDetails.createTime}</small>
        
      </div>
      
      
    </div>
  </div>
  
  

                    
<!--                     <p> -->
<%--                     <a href="<spring:url value='/product?id=${product.bookId}' />" --%>
<!-- 		    class="btn btn-primary"> -->
<!-- 		    <span class="glyphicon-info-sigh glyphicon"></span>詳細資料 -->
<!-- 		</a> -->
<%-- 		<a href="<spring:url value='/productPV/${product.bookId}' />" --%>
<!-- 		    class="btn btn-primary"> -->
<!-- 		    <span class="glyphicon-info-sigh glyphicon"></span>詳細資料(路徑變數) -->
<!-- 		</a> -->
<!--                     </p> -->

		</c:forEach>
            
</div>
        







<div class="btn btn-warning my-3" align='center'>
    <a class="btn btn-warning" type="button" href="<c:url value='/topGun' />">回首頁</a>
</div> 





<hr class="border border-dark border-3 opacity-75">







</div>
</body>
</html>
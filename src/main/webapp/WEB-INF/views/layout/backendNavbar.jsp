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

<link href="${contextRoot}/css/ryuzStyle01.css" rel="stylesheet" />

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />

<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>







<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>

<!-- <link -->
<!-- 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" -->
<!-- 	rel="stylesheet" -->
<!-- 	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" -->
<!-- 	crossorigin="anonymous"> -->
	
<!-- <script -->
<!-- 	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" -->
<!-- 	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" -->
<!-- 	crossorigin="anonymous"></script> -->









</head>
<body>






<nav class="navbar navbar-dark bg-dark"  >

  <div class="container-fluid">
  
  
  
  
  	<div class="d-flex flex-row mb-3">
  
  
  	<div class="p-2">
	   	<c:choose>
		    <c:when test="${not empty contextUser}">
		        <!-- member 物件存在，顯示登出按鈕 -->
		        <a class="btn btn-outline-primary" type="button" href="<c:url value='/logout' />">${contextUser.authorities} ${contextUser.name} 登出</a>
		    </c:when>
		    <c:otherwise>
		        <!-- member 物件不存在，顯示登入按鈕 -->
		        <a class="btn btn-outline-success" type="button" href="<c:url value='/login' />">${contextUser.authorities} ${contextUser.name} 登入</a>
		    </c:otherwise>
		</c:choose>
	</div>
	
	
	
	
  	
  
  
<!--     <div> -->
<%--     	<c:choose> --%>
<%-- 		    <c:when test="${not empty existing}"> --%>
<!-- 		        member 物件存在，顯示登出按鈕 -->
<%-- 		        <a class="btn btn-warning" type="button" href="${contextRoot}/topGun/">${existing.account} 登出</a> --%>
<%-- 		    </c:when> --%>
<%-- 		    <c:otherwise> --%>
<!-- 		        member 物件不存在，顯示登入按鈕 -->
<%-- 		        <a class="btn btn-secondary" type="button" href="${contextRoot}/topGun">${existing.account} 登入</a> --%>
<%-- 		    </c:otherwise> --%>
<%-- 		</c:choose> --%>
<!--     </div> -->



	<div class="p-2">
  
    <a class="navbar-brand fs-2 fw-bolder position-absolute top-50 start-50 translate-middle" href="${contextRoot}/topGun/backendHome">後臺管理介面</a>
    
    </div>
    
    </div>
    
    
    
    
    
    
    
    
    
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    
    
    
    
    <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
    
      <div class="offcanvas-header">
      
        <h5 class="offcanvas-title fs-2 fw-bolder" id="offcanvasDarkNavbarLabel">後臺管理選單</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        
      </div>
      
      <div class="offcanvas-body">
      
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
        
          <li class="nav-item">
            <a class="nav-link active fs-2 fw-bolder" aria-current="page" href="${contextRoot}/">Home</a>
          </li>
          
          
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/topGun/register/queryLikeAccount' />">審核會員啟用狀態</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute' />">審核廣告商投放啟用狀態</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/topGun/board/queryLikeAccount' />">查詢及編輯會員留言</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/topGun/lastNote/queryLikeAccount' />">查詢及編輯會員GoodBye Letter</a>
          </li>
          
          
          
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              管理權限等級
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/level/add' />">新增權限等級</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/level/page' />">查詢和編輯權限等級</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
            </ul>
            
          </li>
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              管理會員註冊
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/register/add' />">新增註冊會員</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/register/page' />">查詢和編輯會員資料</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/memberDetail/add' />">新增一般會員細項資料</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/memberDetail/page' />">查詢和編輯一般會員細項資料</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorDetails/add' />">新增廣告商細項資料</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorDetails/page' />">查詢和編輯廣告商細項資料</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
            </ul>
            
          </li>
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              廣告商文案管理
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotos/add' />">新增廠商文案資料</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotos/page' />">查看和編輯廠商文案資料</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
            </ul>
            
          </li>
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              模擬會員新增留言(登入帳號)
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/board/add' />">登入會員帳號後新增留言</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/board/page' />">查詢和編輯留言、新增回覆留言</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/comment/page' />">查詢和編輯全部回復留言</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
            </ul>
            
          </li>
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              模擬新增LastNote(登入帳號)
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/lastNote/add' />">新增 GoodBye Letter</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/lastNote/page' />">查詢和編輯 GoodBye Letter</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
            </ul>
            
          </li>
          
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              廠商管理(新版)
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/backendHome/getVendorPhotosQuery' />">搜尋廣告文案(By Title)</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorDetails' />">查詢全部廠商細項資料(新版)</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotos' />">查詢全部廠商文案資料(新版)</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/backendHome/money' />">廣告文案預覽(For審核狀態True)</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
            </ul>
            
          </li>
          
          
          
          
          
          
          
          
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              廣告商文案(上機演示版)
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotosBackup/add' />">新增廣告圖片</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotosBackup/page' />">查詢編輯廣告商圖片</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotosBackup/page' />">查詢編輯廣告商圖片</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute' />">編輯廣告文案啟用狀態</a></li>
            </ul>
            
          </li>
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              新增廣告商細項資料(上機演示版)
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorDetailsBackup/add' />">>新增廣告商細項資料</a></li>
              <li><a class="dropdown-item" href="<c:url value='/topGun/vendorPhotosBackup/page' />">查詢編輯廣告商細項資料</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Nothing else here</a></li>
            </ul>
            
          </li>
          
          
          
          
          
        </ul>
        
        <hr>
        
        <c:choose>
		    <c:when test="${not empty existing}">
		        <!-- member 物件存在，顯示登出按鈕 -->
		        <a class="btn btn-warning" type="button" href="${contextRoot}/topGun/register/LogoutProcessImitation">${existing.account} 會員登出(模擬)</a>
		    </c:when>
		    <c:otherwise>
		        <!-- member 物件不存在，顯示登入按鈕 -->
		        <a class="btn btn-secondary" type="button" href="${contextRoot}/topGun/register/addLoginFormImitation">${existing.account} 會員登入(模擬)</a>
		    </c:otherwise>
		</c:choose>
		
        
        
        
        
        
      </div>
    </div>
  </div>
</nav>









































<script src="https://unpkg.com/axios@1.1.2/dist/axios.min.js"></script>
<script src="${contextRoot}/js/jquery-3.6.3.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${contextRoot}/css/ryuzStyle01.css" rel="stylesheet" />

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />

<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>









</head>
<body>






<nav class="navbar navbar-dark bg-primary"  >

  <div class="container-fluid">
  
  
  
    <a class="navbar-brand" href="${contextRoot}/topGun">後臺管理介面</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    
    
    <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
    
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">後臺管理選單</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      
      <div class="offcanvas-body">
      
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
        
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${contextRoot}/topGun">Home</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="${contextRoot}/topGun/memberByRyu/add">新增會員</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="${contextRoot}/topGun/levelByRyu/add">新增等級</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="${contextRoot}/topGun/memberByRyu/page">查看會員</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="${contextRoot}/topGun/levelByRyu/page">查看等級</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          
          
          
          
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              一般會員
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
            
          </li>
          
          
          
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              廣告商
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
            
          </li>
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              超級管理員
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
            
          </li>
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              超級管理員
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
            
          </li>
          
          
          
          <li class="nav-item dropdown">
          
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              超級管理員
            </a>
            
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
            
          </li>
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
        </ul>
        
        
        
        <form class="d-flex mt-3" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-success" type="submit">Search</button>
        </form>
        
        
        
      </div>
    </div>
  </div>
</nav>









































<script src="https://unpkg.com/axios@1.1.2/dist/axios.min.js"></script>
<script src="${contextRoot}/js/jquery-3.6.3.min.js"></script>
</body>
</html>
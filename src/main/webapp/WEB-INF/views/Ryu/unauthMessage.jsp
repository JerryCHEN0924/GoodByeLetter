<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>沒有訪問權限 Page</title>


<link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet" />

<script src="<c:url value='/js/bootstrap.bundle.min.js' />"></script>



</head>

<body>



<div class="container w-75 text-center">





<div class="row my-5 ">



<div class="offset-sm-3 col-sm-6 my-3">







<div class="card my-5">

  <div class="card-header">
    Security Message
  </div>
  
  <div class="card-body">
  	
  	<h1>沒有訪問權限！！！</h1>
  	
  </div>
  
  
  <div>
  
	  <h1><a class="btn btn-outline-primary" type="button" href="<c:url value='/' />">回首頁</a></h1>
	  
  </div>
  
  
</div>










</div>



</div>













</div>



</body>
</html>
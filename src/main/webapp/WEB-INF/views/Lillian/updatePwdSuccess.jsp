<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/mymain.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>  
</head>

<body>
<%@ include file="../layout/mynav.jsp"%>

        <!--login  login_form_class-->
        <article  class="wrapper style2" style="height:100vh">
        <div class="container-fluid" id="login_form">
            <form id="login" action="${contextRoot}/forgetpwd/updatePwdSuccess"  method="get">
            <h1>成功更新</h1>
               
            </form>

        </div>
        </article>

    

<!-- Scripts -->
	
    
</body>
</html>
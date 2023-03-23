<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>廠商登入頁面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
<style>
	.error {
	  color: red;
	}
  </style>
</head>

<body>


<%@ include file="../layout/mynav.jsp"%>
	
        <!--login  login_form_class-->
    <article class="wrapper style2" style="height:100vh">
        <div class="container-fluid">
			<div class="container" id="form_container">
				<div>廠商登入頁面</div>
            	<form id="login_form" action="${contextRoot}/customer/login" method="post">
					<div class="mb-6 row">
						<label for="account" class="col-sm-2 col-form-label">帳號</label>
						<div class="col-sm-10">
							<input required class="form-control" id="account" type="text" placeholder="請輸入您的帳號" name="account">
						</div>	
					</div>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<input required class="form-control" id="password" type="text" placeholder="請輸入您的密碼" name="password">
						</div>
					</div>
                	<button type="submit" id="login_submit">登入</button>      
            	</form>
				<c:if test="${not empty errorMessage}">
					<div class="error">${errorMessage}</div>
				</c:if>
			
			</div>
        </div>
    </article>



	<!--nav close-->

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.3.min.js"></script>

</body>
</html>
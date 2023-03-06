<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊帳號</title>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/mymain.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<style>
</style>

</head>

<body>
	<%@ include file="../layout/mynav.jsp"%>

	<!-- regis -->
	<article id="" class="wrapper style2">
		<div class="container-fluid " id="register">
			<div id="space"></div>


			<div class="container" id="form_container">
				<div id="registerTitle">註冊會員</div>
				<form:form id="register_form" action="${contextRoot}/register/add" modelAttribute="errors" method="post">
					
					<div class="mb-6 row">
						<label for="account" class="col-sm-2 col-form-label">帳號</label>
						<div class="col-sm-10">
							<form:input type="text" path="account" placeholder="account" class="form-control"
								id="account" name="account" value="${errors.account}" />
						</div>
					</div>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<form:input type="password" path="password" placeholder="password(密碼長度需大於 5 小於 12)"
								class="form-control" id="password" name="password" value="${errors.password}"/>
								<div class="messages"></div>
      					
						</div>
					</div>
					<div class="mb-6 row">
						<label for="confirm-password" class="col-sm-2 col-form-label">確認密碼</label>
						<div class="col-sm-10">
							<form:input id="confirm-password" path="password" class="form-control" type="password"
								placeholder="Confirm password" name="confirmPassword" value="${errors.password}"/>
							<div class="messages"></div>
						</div>
					</div>
					<button type="submit">下一步</button>
					<br> <a href="">已有會員</a><br>

				</form:form>
			</div>
		</div>
	</article>



	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.3.min.js"></script>
	<script src="assets/js/main.js"></script>


	<script>
	var passwordInput = document.getElementById('password');
	var confirmPasswordInput = document.getElementById('confirm-password');

	confirmPasswordInput.addEventListener('input', function () {
	    var password = passwordInput.value;
	    var confirmPassword = confirmPasswordInput.value;

	    if (password !== confirmPassword) {
	        confirmPasswordInput.setCustomValidity('確認密碼不一致');
	    } else {
	        confirmPasswordInput.setCustomValidity('');
	    }
	});

	
	</script>

</body>
</html>
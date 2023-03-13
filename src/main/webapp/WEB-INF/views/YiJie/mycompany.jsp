<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>廠商註冊1</title>
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
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
<style>
</style>

</head>

<body>
	<%@ include file="../layout/mynav.jsp"%>

  	<article id="" class="wrapper style2">
		<div class="container-fluid " id="registerCus">
			<div id="space"></div>


			<div class="container" id="form_container">
				<div id="registerTitle">註冊會員</div>
				<form id="register_form" action="${contextRoot}/customer" method="post">
					<div class="mb-6 row">
						<label for="account" class="col-sm-2 col-form-label">帳號</label>
						<div class="col-sm-10">
							<input required type="text" class="form-control" id="account"
								name="account">
						</div>
					</div>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<input required type="password" class="form-control" id="password"
								name="password">
						</div>
					</div>
<!-- 	驗證			 -->
					<div class="mb-6 row">
						<label for="verificationCode" class="col-sm-2 col-form-label">驗證碼</label>
						<div class="col-sm-10">
							<input required type="text" class="form-control" id="rCode"
								name="rCode">
						</div>
					</div>
<!-- 	驗證			 -->				
					<button type="submit">下一步</button>
					<br> <a href="">已有會員</a><br>

				</form>
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
		
	</script>

</body>
</html>
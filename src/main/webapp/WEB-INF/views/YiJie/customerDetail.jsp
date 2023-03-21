<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>廠商註冊基本資料</title>
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
		<div class="container-fluid " id="addDetail">
			<div id="space"></div>

			<div class="container" id="form_container">
				<div id="customer_Table">填寫資料</div>
				<form id="customer_form" class="form-control" action="${contextRoot}/customerDetail/add2" method="post">

					<!-- regis -->
					<div class="mb-3 row">
						<label for="name" class="col-sm-2 col-form-label">公司名稱</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name">
						</div>
					</div>
					<!-- 
					<div class="mb-3 row">
						<label for="type" class="col-sm-2 col-form-label">公司種類</label>
						<div class="col-sm-10">
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="type"
									id="lawyerRadio" value="lawyer">
								<label class="form-check-label" for="lawyerRadio"> 律師 </label>
							</div>
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="type"
									id="morticianRadio" value="mortician"> <label
									class="form-check-label" for="morticianRadio"> 禮儀社 </label>
							</div>
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="type"
									id="counselingRadio" value="counseling"> <label
									class="form-check-label" for="counselingRadio"> 諮商師 </label>
							</div>
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="type"
									id="otherRadio" value="other"> <label
									class="form-check-label" for="otherRadio"> 其他 </label>
							</div>
						</div>
					</div>
					 -->
					<div class="mb-3 row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email" name="email">
						</div>
					</div>

					<div class="mb-3 row">
						<label for="address" class="col-sm-2 col-form-label">地址</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="address"
								name="address" placeholder="請填入完整地址">
						</div>
					</div>
					 
					<button type="submit">送出</button>
					<br>
					<a href="/companylogig/page">返回</a>
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
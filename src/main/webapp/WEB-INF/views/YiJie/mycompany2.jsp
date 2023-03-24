<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>測試用</title>
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
				<form id="register_form" action="${contextRoot}/customer/registeradd2" method="post" modelAttribute="inputCheck">
					<p id="" style="color: red">${errors.message}</p>
					<div class="mb-6 row">
						<label for="account" class="col-sm-2 col-form-label">帳號</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="account"
								name="account">
						</div>
					</div>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password">
						</div>
					</div>
<!-- 	驗證			 -->
					<div class="mb-6 row">
						<label for="verificationCode" class="col-sm-2 col-form-label">驗證碼</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="rCode"
								name="rCode">
						</div>
					</div>
<!-- 	驗證			 -->				
					<button type="submit">下一步</button>

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
		window.onload = function () {
			var p = document.querySelectorAll("p");
			p.addEventListener("change", checkDuplicate);//物件內容改變時觸發checkDuplicate
			function checkDuplicate() {
				if (p == "請輸入您的帳號!") {

					setTimeout(function () {
						document.getElementById("acc1").style.visibility = "hidden";
					}, 5000);//過了五秒隱藏
					break;
				}
			}
		}
	</script>

</body>
</html>
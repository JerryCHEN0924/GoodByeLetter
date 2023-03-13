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
	<link rel="stylesheet" href="/index/assets/css/mymain.css" />
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
				<form:form id="register_form" action="${contextRoot}/register/add"
					modelAttribute="newRegister" method="post">
					
					<p id="acc1" style="color: red">${errors.account}</p>
					<p id="acc2" style="color: red">${errors.account1}</p>
					<div class="mb-6 row">
						<label for="account" class="col-sm-2 col-form-label">帳號</label>
						<div class="col-sm-10">
							<form:input type="text" path="account" onkeyup="value=value.replace(/[\W]/g,'') "
								placeholder="account(請輸入4~8碼)" class="form-control"
								maxlength="8" minlength="4" id="account" name="account" />

						</div>
					</div>
					<p id="pwd" style="color: red">${errors.password}</p>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<form:input type="password" path="password" onkeyup="value=value.replace(/[\W]/g,'') "
								placeholder="password(請輸入4~8碼)" class="form-control"
								maxlength="8" minlength="4" id="password" name="password" />
						</div>
					</div>
					<br>
					<button type="submit">下一步</button>
					

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
		// 						window.onload = function () {
		// 							var p = document.querySelectorAll("p");
		// 							for(var i = 0; i < p.length ; i++){
		// 							p.addEventListener("change", checkDuplicate);//物件內容改變時觸發checkDuplicate
		// 							}
		// 							function checkDuplicate() {
		// 								for(var i = 0; i<p.length ; i++){
		// 								if (p == "請輸入您的帳號!") {

		// 									setTimeout(function () {
		// 										p.innerHTML = "";
		// 									}, 5000);//過了五秒隱藏
		// 									break;
		// 								}
		// 							}
		// 							}
		// 						}
		window.onload = function() {
			var ps = document.querySelectorAll("p");

			for (var i = 0; i < ps.length; i++) {
				if (ps[i].innerHTML === "請輸入您的帳號!") {

					setTimeout(function() {
						ps[i].innerHTML = "請輸入您的帳號!";
					}, 5000);
				}
			}
		}
	</script>

</body>

</html>
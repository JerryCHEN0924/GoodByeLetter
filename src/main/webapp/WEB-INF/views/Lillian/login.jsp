<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
		<!DOCTYPE html>
		<html>

		<head>
			<link rel="stylesheet" href="/index/assets/css/mymain.css" />
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
			<script src="${contextRoot}/js/jquery-3.6.3.min.js"></script>
		</head>

		<body>

			<%@ include file="../layout/mynav.jsp" %>
				<!--login  login_form_class-->
				<article class="wrapper style2" style="height: 100vh">
					<div class="container" id="login_form">

						<h1>登入</h1>
						<form id="login" action="${contextRoot}/register/login" method="post">
							<input type="text" required placeholder="您的帳號" maxlength="8" minlength="4" name="account"
								id="account"><br>
							<input type="password" required placeholder="您的密碼" maxlength="8" minlength="4"
								name="password" id="password"><br> <br>
							<label>
								<input type="checkbox" name="rememberMe" value="1">記住我
							</label> <br>
							<button type="submit" id="login_submit">登入</button>
						</form>
						<div><a href="<c:url value='/forgetpwd' />">忘記密碼</a></div>
						<div id="msg1" class="d-inline-block ms-3"></div>
						<div id=""></div>
					</div>
				</article>


				<script>
					$('#login').submit(function (event) {
						event.preventDefault();
						let account = document.getElementById("account").value;
						let password = document.getElementById("password").value;

						$.ajax({
							async: true,
							method: 'post',
							url: '${contextRoot}/register/login',
							xhrFields: {withCredentials: true},
							data: { account: account, password: password },
							success: function () {
								$("#msg1").html('<span class="text-success">登入成功<span>');
								setTimeout(function () {
									window.location.href = "/index";
								}, 3000);
								console.log("ok")
							},
							error: function () {
								$("#msg1").html('<span class="text-danger">登入失敗<span>')
							},
							complete: function () {
								setTimeout(function () { $("#msg1").html(''); }, 5000);
							}

						});
					});

				</script>

				<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
				<script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

				<!-- Scripts -->


		</body>

		</html>
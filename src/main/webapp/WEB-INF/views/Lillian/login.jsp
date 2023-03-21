<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
		<!DOCTYPE html>
		<html>

		<head>
			<link rel="stylesheet" href="/index/assets/css/mymain.css" />
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
			<script src="${contextRoot}/js/jquery-3.6.3.min.js"></script>
			<script src="https://www.google.com/recaptcha/api.js" async defer></script>
		</head>
		<style>
			.container {
				max-width: 400px;
				margin: 0 auto;
				text-align: center;
			}

			h1 {
				font-size: 2.5rem;
				margin-bottom: 2rem;
			}

			.form-group {
				margin-bottom: 1.5rem;
			}

			label {
				display: block;
				margin-bottom: 0.5rem;
				font-weight: bold;
			}

			input[type="text"],
			input[type="password"] {
				display: block;
				width: 100%;
				padding: 0.5rem;
				border: none;
				border-bottom: 2px solid #ccc;
				font-size: 1.2rem;
			}

			input[type="text"]:focus,
			input[type="password"]:focus {
				outline: none;
				border-bottom: 2px solid #f39c12;
			}

			button[type="submit"] {
				background-color: #f39c12;
				color: #fff;
				padding: 0.5rem 1rem;
				border: none;
				border-radius: 0.25rem;
				font-size: 1.2rem;
				cursor: pointer;
			}

			button[type="submit"]:hover {
				background-color: #e67e22;
			}

			a {
				color: #f39c12;
				text-decoration: none;
			}

			a:hover {
				text-decoration: underline;
			}
		</style>

		<body>
			<%@ include file="../layout/mynav.jsp" %>
				<!--login  login_form_class-->
				<article class="wrapper style2" style="height: 100vh">
					<div class="container" id="login_form">

						<h1>登入</h1>
						<form id="login" action="${contextRoot}/register/login" method="post">
							<div class="form-group">
								<label for="account" name="acc" class="col-sm-2 col-form-label"><b>帳號</b></label>
								<input type="text" required placeholder="您的帳號" maxlength="8" minlength="4"
									name="account" id="account">
							</div>
							<div class="form-group">
								<label for="password" name="pwd" class="col-sm-2 col-form-label"><b>密碼</b></label>
								<input type="password" required placeholder="您的密碼" maxlength="8" minlength="4"
									name="password" id="password">
							</div>
							<div class="g-recaptcha" data-sitekey="6LeOchQlAAAAAAMkF9gXcPSwvT3Sr_hhaDaExdN2"
								data-callback="robotCheck">
							</div>
							<input type="hidden" name="g-recaptcha-response" id="g-recaptcha-response">
							<input type="hidden" name="ip" id="ip">
							<input type="hidden" name="ip" id="a">
							<label>
								<input type="checkbox" name="rememberMe" value="1">記住我
							</label>
							<button type="submit" id="login_submit">登入</button>
						</form>
						<div><a href="<c:url value='/forgetpwd' />">忘記密碼</a></div>
						<div id="msg1" class="d-inline-block ms-3"></div>
					</div>
				</article>


				<script>
					function robotCheck() {
						document.getElementById('g-recaptcha-response').value = grecaptcha.getResponse();
					}




					// function robotCheck(token) {
					// 	document.getElementById("g-recaptcha-response").value = token
					// 	console.log(ip)
					// 	document.getElementById("ip").value = ip
					// 	console.log(token)
					// 	console.log(a)

					// }


// 					$('#login').submit(function (event) {
// 						event.preventDefault();
// 						let account = document.getElementById("account").value;
// 						let password = document.getElementById("password").value;

// 						$.ajax({
// 							async: true,
// 							method: 'post',
// 							url: '${contextRoot}/register/login',
// 							xhrFields: {withCredentials: true},
// 							data: { account: account, password: password },
// 							success: function () {
// 								$("#msg1").html('<span class="text-success">登入成功<span>');
// 								setTimeout(function () {
// 									window.location.href = "/index";
// 								}, 3000);
// 								console.log("ok")
// 							},
// 							error: function () {
// 								$("#msg1").html('<span class="text-danger">登入失敗<span>')
// 							},
// 							complete: function () {
// 								setTimeout(function () { $("#msg1").html(''); }, 5000);
// 							}

// 						});
// 					});

				</script>

				<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
				<script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

				<!-- Scripts -->


		</body>

		</html>
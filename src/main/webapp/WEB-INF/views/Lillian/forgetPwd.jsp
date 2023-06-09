<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>忘記密碼</title>

			<head>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<link rel="stylesheet" href="/index/assets/css/mymain.css" />
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
					crossorigin="anonymous">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
					crossorigin="anonymous"></script>
				<style>
				</style>

			</head>

		<body>
			<%@ include file="../layout/mynav.jsp" %>

				<!-- regis -->
				<article id="" class="wrapper style2">
					<div class="container-fluid " id="register">
						<div id="space"></div>


						<div class="container" id="form_container">
							<div id="registerTitle">忘記密碼</div>
							<form id="forgrtpassword" action="${contextRoot}/forgetpwd/sendEmail" method="post">

								<div class="mb-6 row">
									<label for="email" class="col-sm-2 col-form-label">Email</label>
									<div class="col-sm-10">
										<input type="email" class="form-control" id="email" name="email" required />
									</div>
								</div>
								<br>
								<button type="submit" >送出Email</button>
								<br>
								<br>
								<div id="msg1"></div>
							</form>
						</div>
					</div>
				</article>



				<!-- Scripts -->
				<script>
					$('#forgrtpassword').submit(function (event) {
						event.preventDefault();
						let email = $('#email').val();

						$.ajax({
							async: true,
							method: 'post',
							url: '${contextRoot}/forgetpwd/sendEmail',
							data: { email: email },
							success: function (data) {
								if (data == 'success') {
									// 如果資料庫中有該Email
									$('#msg1').html('<span class="text-success">已發送重設密碼信，請至您的信箱收取<span>');
								} else {
									// 如果資料庫中沒有該Email
									$("#msg1").html('<span class="text-danger">該Email不存在<span>');
								}
							},
							error: function () {
								$("#msg1").html('<span class="text-danger">發生錯誤<span>')
							},
							complete: function () {
								setTimeout(function () { $("#msg1").html(''); }, 5000);
							}
						});
					});

// $('#register_form').submit(function (event) {
//     event.preventDefault();
//     let email = $('#email').val();

//     $.ajax({
//         async: true,
//         method: 'post',
//         url: '${contextRoot}/forgetpwd/checkEmail',
//         data: { email: email },
//         success: function (data) {
//             if (data == 'true') {
//                 // 如果資料庫中有該Email
//                 $("#msg").html('<span class="text-success">已發送重設密碼信，請至您的信箱收取<span>');
//                 setTimeout(function () {
//                     window.location.href = "${contextRoot}/index";
//                 }, 3000);
//             } else {
//                 // 如果資料庫中沒有該Email
//                 $("#msg").html('<span class="text-danger">該Email不存在<span>')
//             }
//         },
//         error: function () {
//             $("#msg").html('<span class="text-danger">發生錯誤<span>')
//         },
//         complete: function () {
//             setTimeout(function () { $("#msg").html(''); }, 5000);
//         }
//     });
// });
				</script>

		</body>

		</html>
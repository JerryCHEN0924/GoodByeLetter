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
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
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
<!-- <script src="https://www.google.com/recaptcha/api.js" async defer></script> -->
<style>
</style>

</head>
<style>
.g-recaptcha {
	margin: 0 auto; /*水平置中*/
	display: block; /*將元素設為塊級元素*/
}
</style>
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
							<form:input type="text" path="account"
								onkeyup="value=value.replace(/[\W]/g,'') "
								placeholder="account(請輸入4~8碼)" class="form-control" id="account"
								name="account" />
						</div>
					</div>
					<p id="pwd" style="color: red">${errors.password}</p>
					<div class="mb-6 row">
						<label for="password" class="col-sm-2 col-form-label">密碼</label>
						<div class="col-sm-10">
							<form:input type="password" path="password"
								onkeyup="value=value.replace(/[\W]/g,'') "
								placeholder="password(請輸入4~8碼)" class="form-control"
								id="password" name="password" />
						</div>
					</div>
					<P></P>
					<div class="mb-6 row">
						<label for="confirmPassword" class="col-sm-2 col-form-label">確認密碼</label>
						<div class="col-sm-10">
							<input type="password" onkeyup="value=value.replace(/[\W]/g,'') "
								placeholder="confirm password(請再輸入一次)" class="form-control"
								id="confirmPassword" name="confirmPassword" />
						</div>
					</div>
					<br>
<!-- 					<div class="g-recaptcha" -->
<!-- 						data-sitekey="6LeOchQlAAAAAAMkF9gXcPSwvT3Sr_hhaDaExdN2" -->
<!-- 						data-callback="robotCheck"></div> -->
					<div id="msg1" class="d-inline-block ms-3"></div>
					<button type="submit">下一步</button>
				</form:form>
			</div>
		</div>
	</article>


	<script>
		//     // 當表單提交時，檢查兩個密碼欄位是否相同
		$('#register_form').submit(function() {
			var password = $('#password').val();
			var confirmPassword = $('#confirmPassword').val();
			if (password != confirmPassword) {
				$('#confirmPwd').text('兩次輸入的密碼不一致');
				$("#msg1").html('<span class="text-danger">密碼與確認密碼不一致<span>')
				return false;
			}
			return true;
		});
	</script>

	</script>

</body>

</html>
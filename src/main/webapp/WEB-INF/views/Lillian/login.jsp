<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/mymain.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<%@ include file="../layout/mynav.jsp"%>

	<!--login  login_form_class-->
	<article class="wrapper style2" style="height: 100vh">
		<div class="container" id="login_form">
			<br> <br> <br> <br> <br> <br> <br>
			<br>

			<h1>登入</h1>
			<form id="login" action="${contextRoot}/register/login" method="post">
				<input type="text" required placeholder="您的帳號" maxlength="8"
					minlength="4" name="account"><br> 
					<input type="password" required placeholder="您的密碼" maxlength="8"
					minlength="4" name="password"><br> <br> 
				<label>
					<input type="checkbox" name="rememberMe" value="1">記住我
				</label> <br>
				<button type="submit" id="login_submit">登入</button>
			</form>
			<a href="<c:url value='/forgetpwd' />">忘記密碼</a>
			<div id="msg1" class="d-inline-block ms-3"></div>
			<script>
			$(#login).submit(function(){
				var xhr = new XMLHttpRequest(); 
				xhr.open("post","login",true);//true表示非同步請求。
				 xhr.onload = function () {//The transaction completes successfully
			         if (xhr.status === 200) {
			             if (xhr.responseText == 'pass')
			                 $("#msg1").html(`<span class="text-primary">恭喜！您已通過身份驗證。</span>`);
			             else
			                 $("#msg1").html(`<span class="text-danger">抱歉！您未通過身份驗證。</span>`);
			         } else {
			             $("#msg1").html(`<span class="text-danger">${xhr.status} ${xhr.statusText}</span>`);
			         }
			         setTimeout(function(){$("#msg1").html("")}, 2000);
			     };
			     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8") //預設Content-Type: text/plain;charset=UTF-8
                 var formData = $(this).serialize(); //formData如: username=%E5%B0%8F%E5%80%A9&password=%E9%87%87%E8%87%A3
                 
			})

			</script>
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

</body>
</html>
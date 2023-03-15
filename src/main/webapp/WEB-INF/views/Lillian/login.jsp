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
			$(#login).submit(function(event){
				event.preventDefault();
				$.ajax({
					async:true,
					method:'post',
					url:'${contextRoot}/register/login',
					data:{account:"account",password:"password"},
					success: function() {
						$("#msg1").html('<span class="text-success">登入成功<span>')
					},
					error: function() {
						$("#msg1").html('<span class="text-danger">登入失敗<span>')
   					 },
					 complete:function(){
						setTimeout(function(){$("#msg1").html('');},5000);
					 }

				});
				
			});

			</script>
		</div>
	</article>



	<!-- Scripts -->


</body>
</html>
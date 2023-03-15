<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<div id="registerTitle">忘記密碼</div>
				<form id="register_form" action="${contextRoot}/forgetpwd/sendEmail"
					method="post">
					
					<div class="mb-6 row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="email"class="form-control" id="email" name="email" required/>
						</div>
					</div>	
					<br>
					<button type="submit" onclick="sendEmail()">送出Email</button>	
				</form>
			</div>
		</div>
	</article>



	<!-- Scripts -->
	<script>
// 	function sendEmail() {
// 		  var email = document.getElementById("email").value;

// 		  var xhr = new XMLHttpRequest();
// 		  xhr.open("POST", "/sendEmail");
// 		  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
// 		  xhr.onreadystatechange = function() {
// 		    if (xhr.readyState === 4 && xhr.status === 200) {
// 		      alert(xhr.responseText);
// 		    }
// 		  };
// 		  xhr.send("to=" + email + "&subject=郵件主题&content=郵件内容");
// 		}
	</script>

</body>

</html>
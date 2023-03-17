<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>完成Donate</title>
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
<style>
#myspace {
	width: 100%;
	height: 100vh;
}

#space {
	height: 20vh;
}
</style>

</head>

<body>

	<%@ include file="../layout/mynav.jsp"%>
	<!-- myspace -->
	<article id="myspace" class="wrapper style2">
		<div class="container-fluid " id="register">
			<div id="space">
			
				你付的金額為:${paymentSuccess.TradeAmt}
				
				<h1>有收到您的付款資訊，但過程可能被駭客竄改，請注意資訊安全。</h1>
				<br>
				<a class="btn btn-outline-danger" href="${contextRoot}" role="button">請點我回到首頁</a>
			</div>



		</div>
	</article>







	<!-- Scripts -->
	<script>
		
	</script>

</body>
</html>
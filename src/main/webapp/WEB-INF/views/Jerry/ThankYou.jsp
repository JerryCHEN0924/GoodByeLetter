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
				<h1>謝謝您的慷慨捐贈！您支持GoodBye Letter的金額為:「${paymentSuccess.TradeAmt}元」</h1>
				<br>
				<h2>您的善舉將對我們的工作產生深遠的影響，並有助於實現我們的使命。GoodBye Letter開發團隊再次感謝您的慷慨和支持。</h2>
				<br>
				<h2>謝謝您的大力支持！！我們會繼續努力。</h2>
				<br>
				<a class="btn btn-outline-danger btn-lg" href="${contextRoot}" role="button">請點我回到首頁</a>
			</div>



		</div>
	</article>







	<!-- Scripts -->
	<script>
		
	</script>

</body>
</html>
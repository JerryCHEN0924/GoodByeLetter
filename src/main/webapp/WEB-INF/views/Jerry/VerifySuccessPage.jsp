<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;URL=<c:url value='/' />" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>驗證成功</title>
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
				<h2 class="display-2">驗證成功！您的驗證日已經向後推移六個月！</h2>
				<br>
				<h2 class="display-2">請登入會員檢查驗證日。</h2>
				<br> 稍等會，即將為您重新導向至首頁
				<h3 class="display-3"></h3>
			</div>

		</div>
	</article>







	<!-- Scripts -->
	<script src="<c:url value='/assets/js/breakpoints.min.js' />"></script>
	<script src="<c:url value='/assets/js/browser.min.js' />"></script>
	<script src="<c:url value='/assets/js/jquery.min.js' />"></script>
	<script src="<c:url value='/assets/js/jquery.scrolly.min.js' />"></script>
	<script src="<c:url value='/assets/js/main.js' />"></script>
	<script src="<c:url value='/assets/js/util.js' />"></script>
	<script>
		
	</script>

</body>
</html>
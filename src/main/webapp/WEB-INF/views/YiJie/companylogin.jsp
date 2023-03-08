<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/mymain.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous">	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js">	
</script>

<title>company login</title>

<style>
	a {
		margin: 10px auto 0px auto;
		font-size: 15px;
	}
</style>
</head>
<body>
	<%@ include file="../layout/mynav.jsp"%>
	<article id="portfolio" class="wrapper style3">
		<div class="container">
			<header>
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${exis.memberId != null}"> --%>
<!-- 						<li><a class="dropdown-item narbar_text_color" -->
<%-- 							href="<c:url value='/register/logout' />"> --%>
<%-- 							${exis.account}登出</a> --%>
<!-- 						</li> -->
<!-- 						<li><a class="dropdown-item narbar_text_color" -->
<%-- 							href="<c:url value='/register/edit?memberId=${exis.memberId}' />">編輯帳號</a> --%>
<!-- 						<li><a class="dropdown-item narbar_text_color" -->
<%-- 							href="<c:url value='/memberDetail/edit?memberId=${exis.memberId}' />">編輯會員資料</a> --%>
<!-- 						</li> -->
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<!-- 						<li><a class="dropdown-item narbar_text_color" -->
<%-- 							href="<c:url value='/login1' />"> 登入 </a> --%>
<!-- 						</li> -->
<!-- 						<li><a class="dropdown-item narbar_text_color" -->
<%-- 							href="<c:url value='/register1' />"> 註冊 </a> --%>
<!-- 						</li> -->
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
				<h3>歡迎登入</h3>
			</header>
			<div>
				<li>
					<ul>
						<li id="detail_Li">
							<a class="" href="${contextRoot}/customerDetail/detailpage" ></a>
						</li>
						<li id="picture_Li"><a></a></li>
					</ul>
				</li>
				
			</div>
		</div>	
	</article>
	
	
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.3.min.js"></script>
	<script src="assets/js/main.js"></script>
	
</body>
</html>
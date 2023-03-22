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
		<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
		
		<title>company login</title>
	<link rel="stylesheet" href="/index/assets/css/mymain.css" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      
	</head>
<body>
<%-- 	<%@ include file="../layout/mynav.jsp"%> --%>
	
		
	<div class="container">
		<div class="banner">
			<span class="material-icons-outlined"><a class="a001" href="<c:url value='/customer/logout?memberId=${exis.memberId}'/>">${exis.account}登出</a></span>
		</div>
		<div class="left">
			<p>這裡是左欄</p>
			<h1>歡迎${exis.account}登入</h1><ul></ul>
		</div>
		<div class="right">
			<p>這裡是右欄</p>
				<li>
					<a class="a001" href="<c:url value='/customer/picture/page1'/>">投放圖片</a>
				</li>
				<li>
					<a class="a001" href="<c:url value='/customer/detail/page?memberId=${exis.memberId}'/>">更新廠商資料</a>
				</li>
				<li>
					<a class="a001" href="<c:url value='/customer/picture/list?memberId=${exis.memberId}'/>">圖片展示</a>
				</li>
				<li>
					<a class="a001" href="<c:url value='/customer/logout?memberId=${exis.memberId}'/>">${exis.account}登出</a>
				</li>
				<li>
					<a class="a001" href="<c:url value='/customer/add'/>">檢視廣告</a><!-- 之後此連結移到首頁 -->
				</li>
			</ul>
		</div>
	</div>
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
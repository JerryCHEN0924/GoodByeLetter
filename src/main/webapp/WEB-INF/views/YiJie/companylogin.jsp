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
      

	<style>
		body{
			background-color: rgb(237, 167, 251);
		}
		div {
  			border: 1px solid black;
		}
		.container {
			display: flex;
  			flex-wrap: wrap;
			height:100vh;
			background-color:azure;
		}

		.banana {
  			flex-basis: 100%;
  			padding: 20px;
  			box-sizing: border-box;
  			background-color: rgb(81, 169, 251);
			height: 100px;
		}

		.left {
  			flex-basis: 70%;
  			padding: 20px;
  			box-sizing: border-box;
			background-color: antiquewhite;
			height: 600px;
		}

		.right {
  			flex-basis: 30%;
  			padding: 20px;
  			box-sizing: border-box;
			background-color: aquamarine;
			height: 600px;
		}
	</style>
	</head>
<body>
	<%@ include file="../layout/mynav.jsp"%>

	</head>
<body>

	<div class="container">
		<div class="banana">我是標頭banana</div>
		
		<div class="left" style="width: 70%;">
			<p>這裡是左欄</p>
			<h1>歡迎${exis.account}登入</h1>
			<a class="btn btn-outline-info" href="<c:url value='/customer/logout'/>">${exis.account}登出</a>
		</div>
		<div class="right" style="width: 30%;">
			<p>這裡是右欄</p>
			<div class="list-group">
				<a href="<c:url value='/customer/picture/page1'/>" class="list-group-item list-group-item-action">投放圖片</a>
				<a href="<c:url value='/customer/detail/page?memberId=${exis.memberId}'/>" class="list-group-item list-group-item-action">更新廠商資料</a>
				<a href="<c:url value='/customer/picture/list?memberId=${exis.memberId}'/>" class="list-group-item list-group-item-action">圖片展示</a>
				<a href="<c:url value='/customer/add'/>" class="list-group-item list-group-item-action">檢視廣告</a>
			</div>
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
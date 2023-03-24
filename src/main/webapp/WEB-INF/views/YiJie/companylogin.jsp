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
			
			background-image: url("/images/letters.jpg");
		}
		div {
  			/*border: 1px solid black;*/
		}/*background-color:rgb(251, 255, 213);*/
		.container123 {
			/*padding:8em 0;*/
			display: flex;
  			flex-wrap: wrap;
			height:100vh;
			
			background-color: #FFB5B5;
		}

		.banana {
			background-image: url("/images/letters.jpg");
  			flex-basis: 100%;
  			/*padding: 20px;*/
  			box-sizing: border-box;
  			
			height: 131px;
		}
		.left {
  			flex-basis: 70%;
  			padding: 20px;
			background-color: antiquewhite;
  			box-sizing: border-box;
			height: 600px;
		}

		.right {
  			flex-basis: 30%;
			padding: 20px;
			background-color: rgb(255, 213, 167);
  			/**/
  			box-sizing: border-box;
			height: 600px;
			font-family:myFont, Microsoft YaHei,'宋體' , Tahoma, Helvetica, Arial, "\5b8b\4f53", sans-serif;
		}
		.btn-class1{
			top: 20px;
			right: 20px;
			
		}
		#apple1{
			
			position: fixed;
  			right: 50px;
  			top: 30px;
		}
		.text-box{
			font-family:myFont, Microsoft YaHei,'宋體' , Tahoma, Helvetica, Arial, "\5b8b\4f53", sans-serif;
		}
		img{
			width: 650px;
			height: 400px;
		}
	</style>
	</head>
<body>
	<%@ include file="../layout/mynav.jsp"%>

	</head>
<body>

	<div class="container123">
		<!--<P>這裡是container</P>-->
		<div class="banana">
			<span class="material-icons-outlined">
				
			</span>
			<div class="apple" id="apple1">
				<a class="btn btn-outline" style="background-color:#FFD4D4" href="<c:url value='/customer/logout'/>">${exis.account}登出</a>
			</div>
		</div>
		<div class="left">
			<!--<p>這裡是左欄</p>-->
			<div class="text-box">
				<h1>歡迎${exis.account}登入</h1>
			</div>
			<br>
			<hr>
			<!--<div>
				<img src="data:image/jpeg;base64,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" 
				alt="律師1">
			</div>-->
			
		</div>
		<div class="right">
			<!--<p>這裡是右欄</p>-->
			<div class="btn-class1">
				<div class="list-group">
					<a href="<c:url value='/customer/picture/page1'/>" class="list-group-item list-group-item-action list-group-item-info">投放圖片</a>
					<a href="<c:url value='/customer/detail/page?memberId=${exis.memberId}'/>" 
						class="list-group-item list-group-item-action list-group-item-info">
						更新廠商資料
					</a>
					<a href="<c:url value='/customer/picture/list?memberId=${exis.memberId}'/>" 
						class="list-group-item list-group-item-action list-group-item-info">
						圖片檢視與修改
					</a>
					<a href="<c:url value='/customer/add'/>" 
						class="list-group-item list-group-item-action list-group-item-info">
						檢視律師廣告
					</a>
					<a href="<c:url value='/customer/add2'/>" 
						class="list-group-item list-group-item-action list-group-item-info">
						檢視禮儀社廣告
					</a>
					<a href="<c:url value='/customer/add3'/>" 
						class="list-group-item list-group-item-action list-group-item-info">
						檢視諮商師廣告
					</a>
					<a href="<c:url value='/customer/add4'/>" 
						class="list-group-item list-group-item-action list-group-item-info">
						檢視其他廣告
					</a>
				</div>
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
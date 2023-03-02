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
<title>GoodBye Letter編輯</title>
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
			<h1>GoodBye Letter CRUD</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">收件人</th>
						<th scope="col">內容</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>陳冠宇</td>
						<td>感冒用斯斯</td>
						<td>
						<button type="button" id="edit" class="btn btn-success">修改</button>
						<button type="button" id="delete" class="btn btn-danger">刪除</button>
						</td>
					</tr>
					<tr>
						<th scope="row">1</th>
						<td>周升</td>
						<td>咳嗽用斯斯</td>
						<td>
						<button type="button" class="btn btn-success">修改</button>
						<button type="button" class="btn btn-danger">刪除</button>
						</td>
					</tr>
					<tr>
						<th scope="row">1</th>
						<td>速霸陸</td>
						<td>鼻塞屁炎用斯斯</td>
						<td>
						<button type="button" class="btn btn-success">修改</button>
						<button type="button" class="btn btn-danger">刪除</button>
						</td>
					</tr>
				</tbody>
			</table>
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
	<script src="assets/js/main.js"></script>


	<script>
		
	</script>

</body>
</html>
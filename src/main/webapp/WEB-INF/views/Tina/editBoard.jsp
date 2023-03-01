<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>

</head>
<body>
	<%@ include file="../layout/mynav.jsp"%>
	<div class="container">
		<h1>修改留言板頁面</h1>


		<div class="card">
			<form:form action="${contextRoot}/board/post"
				modelAttribute="newboard">
				<h5 class="card-header">
					<form:input path="title" class="form-control" placeholder="新增留言板" />
				</h5>
				<div class="card-body">
					<div class="input-group">
						<form:textarea path="boardMessage" class="form-control" />
					</div>
					<br>
					<button type="submit" class="btn btn-info">送出</button>
				</div>
			</form:form>
		</div>
		
		<br>
		<div class="card">
		<div class="card-header">
		<h5>${lastestBoard.title} </h5>
	<h6>上傳時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE" value="${lastestBoard.createTime}"/><br>
		更時時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE" value="${lastestBoard.updateTime}"/></h6>
		
		
		
		</div>
		<div class="card-body">${lastestBoard.boardMessage}</div>
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
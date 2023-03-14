<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editCommentBoardPage</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
<style>
.container {
	height: 100%;
	background: #fff;
	box-shadow: 5px 0px 5px -5px #180532, -5px 0px 5px -5px #180532;
	z-index: 200;
	background: rgba(249, 212, 35, 0.25);
}

.container .searchBoard {
	display: flex;
	justify-content: space-between;
	padding-top: 20px;
	/* border: 1px solid red; */
}
.container .searchBoard input{
	font-size:1.2em;
}
.messageContent {
	/* 	top right bottom left */
	padding: 2em 4em 1em 4em;
	margin: 0 0 1em 0;
	text-align: left;
	color: black;
	background: #fff;
	border-radius: 10px;
	text-align: left;
}


.messageContent h5 {
	color: rgb(100, 99, 99)
}
</style>
</head>
<body>
<%@ include file="../layout/mynav.jsp"%>

	<article class="container-fluid wrapper" style="height:100vh">
	<div class="container">
	<form:form action="${contextRoot}/board/editpost" method="put" modelAttribute="newboard">
	<div class="searchBoard">
		<h3>編輯Id:${newboard.boardId}留言板</h3>
	</div>
	
	<hr>
	
			<div class="messageContent">
				
					<h4>
						<strong>${newboard.register.memberId}</strong>
					</h4>
					<h5>
						建立時間:
						<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
							value="${newboard.createTime}" />
						更新時間:
						<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
							value="${newboard.updateTime}" />
					</h5>
					<h3><form:input path="title" value="${newboard.title}" placeholder="title" class="form-control"/></h3>
					<p><form:textarea path="boardMessage" class="form-control" placeholder="新增留言板內容" style="height:100px"/></p>
					<%--編輯按鈕 --%>
						<input type="hidden" name="boardId" value="${newboard.boardId}" />
						<input type="submit" class="btn btn-success" value="編輯" />
			
				</div>
	</form:form>
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
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	
			

</body>
</html>
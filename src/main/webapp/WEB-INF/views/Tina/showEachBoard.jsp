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
<title>showEachBoard</title>
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

	<article id="myspace" class="wrapper style2" style="height: 100vh">
		<div class="container">
			<h1>查看留言板頁面</h1>


			<div class="card">



				<form:form action="${contextRoot}/board/editpost" method="put"
					modelAttribute="newboard">
					<%-- 					透過model newboard把資料傳給controller --%>

					<%-- 					需要把boardId, createTime 加到model newboard裡 --%>
					<form:input path="boardId" type="hidden" />
					<form:input path="createTime" type="hidden" />

					<h5 class="card-header">
						<form:input path="title" class="form-control" placeholder="查看留言板" />
					</h5>
					<div class="card-body">
						<div class="input-group">
							<form:textarea path="boardMessage" class="form-control" />
						</div>
						<br>
						<button type="submit" class="btn btn-info">送出</button>
					</div>
				</form:form>



				<%-- 				刪除按鈕 --%>
				<form:form action="${contextRoot}/board/delete" method="delete">
					<input type="hidden" name="boardId" value="${newboard.boardId}" />
					<input type="submit" class="btn btn-outline-danger" value="刪除" />
				</form:form>
			</div>

<hr>
<%--回覆card --%>
<div class="card">
				<form:form action="${contextRoot}/comment/add1" method="post" modelAttribute="comment">
					<div class="card-body">
						<form:input path="reply" class="form-control" placeholder="回覆" />
						<button type="submit" class="btn btn-primary">送出</button>
					</div>
				</form:form>
			</div>
			
			
		</div>


		<%--回覆card --%>
		<!-- 		<div class="card"> -->
		<%-- 			<form:form action="${contextRoot}/comment/add" method="post" --%>
		<%-- 				modelAttribute="addComment"> --%>
		<!-- 				 -->
		<!-- 					<h5 class="card-title"></h5> -->
		<%-- 					<form:input path="boardId" type="hidden" /> --%>
		<%-- 					<form:input path="createTime" type="hidden" /> --%>
		<%-- 					<form:input path="updateTime" type="hidden"/> --%>
		<%-- 					<form:input path="reply" class="form-control" placeholder="新增回覆" /> --%>
		<!-- 					<button type="submit" class="btn btn-primary">送出</button> -->
		<!-- 				</div> -->
		<%-- 			</form:form> --%>
		<!-- 		</div> -->

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
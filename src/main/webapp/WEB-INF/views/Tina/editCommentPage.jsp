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
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
</head>
<body>
<%@ include file="../layout/mynav.jsp"%>

	<article id="myspace" class="wrapper style2" style="height: 100vh">
		<div class="container">
			<h1>編輯回覆頁面</h1>


			<div class="card">

				<%-- 					透過model newboard把資料傳給controller --%>

				<%-- 					需要把boardId, createTime 加到model newboard裡 --%>
				

				<form:form action="${contextRoot}/comment/editpost" method="put" modelAttribute="newcomment">
				<div class="card-header">
				<h5>
				</h5><br>
				 <h6 class="card-subtitle mb-2 text-muted">
				 
				 <form:input type="hidden" path="createTime" />
				 <form:input type="hidden" path="commentId" value="${newcomment.commentId}" />
				 <form:hidden path="bId" class="form-control" placeholder="bId" value="${newboard.boardId}" /> 
				 <input type="hidden" name="boardId" value="${newboard.boardId}">
				 
				 上傳時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${newcomment.createTime}" />
				 <br> 
				 更新時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${newcomment.updateTime}" />
				 </h6>
				</div>
				<div class="card-body">
					<div class="input-group">
					<form:textarea path="reply" value="${newcomment.reply}" placeholder="reply" class="form-control"/>
					</div>
					<br>
					<%--編輯按鈕 --%>
<%-- 						<input type="hidden" name="boardId" value="${newboard.boardId}" /> --%>
						<input type="submit" class="btn btn-outline-info" value="編輯回覆" />		
				</div>
				</form:form>
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
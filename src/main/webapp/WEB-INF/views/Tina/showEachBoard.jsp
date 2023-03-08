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

				<%-- 					透過model newboard把資料傳給controller --%>

				<%-- 					需要把boardId, createTime 加到model newboard裡 --%>
				<input type="hidden" value="${newboard.boardId}" /> 
				<input type="hidden" value="${newboard.createTime}" />

				<div class="card-header">
				<h5>${newboard.title}</h5><br>
				 <h6 class="card-subtitle mb-2 text-muted">
				 上傳時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${newboard.createTime}" /><br> 
				 更新時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${newboard.updateTime}" />
				 </h6>
				</div>
				<div class="card-body">
					<div class="input-group">${newboard.boardMessage}</div>
					<br>
					<%--編輯按鈕 --%>
					<form:form action="${contextRoot}/board/editPage" method="get">
						<input type="hidden" name="boardId" value="${newboard.boardId}" />
						<input type="submit" class="btn btn-outline-info" value="編輯留言板" />
					</form:form>
					<%--刪除按鈕 --%>
					<form:form action="${contextRoot}/board/delete" method="delete">
						<input type="hidden" name="boardId" value="${newboard.boardId}" />
						<input type="submit" class="btn btn-outline-danger" value="刪除留言板" />
					</form:form>
				</div>
			</div>
			
			
			<hr>
			<%--the list of comments--%>
			
			<c:forEach var="comment" items="${samebIdComment}">

			<div class="card">
			<div class="card-body">	
			 <h6 class="card-subtitle mb-2 text-muted">
			回覆時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${comment.createTime}" /><br> 
			更新時間:<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${comment.updateTime}" /><br></h6>
			<h6>${comment.reply}</h6>
			<%-- 			修改留言 --%>
			<form:form action="${contextRoot}/comment/editPage" method="get">
						<input type="hidden" name="boardId" value="${newboard.boardId}" />
						<input type="hidden" name="commentId" value="${comment.commentId}" />
						<input type="submit" class="btn btn-outline-info" value="編輯回覆" />
			</form:form>
<%-- 			刪除留言 --%>
			<form:form action="${contextRoot}/comment/delete" method="delete">
						<input type="hidden" name="boardId" value="${newboard.boardId}" />
						<input type="hidden" name="commentId" value="${comment.commentId}" />
						<input type="submit" class="btn btn-outline-danger" value="刪除回覆" />
			</form:form>
			
			</div> 
			</div>
			</c:forEach> 
			<hr>
			
			
			<%--回覆card --%>
			<form:form action="${contextRoot}/comment/add" method="post"
			modelAttribute="comment"> 
			<div class="card">
			<div class="card-body"> 
			<input type="hidden" name="boardId" value="${newboard.boardId}" />
<%-- 			<input name="boardId" value="${newboard.boardId}"> --%>
			<form:hidden path="bId" class="form-control" placeholder="bId" value="${newboard.boardId}" /> 
			<form:textarea path="reply" class="form-control" placeholder="reply" /> 
			<button type="submit" class="btn btn-primary">送出</button> 
			</div> 
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
</body>
</html>
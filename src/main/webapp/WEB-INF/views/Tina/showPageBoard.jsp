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
<title>showPageBoard</title>
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
			<h1>查看留言板</h1>


			<%--查詢表單 --%>
			<form action="${contextRoot}/board/like" method="get">
				<input type="text" name="title" placeholder="查詢關鍵字"
					class="form-control" />
					<input type="submit" class="btn btn-outline-info">	
			</form>


				<%--回傳找到符合關鍵字的留言板 --%>
				<c:forEach var="like" items="${like}">
					<div class="card">
						<div class="card-header">
							<h5>${like.title}</h5>
							<h6>
								上傳時間:
								<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${like.createTime}" />
								<br> 更新時間:
								<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${like.updateTime}" />
							</h6>
						</div>

						<div class="card-body">${like.boardMessage}</div>

						<%--送出修改/刪除按鈕 --%>
						<div class="showEachbutton" style="display: flex">
							<form:form action="${contextRoot}/board/show" method="get">
								<input type="hidden" name="boardId" value="${like.boardId}" />
								<input type="submit" class="btn btn-outline-success" value="查看" />
							</form:form>

<%-- 							<form:form action="${contextRoot}/board/delete" method="delete"> --%>
<%-- 								<input type="hidden" name="boardId" value="${like.boardId}" /> --%>
<!-- 								<input type="submit" class="btn btn-outline-danger" value="刪除" /> -->
<%-- 							</form:form> --%>
						</div>
					</div>
				</c:forEach>



				<%--一開始進入這個網頁後，會回傳所有的留言 --%>
				<c:forEach var="boardPage" items="${page.content}">
					<br>
					<div class="card">
						<div class="card-header">
							<h5>${boardPage.title}</h5>
							<h6>
								上傳時間:
								<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${boardPage.createTime}" />
								<br> 更新時間:
								<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
									value="${boardPage.updateTime}" />
							</h6>
						</div>

						<div class="card-body">${boardPage.boardMessage}</div>

						<%--送出修改/刪除按鈕 --%>
						<div class="showEachbutton" style="display: flex">
							<form:form action="${contextRoot}/board/show" method="get">
								<input type="hidden" name="boardId" value="${boardPage.boardId}" />
								<input type="submit" class="btn btn-outline-success" value="查看" />
							</form:form>

<%-- 							<form:form action="${contextRoot}/board/delete" method="delete"> --%>
<%-- 								<input type="hidden" name="boardId" value="${boardPage.boardId}" /> --%>
<%-- 								<input type="submit" class="btn btn-outline-danger" value="刪除" /> -->
<%-- 							</form:form> --%>
						</div>
					</div>
				</c:forEach>




				<%--頁碼 --%>
				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
					<c:choose>
						<c:when test="${page.number+1 != pageNumber}">
							<a href="${contextRoot}/board/page?p=${pageNumber}">${pageNumber}</a>
						</c:when>
						<c:otherwise>
							${pageNumber}
						</c:otherwise>
					</c:choose>

				</c:forEach>
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
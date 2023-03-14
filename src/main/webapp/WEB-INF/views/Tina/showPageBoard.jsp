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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<!-- 不知道為何, 我跟易潔的jsp引入mymain有問題 -->
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
<style>
.container {
	background: #fff;
	box-shadow: 5px 0px 5px -5px #180532, -5px 0px 5px -5px #180532;
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
	cursor: pointer;
	text-align: left;
}


.messageContent h5 {
	color: rgb(100, 99, 99)
}
</style>
</head>
<body>
	<%@ include file="../layout/mynav.jsp"%>

	<article class="container-fluid wrapper" >
		<div class="container">

			<%--查詢表單 --%>
			<div class="searchBoard">
				<span><h3>留言板</h3></span> <span class="row">
					<form action="${contextRoot}/board/like" method="get">
						<input type="text" name="title" class="" placeholder="Title search ..." size="50"/>
						<button type="submit" class="btn btn-outline-dark ">
							<ion-icon name="search-outline" style="font-size: 1em;"></ion-icon>
						</button>
					</form>
				</span>
			</div>

			<hr>

			<%--回傳找到符合關鍵字的留言板 --%>
			<c:forEach var="like" items="${like}">

				<div class="messageContent" data-aos="fade-up"  onclick="submitForm(${like.boardId})">
					<h4>
						<strong>${like.register.memberDetail.name}</strong>
					</h4>
					<h5>
						建立時間:
						<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
							value="${like.createTime}" />
						更新時間:
						<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
							value="${like.updateTime}" />
					</h5>
					<h3>${like.title}</h3>
					<p>${like.boardMessage}</p>
					<form:form id="likeForm_${like.boardId}"
						action="${contextRoot}/board/show" method="get">
						<input type="hidden" name="boardId" value="${like.boardId}" />
						<!-- 								<input type="submit" class="btn btn-outline-success" value="查看" /> -->
					</form:form>
				</div>
			</c:forEach>


			<%--一開始進入這個網頁後，會回傳所有的留言 --%>
			<c:forEach var="boardPage" items="${page.content}">
				<div class="messageContent"  data-aos="fade-up"
					onclick="submitForm(${boardPage.boardId})">
					<h4>
						<strong>${boardPage.register.memberDetail.name}</strong>
					</h4>
					<h5>
						建立時間:
						<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
							value="${boardPage.createTime}" />
						更新時間:
						<fmt:formatDate pattern="yyyy/MM/dd, HH:mm/ss EEEE"
							value="${boardPage.updateTime}" />
					</h5>
					<h3>${boardPage.title}</h3>
					<p>${boardPage.boardMessage}</p>
					<form:form id="likeForm_${boardPage.boardId}"
						action="${contextRoot}/board/show" method="get">
						<input type="hidden" name="boardId" value="${boardPage.boardId}" />
					</form:form>
				</div>
			</c:forEach>
<div style="height:10px"></div>


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
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

	<script>
// 	like_Form
	function submitForm(boardId){
 		document.getElementById("likeForm_"+boardId).submit();
		console.log(boardId);
	}
	//AOS animation on slide 
	   AOS.init();
	</script>
</body>
</html>
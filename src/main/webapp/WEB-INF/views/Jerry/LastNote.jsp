<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>遺書頁面</title>
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
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

	<article id="myspace" class="wrapper style2">

		<div class="container-fluid " id="register">
			<div class="container">
				<h1 class="display-4 mb-5">GoodBye Letter</h1>
				<!-- 	表單區	 -->
				<div class="card">
					<div class="card-header bg-light text-black ">新增遺囑</div>
					<div class="card-body">
						<form:form action="${contextRoot}/LastNote/post"
							modelAttribute="lastNote" method="POST">
							<!-- 							以下這兩行為從前端取得會員ID後再送進後端處理，已改為從後端取得 -->
							<%-- 								<form:input type="hidden" class="form-control" --%>
							<%--  									path="FK_memberId" id="FK_memberId" value="${existing.memberId}" />  --%>

							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">收件人信箱</label>
								<form:input type="email" class="form-control"
									value="jk2455892@gmail.com" path="recipientEmail"
									id="recipientEmail" placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">第一驗證人信箱</label>
								<form:input type="email" class="form-control" path="verify1"
									value="aaa@gmail.com" id="verify1"
									placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">第二驗證人信箱</label>
								<form:input type="email" class="form-control" path="verify2"
									value="bbb@gmail.com" id="verify2"
									placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlTextarea1" class="form-label">信件內容</label>
								<form:textarea class="form-control" id="notedetail"
									defaultValue="這是GoodBye Letter的預設內容" path="notedetail" rows="3" />
							</div>

							<div class="d-flex justify-content-center">
								<button class="btn btn-success" type="submit">送出</button>
								<button class="btn btn-danger" type="Reset">重置</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>

	</article>


	<script src="<c:url value='/js/jquery-3.6.3.min.js' />"></script>
</body>
</html>
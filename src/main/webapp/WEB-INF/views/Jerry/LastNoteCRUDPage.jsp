<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>GoodBye Letter</title>
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
			<div class="container">
				<h1>GoodBye Letter</h1>
				<!-- 	表單區	 -->
				<div class="card">
					<div class="card-header">更新遺囑</div>
					<div class="card-body">
						<form:form action="${contextRoot}/LastNote/CRUD/put"
							modelAttribute="nId" method="put">

							<form:input type="hidden" class="form-control" path="noteId"
								id="noteId" value="" />

							<form:input type="hidden" class="form-control" path="mId" id="mId"
								value="5" />

							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">收件人信箱</label>
								<form:input type="email" class="form-control"
									path="recipientEmail" id="recipientEmail"
									placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">第一驗證人信箱</label>
								<form:input type="email" class="form-control" path="verify1"
									id="verify1" placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label">第二驗證人信箱</label>
								<form:input type="email" class="form-control" path="verify2"
									id="verify2" placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlTextarea1" class="form-label">信件內容</label>
								<form:textarea class="form-control" id="notedetail"
									path="notedetail" rows="3" />
							</div>
							<button class="btn btn-success" type="submit">送出</button>
							</form:form>
							
							<form action="${contextRoot}/LastNote/CRUD/delete" method="post">
							<input value="${LastNote.noteId}" type="hidden" name="lastNoteId">
							<input type="hidden" name="_method" value="delete" /> 
							<button class="btn btn-danger disabled" aria-disabled="true" type="submit">刪除</button>
							</form>
							
							<br>

					</div>
				</div>
			</div>

			<!-- 	表單區	 -->
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
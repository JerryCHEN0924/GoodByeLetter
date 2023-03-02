<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看帳號</title>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
</style>

</head>

<body>
	<%@ include file="../layout/mynav.jsp"%>


	<div class="container" id="form_container">
		<div id="registerShowTitle">查看帳號</div>


		<table class="table">
			<thead>
				<tr>
					<th scope="col">帳號</th>
					<th scope="col">密碼</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="accAndPwd" items="${register}">
					<tr>

						<td>${accAndPwd.account}</td>
						<td>${accAndPwd.password}</td>
						<td>
							<div class="edit-place">
								<form id="register_form" action="${contextRoot}/register/edit"
									method="get">
									<input type="hidden" name="memberId" value="${accAndPwd.memberId}" /> 
									<input type="submit" class="btn btn-outline-danger btn-sm" value="編輯">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</div>

		






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
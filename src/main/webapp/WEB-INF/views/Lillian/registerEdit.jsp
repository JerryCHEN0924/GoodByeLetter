<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>編輯帳號</title>

				<head>
					<meta charset="UTF-8">
					<meta http-equiv="X-UA-Compatible" content="IE=edge">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<link rel="stylesheet" href="/index/assets/css/mymain.css" />
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
						crossorigin="anonymous">
					<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
						integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
						crossorigin="anonymous"></script>
						<link rel="stylesheet" href="/index/assets/css/mymain.css" />
					<style>
					</style>

				</head>

			<body>
				<%@ include file="../layout/mynav.jsp" %>

					<article id="" class="wrapper style2">
						<div class="container-fluid " id="register">
							<div id="space"></div>


							<div class="container" id="form_container">
								<div id="registerShowTitle">編輯帳號</div>
								<form:form id="register_form" action="${contextRoot}/register/putRegister"
									modelAttribute="registers" method="put">
									<form:input path="memberId" type="hidden" />
									<form:input path="registerTime" type="hidden" />
									<form:input path="FK_Plevel" type="hidden" />

									<div class="mb-6 row">
										<label for="account" class="col-sm-2 col-form-label">帳號</label>
										<div class="col-sm-10">
											<form:input path="account" type="text" class="form-control"
												placeholder="account(請輸入4~8碼)" id="account" maxlength="8" minlength="4"
												name="account" />
										</div>
									</div>
									<div class="mb-6 row">
										<label for="password" class="col-sm-2 col-form-label">密碼</label>
										<div class="col-sm-10">
											<form:input path="password" type="password" class="form-control"
												placeholder="password(請輸入4~8碼)" id="password" maxlength="8"
												minlength="4" name="password" />
										</div>
									</div>
									<button type="submit">送出</button>
								</form:form>
							</div>
						</div>
					</article>







					<!-- Scripts -->
					<script>

					</script>

			</body>

			</html>
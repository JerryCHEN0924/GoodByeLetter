<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- 增加form:form方法 -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>廠商基本資料</title>

	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="/index/assets/css/mymain.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
		rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
		crossorigin="anonymous" />
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
		crossorigin="anonymous">
	</script>
	<style>
	</style>

</head>
<body>
	<%@ include file="../layout/mynav.jsp"%>

	<article id="" class="wrapper style2" style="height:100vh">
		<div class="container-fluid " id="updataDetail">

			<div class="container">
				<div>編輯詳細資料</div>
				<form:form id="changeDetail_form" class="form-control" action="${contextRoot}/customer/detail/putDetail" 
                    method="post" modelAttribute="detail">
                    <!-- 這是啥 -->
                    <form:input type="hidden" path="id" />
					
					<div class="mb-3 row">
						<label for="name" id="name" name="name" class="col-sm-2 col-form-label">公司名稱</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" id="name" name="name" 
                                value="${customerDetail.name}" path="name" />
						</div>
					</div>
					<!--
					<div class="mb-3 row">
						<label for="type" class="col-sm-2 col-form-label">公司種類</label>
						<div class="col-sm-10">
							<div class="form-check form-check-inline ">
								
                                <form:radiobutton path="type" class="form-check-input" name="type"
 									id="maleRadio" value="${customerDetail.type}" />
								<label class="form-check-label" for="lawyerRadio"> 律師 </label>
							</div>
							<div class="form-check form-check-inline ">
								<form:radiobutton path="type" class="form-check-input" name="type"
 									id="morticianRadio" value="${customerDetail.type}" /> 
                                <label class="form-check-label" for="morticianRadio"> 禮儀社 </label>									
							</div>
							<div class="form-check form-check-inline ">
								<form:radiobutton path="type" class="form-check-input" name="type"
 									id="counselingRadio" value="${customerDetail.type}" />                                  
								<label class="form-check-label" for="counselingRadio"> 諮商師 </label>
							</div>
							<div class="form-check form-check-inline ">
								<form:radiobutton path="type" class="form-check-input" name="type"
 									id="otherRadio" value="${customerDetail.type}" />
                                <label class="form-check-label" for="otherRadio"> 其他 </label>									
							</div>
						</div>
					</div>
					-->
					<div class="mb-3 row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
                            <form:input type="email" path="email" class="form-control" id="email"
								name="email" value="${customerDetail.email}" />
						</div>
					</div>

					<div class="mb-3 row">
						<label for="address" class="col-sm-2 col-form-label">地址</label>
						<div class="col-sm-10">
                            <form:input type="text" class="form-control" name="address" id="address"
                                value="${customerDetail.address}" path="address" placeholder="請填入地址" /> 
						</div>
					</div>
					<button type="submit">送出</button>
					<a href="<c:url value='/customer/home/page'/>">${exis.account}返回</a>
				</form:form>
			</div>
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

</body>

</html>
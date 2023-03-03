<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯會員資料</title>
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

	<article id="" class="wrapper style2">
		<div class="container-fluid " id="register">
			<div id="space"></div>


			<div class="container" id="form_container">
				<div id="memberDetailEdit">編輯會員資料</div>
				<form:form id="memberDetailEdit_form"
					action="${contextRoot}/memberDetail/putMemberDetail"
					modelAttribute="memberDetails" method="put">
					<form:input path="memberId" type="hidden" />

			<div class="mb-3 row">
						<label for="name" class="col-sm-2 col-form-label">名字</label>
						<div class="col-sm-10">
							<form:input path="name" type="text" class="form-control" id="name" name="name" />
						</div>
					</div>

					<div class="mb-3 row">
						<label for="gender" class="col-sm-2 col-form-label">性別</label>
						<div class="col-sm-10">
							<div class="form-check form-check-inline ">
								<form:input path="gender" type="radio" class="form-check-input" name="gender"
									id="maleRadio" value="male" /> <label
									class="form-check-label" for="maleRadio"> 男性 </label>
							</div>
							<div class="form-check form-check-inline ">
								<form:input path="gender" type="radio" class="form-check-input" name="gender"
									id="femaleRadio" value="female" /> <label
									class="form-check-label" for="femaleRadio"> 女性 </label>
							</div>
							<div class="form-check form-check-inline ">
								<form:input path="gender" type="radio" class="form-check-input" name="gender"
									id="nonbinaryRadio" value="nonbinary" /> <label
									class="form-check-label" for="nonbinaryRadio"> 中性 </label>
							</div>
							<div class="form-check form-check-inline ">
								<form:input path="gender" type="radio" class="form-check-input" name="gender"
									id="secretRadio" value="secret" /> <label
									class="form-check-label" for="secretRadio"> 保密 </label>
							</div>
						</div>
					</div>

					<div class="mb-3 row">
						<label for="birthday" class="col-sm-2 col-form-label">生日</label>
						<div class="col-sm-10">
							<form:input path="birthday" type="date" class="form-control" id="birthday"
								name="birthday" />
						</div>
					</div>

					<div class="mb-3 row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<form:input path="email" type="email" class="form-control" id="email" name="email" />
						</div>
					</div>

					<div class="mb-3 row">
						<label for="county" class="col-sm-2 col-form-label">住址</label>
						<div class="col-sm-2">
							<form:select path="county" id="county" class="col-sm-2 form-control" name="county">
								<form:option value="TaipeiC">臺北市</form:option>
								<form:option value="newTaipeiC">新北市</form:option>
								<form:option value="taoyuanC">桃園市</form:option>
								<form:option value="taichungC">臺中市</form:option>
								<form:option value="tainanC">臺南市</form:option>
								<form:option value="kaohsiungC">高雄市</form:option>
								<form:option value="keelungC">基隆市</form:option>
								<form:option value="hsinchuC">新竹市</form:option>
								<form:option value="chiayiC">嘉義市</form:option>
								<form:option value="yilanT">宜蘭縣</form:option>
								<form:option value="hsinchuT">新竹縣</form:option>
								<form:option value="miaoliT">苗栗縣</form:option>
								<form:option value="changhuaT">彰化縣</form:option>
								<form:option value="nantouT">南投縣</form:option>
								<form:option value="yunlinT">雲林縣</form:option>
								<form:option value="chiayiT">嘉義縣</form:option>
								<form:option value="pingtungT">屏東縣</form:option>
								<form:option value="hualienT">花蓮縣</form:option>
								<form:option value="taitungT">台東縣</form:option>
								<form:option value="penghuT">澎湖縣</form:option>
							</form:select>
						</div>
						<div class="col-sm-8">
							<form:input path="address" type="text" class="form-control" id="address"
								name="address" placeholder="完整地址" />
						</div>
					</div>
					

						//////
						
						<form:button type="submit">送出</form:button>
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


	<script>
		
	</script>

</body>
</html>
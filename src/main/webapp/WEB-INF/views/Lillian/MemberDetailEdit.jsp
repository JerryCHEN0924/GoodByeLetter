<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
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
				<form id="memberDetailEdit_form"
					action="${contextRoot}/memberDetail/putMemberDetail"
					modelAttribute="memberDetails" method="post">
					<input type="hidden" name="_method" value="put" /> <input
						type="hidden" path="id" />
					<div class="mb-3 row">
						<label for="name" class="col-sm-2 col-form-label">名字</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								value="${memberDetails.name}" />
						</div>
					</div>
					<div class="mb-3 row">
						<label for="gender" class="col-sm-2 col-form-label">性別</label>
						<div class="col-sm-10">
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="gender"
									id="maleRadio"
									<c:if test="${memberDetails.gender == 'male'}">checked</c:if> />
								<label class="form-check-label" for="maleRadio"> 男性 </label>
							</div>
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="gender"
									id="femaleRadio"
									<c:if test="${memberDetails.gender == 'female'}">checked</c:if> />
								<label class="form-check-label" for="femaleRadio"> 女性 </label>
							</div>
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="gender"
									id="nonbinaryRadio"
									<c:if test="${memberDetails.gender == 'nonbinary'}">checked</c:if> />
								<label class="form-check-label" for="nonbinaryRadio"> 中性
								</label>
							</div>
							<div class="form-check form-check-inline ">
								<input type="radio" class="form-check-input" name="gender"
									id="secretRadio"
									<c:if test="${memberDetails.gender == 'secret'}">checked</c:if> />
								<label class="form-check-label" for="secretRadio"> 保密 </label>
							</div>
						</div>
					</div>

					<div class="mb-3 row">
						<label for="birthday" class="col-sm-2 col-form-label">生日</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="birthday"
								name="birthday" value="${memberDetails.birthday}" />
						</div>
					</div>

					<div class="mb-3 row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email" name="email"
								value="${memberDetails.email}" />
						</div>
					</div>

					<div class="mb-3 row">
						<label for="county" class="col-sm-2 col-form-label">住址</label>
						<div class="col-sm-2">
							<select id="county" class="col-sm-2 form-control" name="county"
								value="${memberDetails.county}">
								<option value="TaipeiC"
									${memberDetails.county == 'TaipeiC' ? 'selected' : ''}>臺北市</option>
								<option value="newTaipeiC"
									${memberDetails.county == 'newTaipeiC' ? 'selected' : ''}>新北市</option>
								<option value="taoyuanC"
									${memberDetails.county == 'taoyuanC' ? 'selected' : ''}>桃園市</option>
								<option value="taichungC"
									${memberDetails.county == 'taichungC' ? 'selected' : ''}>臺中市</option>
								<option value="tainanC"
									${memberDetails.county == 'tainanC' ? 'selected' : ''}>臺南市</option>
								<option value="kaohsiungC"
									${memberDetails.county == 'kaohsiungC' ? 'selected' : ''}>高雄市</option>
								<option value="keelungC"
									${memberDetails.county == 'keelungC' ? 'selected' : ''}>基隆市</option>
								<option value="hsinchuC"
									${memberDetails.county == 'hsinchuC' ? 'selected' : ''}>新竹市</option>
								<option value="chiayiC"
									${memberDetails.county == 'chiayiC' ? 'selected' : ''}>嘉義市</option>
								<option value="yilanT"
									${memberDetails.county == 'yilanT' ? 'selected' : ''}>宜蘭縣</option>
								<option value="hsinchuT"
									${memberDetails.county == 'hsinchuT' ? 'selected' : ''}>新竹縣</option>
								<option value="miaoliT"
									${memberDetails.county == 'miaoliT' ? 'selected' : ''}>苗栗縣</option>
								<option value="changhuaT"
									${memberDetails.county == 'changhuaT' ? 'selected' : ''}>彰化縣</option>
								<option value="nantouT"
									${memberDetails.county == 'nantouT' ? 'selected' : ''}>南投縣</option>
								<option value="yunlinT"
									${memberDetails.county == 'yunlinT' ? 'selected' : ''}>雲林縣</option>
								<option value="chiayiT"
									${memberDetails.county == 'chiayiT' ? 'selected' : ''}>嘉義縣</option>
								<option value="pingtungT"
									${memberDetails.county == 'pingtungT' ? 'selected' : ''}>屏東縣</option>
								<option value="hualienT"
									${memberDetails.county == 'hualienT' ? 'selected' : ''}>花蓮縣</option>
								<option value="taitungT"
									${memberDetails.county == 'hualienT' ? 'selected' : ''}>台東縣</option>
								<option value="penghuT"
									${memberDetails.county == 'penghuT' ? 'selected' : ''}>澎湖縣</option>
							</select>
						</div>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="address"
								name="address" value="${memberDetails.address}"
								placeholder="完整地址" />
						</div>
					</div>


					<button type="submit">送出</button>
				</form>
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
		window.onload = function() {
			var time = "${memberDetails.birthday}"
			var timeBirthdate = moment(time, "ddd MMM DD HH:mm:ss zzz YYYY");
			var timeBirthdateFormat = timeBirthdate.format("YYYY-MM-DD");
			console.log(timeBirthdateFormat)
			var birthday = document.getElementById('birthday').valueAsDate = new Date(
					timeBirthdateFormat);
			console.log(birthday)

			console.log("${memberDetails.gender}")

			console.log("${memberDetails.county}")

		}
	</script>

</body>

</html>
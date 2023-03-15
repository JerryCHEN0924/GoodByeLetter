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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>
	
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

		<div class="container-fluid " id="lastNote">
			<div class="container">
				<h1 class="display-4 mb-5">GoodBye Letter</h1>
				<!-- 	表單區	 -->
				<div class="card">
					<div class="card-header bg-light text-black ">新增遺囑</div>
					<div class="card-body">
						<form:form action="${contextRoot}/LastNote/post" id="lastNoteForm"
							modelAttribute="lastNote" method="POST">

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
								<label for="notedetail" class="form-label">信件內容</label>
								<form:textarea class="form-control" id="notedetail" maxlength="500"
									defaultValue="這是GoodBye Letter的預設內容" path="notedetail" rows="3" />
								<form:errors path="notedetail" />
								
							</div>
							
							<div class="d-flex justify-content-center">
								<button class="btn btn-success" id="saveButton" onclick="save()" type="button">送出</button>
								<button class="btn btn-danger" id="resetButton1231" onclick="resetbutton()" type="button">重置</button>
							</div>
						</form:form>

					</div>
				</div>
			</div>

		</div>

	</article>

	<script>
	function save() {
	    Swal.fire({
	      title: '確定要儲存嗎？',
	      icon: 'success',
	      showCancelButton: true,
	      confirmButtonText: '確定！',
	      cancelButtonText: '取消',
	      reverseButtons: true
	    }).then((result) => {
	      if (result.isConfirmed) {
	        // 如果用戶確認要儲存，則提交表單
	        document.getElementById('lastNoteForm').submit();
	      }
	    })
}
	
	function resetbutton() {
	    Swal.fire({
	      title: '確定要重置表單嗎？',
	      icon: 'warning',
	      showCancelButton: true,
	      confirmButtonText: '我確定！',
	      cancelButtonText: '取消',
	      reverseButtons: true
	    }).then((result) => {
	      if (result.isConfirmed) {
	        // 如果用戶確認要重置表單，則重置
	        document.getElementById('lastNoteForm').reset();
	      }
	    })
}
	</script>
	<script src="<c:url value='/js/jquery-3.6.3.min.js' />"></script>
</body>
</html>
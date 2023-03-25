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

	<!-- myspace -->
	<article id="myspace" class="wrapper style2">
		<div class="container-fluid " id="GoodByeLetter">
			<div class="container">
				<h1 class="display-4 mb-5 fw-bold">GoodBye Letter</h1>
				
				<div class="card">
					<div class="card-header-center bg-light text-black fw-bold">更新GoodBye Letter</div>
					<div class="card-body">

						<form:form action="${contextRoot}/LastNote/CRUD/put"
							modelAttribute="nId" method="put" id="lastNoteForm"> 

							<form:input type="hidden" class="form-control" path="noteId"
								id="noteId" value="${nId.noteId}" />

							<form:input type="hidden" class="form-control" path="FK_memberId"
								id="FK_memberId" value="${existing.memberId}" />

							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label fw-bold">收件人信箱</label>
								<form:input type="email" class="form-control"
									path="recipientEmail" id="recipientEmail"
									placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label fw-bold">第一驗證人信箱</label>
								<form:input type="email" class="form-control" path="verify1"
									id="verify1" placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label fw-bold">第二驗證人信箱</label>
								<form:input type="email" class="form-control" path="verify2"
									id="verify2" placeholder="name@example.com" />
							</div>
							<div class="mb-3">
								<label for="exampleFormControlTextarea1" class="form-label fw-bold">信件內容</label>
								<form:textarea class="form-control" id="notedetail" placeholder="想對那個人...說些什麼呢?可以說說你是誰，為什麼對方會收到這封信，以及想對他說什麼。"
									path="notedetail" rows="3" />
							</div>
							<div class="justify-content-center">
							<button class="btn btn-outline-success btn-lg" onclick="save()" type="button">送出</button>
							<button class="btn btn-outline-danger btn-lg" onclick="resetbutton()" type="button">重置</button>
							</div>
						</form:form>

						<br>
					</div>
				</div>
			</div>
		</div>
	</article>

	<!-- Scripts -->

	<script>
	function save() {
		const emailInputs = document.querySelectorAll('input[type="email"]');
		const emailRegex = /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,})+$/;
		for (let i = 0; i < emailInputs.length; i++) {
			var emailInput = emailInputs[i];
			email = emailInput.value
			if(email.trim() === ''){
				Swal.fire({
	      title: '欄位不可空白',
	      icon: 'warning'
	    });
	    return;
			}
			if(!emailRegex.test(emailInput.value)){
				Swal.fire({
	      title: '欄位必須為Email格式',
	      icon: 'warning'
	    });
	    return;
			}
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

</body>
</html>
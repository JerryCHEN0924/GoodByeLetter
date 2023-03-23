<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Donate支持</title>
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
		<!-- 	金流 -->
		<div class="container-fluid"> 
		<div class="container my-5 border shadow p-5 w-75">
			<H1>小額捐款支持GoodBye Letter</H1>
			<form id="idFormAioCheckOut" method="post" action="${contextRoot}/ECPay/ECPayServer"
				class="border shadow p-3 mb-5">
				<div class="row text-primary ">
					<div class="mb-3 col-sm-3">
						<label class="col-xs-12">Donate金額:</label> <input
							type="text" value="1000" name="TotalAmount" placeholder="請填寫整數，僅限新台幣。" class="form-control" required/>
					</div>
					<div class="mb-3 col-sm-4">
						<label class="col-xs-12">想對GoodBye Letter說的話:</label> 
						<input
							type="text" name="TradeDesc" value="Donate GoodBye Letter" placeholder="交易描述2。"
							class="form-control" required/> 請勿帶入特殊字元。
					</div>
					<div class="mb-3 col-sm-5">
						<label class="col-xs-12">項目名稱:</label> 
						<input
							type="text" name="ItemName" value="支持GoodBye Letter"
							class="form-control" required/>
					</div>
				</div>

				<button type="button" onclick="save()" class="btn btn-primary">送出表單</button>
			</form>

		</div>
		<!-- 	金流 -->
		</div>
	</article>

	<!-- Scripts -->
	<script>
	function save() {
		// const textInputs = document.querySelectorAll('input[type="text"]');
		// for (let i = 0; i < textInputs.length; i++) {
		// 	var textInput = textInputs[i];
		// 	text = textInput.value;
		// 	if(text.trim() === ''){
		// 		Swal.fire({
		//       title: '欄位不可空白',
		//       icon: 'warning'
		//     });
		//     return;
		// 	}
			
		// }
	    Swal.fire({
	      title: '確定要送出表單嗎？',
	      icon: 'success',
	      showCancelButton: true,
	      confirmButtonText: '確定！',
	      cancelButtonText: '取消',
	      reverseButtons: true
	    }).then((result) => {
	      if (result.isConfirmed) {
	        // 如果用戶確認要儲存，則提交表單
	        document.getElementById('idFormAioCheckOut').submit();
	      }
	    })
}
	</script>

</body>
</html>
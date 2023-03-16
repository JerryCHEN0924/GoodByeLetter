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
<title>GoodBye Letter編輯</title>
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
		<div class="container">
			<div class="card" id="">
				<h1>GoodBye Letter</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th style="width: 100px;">信件編號</th>
							<th style="width: 100px;">收件人</th>
							<th style="width: 100px;">驗證日期</th>
							<th>信件內容</th>
							<th style="width: 100px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="lastNote" items="${lastNotes}">
							<tr>
								<td>${lastNote.noteId}</td>
								<td>${lastNote.recipientEmail}</td>
								<td>${lastNote.verifyTime}</td>
								<td
									style="max-width: 500px; overflow: hidden; text-overflow: ellipsis;">${lastNote.notedetail}</td>
								<td>
									<div class="d-flex justify-content-center">
										<div class="mx-1">
											<form action="${contextRoot}/LastNote/CRUD" method="get">
												<input type="hidden" name="noteId"
													value="${lastNote.noteId}" />
												<button type="submit" class="btn btn-success btn-sm">編輯</button>
											</form>
										</div>
										<div>
											<form action="${contextRoot}/LastNote/CRUD/delete"
												method="post" id="delete-form${lastNote.noteId}">
												<input type="hidden" name="_method" value="delete" /> <input
													type="hidden" name="noteId" value="${lastNote.noteId}" />
												<button type="button" class="btn btn-outline-danger btn-sm"
													id="delete-btn"
													onclick="del(${lastNote.noteId})">刪除</button>
											</form>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</article>

	<!-- Scripts -->
	<script src="<c:url value='/assets/js/breakpoints.min.js' />"></script>
	<script src="<c:url value='/assets/js/browser.min.js' />"></script>
	<script src="<c:url value='/assets/js/jquery.min.js' />"></script>
	<script src="<c:url value='/assets/js/jquery.scrolly.min.js' />"></script>
	<script src="<c:url value='/assets/js/main.js' />"></script>
	<script src="<c:url value='/assets/js/util.js' />"></script>
	<script>
			
		function del(deleteId) {
		console.log(deleteId);
	    Swal.fire({
	      title: '確定要刪除嗎？',
	      text: '刪除後無法恢復！',
	      icon: 'warning',
	      showCancelButton: true,
	      confirmButtonText: '我確定！',
	      cancelButtonText: '取消',
	      reverseButtons: true
	    }).then((result) => {
	      if (result.isConfirmed) {
	        // 如果用戶確認要刪除，則提交表單
	        document.getElementById('delete-form'+deleteId).submit();
	      }
	    })
}
	</script>
</body>
</html>
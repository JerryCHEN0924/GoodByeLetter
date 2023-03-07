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
<link rel="stylesheet" href="../assets/css/mymain.css" />
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
			<!-- RYU -->
			<div class="row ">

				<div class="offset-sm-3 col-sm-6 my-3">

					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center ">

							<li class="page-item"><c:choose>

									<c:when test="${page.number > 0}">

										<li class="page-item"><a class="page-link"
											href="${contextRoot }/LastNote/edit?p=${page.number - 0}"
											aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
										</li>

									</c:when>

									<c:otherwise>

										<li class="page-item disabled"><a class="page-link"
											href="${contextRoot }/LastNote/edit?p=${page.number - 0}"
											aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
										</li>

									</c:otherwise>

								</c:choose></li>


							<c:forEach var="pageNumber" begin="1" end="${page.totalPages }">

								<c:choose>


									<c:when test="${page.number+1 != pageNumber }">

										<li class="page-item"><a class="page-link"
											href="${contextRoot }/LastNote/edit?p=${pageNumber }">${pageNumber }</a>
										</li>

									</c:when>

									<c:otherwise>

										<li class="page-item"><a class="page-link active"
											href="#"> ${pageNumber } </a></li>

									</c:otherwise>

								</c:choose>


							</c:forEach>



							<li class="page-item"><c:choose>

									<c:when test="${page.number+1 < page.totalPages}">

										<li class="page-item"><a class="page-link"
											href="${contextRoot }/LastNote/edit?p=${page.number + 2}"
											aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>

									</c:when>

									<c:otherwise>

										<li class="page-item disabled"><a class="page-link"
											href="${contextRoot }/LastNote/edit?p=${page.number + 2}"
											aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>

									</c:otherwise>

								</c:choose></li>

						</ul>
					</nav>

				</div>
			</div>

			<!-- RYU -->

			<!-- myspace -->
			<div class="card" id="">
				<h1>GoodBye Letter CRUD</h1>

				<c:forEach var="lastNote" items="${page.content}">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">信件編號</th>
								<th scope="col">收件人</th>
								<th scope="col">內容</th>
								<th scope="col">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td scope="row">${lastNote.noteId}</td>
								<td scope="row">${lastNote.recipientEmail}</td>
								<td scope="row">${lastNote.notedetail}</td>
								<td scope="row">
									<div class="d-flex justify-content-center">
										<div class="mx-1">
											<form action="${contextRoot}/LastNote/CRUD" method="get">
												<input type="hidden" name="noteId"
													value="${lastNote.noteId}" /> <input type="submit"
													class="btn btn-success btn-sm" value="編輯" />
											</form>
										</div>
										<div>
											<form action="${contextRoot}/LastNote/CRUD/delete" method="post">
												<input type="hidden" name="_method" value="delete" /> 
												<input type="hidden" name="noteId" value="${lastNote.noteId}" />
												<input type="submit" class="btn btn-outline-danger btn-sm "
													value="刪除" />
											</form>
										</div>
									</div>
								</td>

							</tr>

						</tbody>
					</table>
				</c:forEach>
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
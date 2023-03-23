<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
		.picture-container {
  			display: flex;
  			flex-wrap: wrap;
		}

		.picture-item {
  			display: flex;
  			flex-direction: column;
  			margin-right: 10px;
  			margin-bottom: 20px;
		}

		.picture-btn {
  			margin-right: 10px;
		}

		hr {
  			margin-top: 10px;
  			margin-bottom: 10px;
		}
		
	</style>
	
</head>
<body>
    <%@ include file="../layout/mynav.jsp"%>
    
    <article id="" class="wrapper style2" style="height:100vh">
		<div class="container-fluid " id="picture-list">
			<div class="container">
				<div><h1>查看圖片列</h1></div>
				<br>
				<table class="picture-container">
					<c:forEach items="${listPicture}" var="onePicture">
						<div class="picture-ltem">	
							<div>
								<button class="picture-btn" data-id="${onePicture.id}">查看圖片</button>
								<button class="delete-btn" data-id="${onePicture.id}">刪除圖片</button>
							</div>
							
							<hr class="">
							<div class="output-result" id="output-result"></div>
							<br>
						</div>
					</c:forEach>
					
				</table>
				<br>
				<a class="btn btn-outline-info" href="<c:url value='/customer/home/page'/>">${exis.account}返回</a>
			</div>
		</div>
	</article>
	<script>
	const pictureBtn = document.getElementsByClassName('picture-btn');

	for(i=0; i < pictureBtn.length; i++){
		pictureBtn[i].addEventListener('click', function(e){
			let onePicture = this.getAttribute('data-id');
			getPicture(onePicture);
		})
	}

	function getPicture(onePicture){
		axios.get('${contextRoot}/customer/picture/pictureIds?detailId=' + onePicture)//3/17 ?detailId=修改成pictureId
		.then(res => {
			console.log(res.data)
			htmlMaker(res.data)
		})
		.catch(err => {
            console.error(err);
        })
		function htmlMaker(data){
			let output = document.getElementById('output-result');
			let htmlstring='';
			htmlstring += "<img width='400px' height='300px' src='${contextRoot}/customer/picture/image?photoId=" + onePicture + "' />"
				
			output.innerHTML = htmlstring;
		}
	}
	const deleteBtn = document.getElementsByClassName('delete-btn');

	for(i=0; i < deleteBtn.length; i++){
    	deleteBtn[i].addEventListener('click', function(e){
        	let photoId = this.getAttribute('data-id');
        	deletePicture(photoId);
    	})
	}

	function deletePicture(photoId){
    	axios.delete('${contextRoot}/customer/pictures/delete?pictureId=' + photoId)
    	.then(res => {
        	console.log(res.data)
        	// 重新載入圖片列表
        	location.reload();
    	})
    	.catch(err => {
        	console.error(err);
    	})
	}
		</script>
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/jquery.scrolly.min.js"></script>
		<script src="assets/js/browser.min.js"></script>
		<script src="assets/js/breakpoints.min.js"></script>
		<script src="assets/js/util.js"></script>
		<script src="assets/js/main.js"></script>
		<script src="assets/js/jquery-3.6.3.min.js"></script>
		<script src="assets/js/main.js"></script>
		<!-- ##############################  3/16  ###################################### -->
		<script src="https://github.com/axios/axios.git"></script>
		<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
		<!-- ############################################################################ -->
		
</body>
</html>
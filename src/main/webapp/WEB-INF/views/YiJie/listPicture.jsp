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
</head>
<body>
    <%@ include file="../layout/mynav.jsp"%>
    
    <article id="" class="wrapper style2">
		<div class="container-fluid " id="picture-list">
			<div class="container">
				<div>查看圖片列</div>
				</div>
				<table>
					<c:forEach items="${listPicture}" var="onePicture">
						<tr>
							<td class="picture-text">${exis.account}上傳的圖片</td>
							<td><button class="picture-btn" data-id="${onePicture.id}">查看圖片</button></td>
						</tr>
					</c:forEach>
				</table>
							
			<div id="output-result"></div>
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
				
			
					htmlstring += "<img width='300px' src='${contextRoot}/customer/picture/image?photoId=" + onePicture + "' />"
				
				output.innerHTML = htmlstring;
			}
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
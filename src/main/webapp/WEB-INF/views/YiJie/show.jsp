<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- 增加form:form方法 -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <title>廣告展示</title>
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
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<style>
        .happy{
          width: 800px;
		  background-color: aliceblue;
          margin: 50px auto;
          border:solid 1px gray;
          overflow: hidden; /* 避免長方框下面顯示不正常 */
        }
        .bdcard{
          width: 300px;
          float:left; /* 圖片在左邊 */
          padding: 20px;
        }
        .bdcard img{
          display: block;
          width:100%;
        }
        .bdtext{
          float: right;  /* 文字在右邊 */
          width: 400px;
          padding: 20px 20px 0px 0px;
        }
	</style>
</head>
<body>

    <%@ include file="../layout/mynav.jsp"%>
	
	<article id="" class="wrapper style2">
		<div class="container">
			<div><h1>律師</h1></div>
			<hr class="">
				<table>
					<c:forEach items="${listPicture}" var="picture">
						<tr>
							<div class="happy">
								<div class="bdcard">
									<img src="${contextRoot}/customer/picture/lawyerimage?pictureId=${picture.id}" 
										width="600px" height="200px" alt="Lawyer Image">
								</div>
								<div class="bdtext" id="lawyerDetail">
									<p>公司名: ${picture.customerDetail.name}</p>
									<p>公司類型: ${picture.customerDetail.type}</p>
									<p>電子信箱: ${picture.customerDetail.email}<a href="mailto: ${picture.customerDetail.email}">發送郵件給我</a></p>
									<p>地址: ${picture.customerDetail.address}<a href="https://www.google.com.tw/maps/place/${picture.customerDetail.address}">查看地圖</a></p>
								</div>
							</div>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>
			<a class="btn btn-outline-info" href="<c:url value='/'/>">返回</a>
	</article>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function() {
    		$("img.lawyer-image").click(function() {
        		var pictureId = $(this).data("picture-id");
        		$.get("/customer/picture/lawyerdetail", {pictureId: pictureId}, function(data) {
            		var html = "";
            		for (var key in data) {
                		html += "<p>" + key + ": " + data[key] + "</p>";
            		}
            		$("#lawyerDetail").html(html);
        		});
    		});
		});
	</script>
	
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
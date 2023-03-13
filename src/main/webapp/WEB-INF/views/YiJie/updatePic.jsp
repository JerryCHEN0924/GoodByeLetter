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
        <title>圖片上傳</title>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="assets/css/mymain.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
		rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
		crossorigin="anonymous" />
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
		crossorigin="anonymous">
	</script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

    <%@ include file="../layout/mynav.jsp"%>

    <article id="" class="wrapper style2">
        <div class="container-fluid">
            <div class="container">
                <h1>上傳圖片頁面</h1>
                <br>
                <form id="picture-form" method="post" enctype="multipart/form-data">
                    <div>
                        <label for="picture-photos">上傳圖片</label>
                        <input type="file" id="picture-photos" name="files" multiple>
                    </div>
                    <button type="submit">送出</button>
                </form>
                <div id="upload_result"></div>

            </div>
        </div>
    </article>
<script>
    document.getElementById('picture-form').addEventListener('submit', function(e){
        e.preventDefault();

        let picturePhotos = document.getElementById('picture-photos').files;

        let formdata = new FormData();
        for(let i=0; i< picturePhotos.length; i++){
            formdata.append('files', picturePhotos[i])
        }

        axios.post('${contextRoot}/picture/updata1', formdata,{
            headers:{
                'Content-Type':'multipart/form-data'
            }
        })
        .then( res =>{
            console.log(res)
            let reBlock = document.getElementById('upload_result');
            reBlock.innerHTML = res.data;
        })
        .catch( err=>{
            console.log(err)
            let reBlock = document.getElementById('upload_result');
            reBlock.innerHTML = '上傳失敗'
        })
    })
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
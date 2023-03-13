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
      <h1>上傳圖片頁面2</h1>
      <br>
      <form id="picture2-form" method="post" enctype="multipart/form-data">
        <div>
          <label for="picture-photo">上傳圖片</label>
          <input type="file" id="picture-photo" name="file" multiple>
        </div>
        
        <button type="submit">送出</button>
      </form>
      
      <div id="upload_result"></div>
    </div>
  </div>
</article>
    
    <script >
    document.getElementById('picture2-form').addEventListener('submit', function(e){
  e.preventDefault();
  const allowedTypes = ['image/jpeg', 'image/png', 'image/gif'];
  let picture = document.getElementById('picture-photo').files[0];
  if(allowedTypes.includes(picture.type)){
    let reader = new FileReader();
    reader.readAsDataURL(picture);
    reader.onload = function(){
      let formData = new FormData();
      formData.append('file', picture);
      axios.post(`${contextRoot}/picture/upload`, formData)
      .then(res => {
        console.log(res);
        let reBlock = document.getElementById('upload_result');
        reBlock.innerHTML = res.data;
      })
      .catch(err => {
        console.log(err);
        let reBlock = document.getElementById('upload_result');
        reBlock.innerHTML = '上傳失敗';
      });
    };
  }else {
    alert('Invalid file type. Please upload a JPEG, PNG, or GIF image.');
  }
});

    </script>
</body>
</html>
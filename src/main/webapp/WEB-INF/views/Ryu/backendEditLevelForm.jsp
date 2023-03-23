<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯權限等級 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>






<div class="container text-center">






<div class="row">

<div class="offset-sm-3 col-sm-6">



</div>
</div>



<hr class="border border-dark border-3 opacity-75">






<div class="table-responsive border border-4 rounded-3 bg-secondary text-white p-5">

<%-- <span class="text-center fs-3 text-warning"> ${backendHomeMessages} </span> --%>



<div class="row">

<div class="offset-sm-2 col-sm-8">


<div class="card text-dark mt-5">

  <div class="card-header">
    編輯權限等級
  </div>
  
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/topGun/level/editPost" modelAttribute="level" method="put" id="edit01Form">
		
		<form:input path="plevel" type="hidden" />
		
		
		<div class="mb-3 row">
		    <label for="inputPlevel" class="col-sm-2 col-form-label">編號</label>
		    <div class="col-sm-10">
		    	<input name="plevel" class="form-control" id="inputPlevel" value="${level.plevel}" disabled />
		    </div>
		  </div>
		
		
		
		<div class="mb-3 row">
		    <label for="inputLevelName" class="col-sm-2 col-form-label">權限名稱</label>
		    <div class="col-sm-10">
		    	<form:input path="levelName" class="form-control" id="inputLevelName" />
		    </div>
		  </div>
		  
		  
  		
  		
  		
  		
  		<div class="mt-3">
  		
<!-- 	  		<button type="submit" class="btn btn-primary">送出</button> -->
	  		<button type="button" onclick="edit01()" class="btn btn-primary">送出</button>
	  		
  		</div>
		
		
		
	</form:form>
  	
  	
  	
  </div>
</div>



</div>
</div>






<div class="row my-5">
		
			<div class="offset-sm-5 col-sm-2">
		
				<form action="${contextRoot}/topGun" method="get" >
					<input type="submit" class="btn btn-outline-warning" value="回後台首頁" />
				</form>
		
			</div>
			
  		</div>



</div>

<hr class="border border-dark border-3 opacity-75">







<script>
function edit01() {
	
    Swal.fire({
      title: '確定要修改嗎？',
      icon: 'success',
      showCancelButton: true,
      confirmButtonText: '確定！',
      cancelButtonText: '取消',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        // 如果用戶確認要儲存，則提交表單
        document.getElementById('edit01Form').submit();
      }
    })
    
}


</script>









</div>
</body>
</html>
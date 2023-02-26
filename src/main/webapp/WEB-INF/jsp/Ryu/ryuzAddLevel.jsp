<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增會員 Page</title>
</head>
<body>
<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<div class="container w-75 text-center">





<div class="row ">

<div class="offset-sm-3 col-sm-6 my-3">

<h1>新增會員 Page</h1>

</div>

</div>







<div class="row ">

<div class="offset-sm-3 col-sm-6 ">



<div class="card">

  <div class="card-header">
    新增等級資料
  </div>
  
  <div class="card-body">
  	
	<form:form action="${contextRoot}/topGun/LevelByRyu/post" modelAttribute="levelByRyu" method='POST'>
  		
  		<div class="input-group">
  			
  			<form:input path="levelName" class="form-control" rows="" cols="" />
  		</div>
  		
  		<div class="mt-3">
	  		<button type="submit" class="btn btn-primary">送出</button>
  		</div>
  		
  	</form:form>
  	
  	
  </div>
  
  
</div>





</div>

</div>








<div class="row mt-3">

<div class="offset-sm-3 col-sm-6 ">



<div class="card">
  <div class="card-header">
  </div>
  <div class="card-body">
  	
  	
  </div>
</div>


</div>
</div>








				<form method="post" action="<c:url value='/RegisterMemberServletTemp' />">
					
					<div class="mb-3">
						<label for="name" class="form-label">帳號</label><font color='red' size='-1'>${ErrorMsg.username}</font>
						<input class="form-control" type="text" name="username" value="${param.username }" />
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">密碼</label><font color='red' size='-1'>${ErrorMsg.password}</font>
						<input class="form-control" type="text" name="password" value="${param.password }" />
					</div>
					<div class="mb-3">
						<label for="birthdate" class="form-label">暱稱</label><font color='red' size='-1'>${ErrorMsg.codename}</font>
						<input class="form-control" type="text" name="codename" value="${param.codename }" />
					</div>
					<div class="mb-3">
						<label for="gender" class="form-label">性別</label><font color='red' size='-1'>${ErrorMsg.gender}</font>
						<input class="form-control" type="text" name="gender" value="${param.gender }" />
					</div>
					<div class="mb-3">
						<label for="birthday" class="form-label">生日</label><font color='red' size='-1'>${ErrorMsg.birthday}</font>
						<input class="form-control" type="text" name="birthday" value="${param.birthday }" />
					</div>
					<div class="mb-3">
						<label for="phone" class="form-label">電話號碼</label><font color='red' size='-1'>${ErrorMsg.phone}</font>
						<input class="form-control" type="text" name="phone" value="${param.phone }" />
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label><font color='red' size='-1'>${ErrorMsg.email}</font>
						<input class="form-control" type="text" name="email" value="${param.email }" />
					</div>					
					<div class="mb-3">
						<button type="submit" class="btn btn-danger">註冊</button>
						<a class="btn btn-primary" href="<c:url value=''/>">返回首頁</a>
					</div>
					
				</form>
			</div>			
		</div>
	</div>	










</div>
</body>
</html>
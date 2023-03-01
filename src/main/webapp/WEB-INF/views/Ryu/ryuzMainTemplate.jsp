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
<%-- <jsp:include page="../layout/backendNavbar.jsp"></jsp:include> --%>

<div class="container w-75">
<h1>新增會員 Page</h1>


<div class="row ">

<div class="offset-sm-3 col-sm-6 ">



<div class="card">
  <div class="card-header">
    新增訊息
  </div>
  <div class="card-body">
  	
  	<form:form action="${contextRoot}/message/post" modelAttribute="messages">
  		
  		<div class="input-group">
  			
  			<form:textarea path="text" class="form-control" rows="" cols="" />
  			
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
    訊息時間： <span><fmt:formatDate pattern="yyyy-MM-dd , a hh:mm:ss EEEE" value="${latestMsg.added}" /></span>
  </div>
  <div class="card-body">
  	
	${latestMsg.text}
  	
  </div>
</div>


</div>
</div>









</div>
</body>
</html>
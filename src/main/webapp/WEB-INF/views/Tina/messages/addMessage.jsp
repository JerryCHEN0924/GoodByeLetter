<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>新增訊息</title>
</head>
<body>
	<jsp:include page="../layout/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>新增訊息page</h1>

		<div class="card">
			<div class="card-header">新增訊息</div>
			<div class="card-body">
				<form:form action="${ contextRoot }/message/post" modelAttribute="messages">
					<div class="input-group">
						<form:textarea path="text" class="form-control" rows="" cols="" />
					</div>
					<br/>
					<button type="submit" class="btn btn-primary">送出</button>
				</form:form>
				
			</div>
		</div>
	</div>
</body>
</html>
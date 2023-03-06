<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加回覆</title>
</head>
<body>
<div class="card">
				<form:form action="${contextRoot}/comment/add" method="get" modelAttribute="newboard">
					<div class="card-body">
						<form:input path="title" class="form-control" placeholder="title" />
						<button type="submit" class="btn btn-primary">送出</button>
					</div>
				</form:form>
			</div>
			
			
<div class="card">
				<form:form action="${contextRoot}/comment/add" method="get" modelAttribute="addComment">
					<div class="card-body">
						<form:input path="reply" class="form-control" placeholder="回覆" />
						<button type="submit" class="btn btn-primary">送出</button>
					</div>
				</form:form>
			</div>


</body>
</html>
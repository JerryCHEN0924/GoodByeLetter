<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/mymain.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>  
</head>

<body>
<%@ include file="../layout/mynav.jsp"%>

<%-- <c:if test="${pageContext.request.userPrincipal != null}"> --%>
<!--   <a href="/update">更新資料</a> -->
<%-- </c:if> --%>
<%-- <c:if test="${pageContext.request.userPrincipal == null}"> --%>
<!--   <a href="/register">註冊</a> -->
<%-- </c:if> --%>

        <!--login  login_form_class-->
        <article  class="wrapper style2" style="height:100vh">
        <div class="container-fluid" id="login_form">
            <h1>登入</h1>
            <form id="login" action="${contextRoot}/register/login" method="post">
                <input type="text" required placeholder="您的帳號" maxlength="8" minlength="4" name="account"><br>
                <input type="password" required placeholder="您的密碼" maxlength="8" minlength="4" name="password"><br>
                <button type="submit" id="login_submit">
                    <h6 id="login_h6">登入</h6>
                </button>
            </form>


            <a href="">忘記密碼</a>

        </div>
        </article>

    

<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.3.min.js"></script>
    
</body>
</html>
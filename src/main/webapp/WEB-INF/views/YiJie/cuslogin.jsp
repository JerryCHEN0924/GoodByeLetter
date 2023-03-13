<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>廠商登入頁面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
</head>

<body>


<%@ include file="../layout/mynav.jsp"%>
	
        <!--login  login_form_class-->
    <article  class="wrapper style2" style="height:100vh">
        <div class="container" id="login_form">
        	<div>
        		<h3>廠商登入頁面</h3>
        	</div>
            <form id="login" action="${contextRoot}/customer/login" method="post">
                <input type="text" placeholder="您的帳號" name="account"><br>
                <input type="text" placeholder="您的密碼" name="password"><br>
                <button type="submit" id="login_submit">
                    <h6 id="login_h6">登入</h6>
                </button>
            </form>
        </div>
    </article>



	<!--nav close-->

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
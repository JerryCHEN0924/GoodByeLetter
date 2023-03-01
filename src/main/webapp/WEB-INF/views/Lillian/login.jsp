<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>  
</head>

<body>
<%@ include file="../layout/mynav.jsp"%>
${contextRoot}/register/login
	
        <!--login  login_form_class-->
        <div class="container" id="login_form">
            <h1>登入1</h1>
            <form id="login" action="${contextRoot}/register/login" method="post">
                <input type="text" placeholder="您的帳號" name="account"><br>
                <input type="text" placeholder="您的密碼" name="password"><br>
                <button type="submit" id="login_submit">
                    <h6 id="login_h6">登入</h6>
                </button>
            </form>
            <button type="submit" id="login_submit">
                <h6 id="login_cencel">sorry 我沒有要登入</h6>
            </button>
            <a href="">忘記密碼</a>
            <a href="">還沒有帳號，我要申請</a>
        </div>

        <!--nav close-->

<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-3.6.3.min.js"></script>
    <script>

    
        const nav = document.getElementById('nav');
        const nav_login = document.getElementById("nav_login");
        const login_form = document.getElementById("login_form");
        const login_cencel = document.getElementById('login_cencel');
        // 按下Navbar登入 顯示login_form
        nav_login.addEventListener('click', function () {
            login_form.classList.add('login_show');
            console.log('顯示login_form')
        })
        // 關閉login_form
        login_cencel.addEventListener('click', function () {
            login_form.classList.remove('login_show');
            console.log('移除login_form');
        })



//         //調整nav顏色
//         window.addEventListener('scroll', function () {
//             if (window.scrollY > 50) {
//                 nav.classList.add('narbar_background_color');

//             } else {
//                 nav.classList.remove('narbar_background_color');

//             }
//         });

    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>  
</head>

<body>
<%@ include file="../layout/mynav.jsp"%>

        <!--login-->
        <div class="container login_form_class" id="login_form">
            <h1>登入</h1>
            <form id="login" action="${contextRoot}/register/login" method="post">
                <input type="text" placeholder="您的帳號" name="loginAccount"><br>
                <input type="text" placeholder="您的密碼" name="loginPassword"><br>
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
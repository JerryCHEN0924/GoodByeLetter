<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .login_form_class {
            display: none;
            position: fixed;
            background-color: rgb(250, 235, 215, 0.8);
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            width: 40%;
            height: 60%;
            margin: auto;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            font-size: 20px;
            z-index: 200;
        }

        .login_show {
            display: flex;
        }

        #login_submit {
            /* display: flex;
            justify-content: center;
            align-items: center; */
            margin: 0 auto;
            height: 40px;
            border-radius: 10px;
        }

        /* #login_h6 {
            text-align: center;
            margin: auto;
        } */
        a {
            margin: 10px auto 0px auto;
            font-size: 15px;
        }
    </style>

</head>

<body>

    <div id="mynavbar"></div>
    
        <!--Nav Bootstrap-->
        <nav class="navbar .navbar-fixed-top navbar-expand-xl " id="nav">
            <div class="container-fluid">
                <a class="navbar-brand narbar_text_color" href="#">OurBrand</a>

                <div class="collapse navbar-collapse show" id="navbarWithDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active narbar_text_color" aria-current="page" href="myindex.html">首頁</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link narbar_text_color" href="#">Features</a>
                        </li>


                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle narbar_text_color" href="#" id="navbarDropdownMenuLink"
                                role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                合作夥伴
                            </a>
                            <ul class="dropdown-menu  " aria-labelledby="navbarDropdownMenuLink"
                                id="dropdown-menu_company">
                                <li><a class="dropdown-item narbar_text_color" href="mycompany.html">諮商所</a></li>
                                <li><a class="dropdown-item narbar_text_color" href="#">律師事務所</a></li>
                                <li><a class="dropdown-item narbar_text_color" href="#">生命禮儀</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle narbar_text_color" href="#" id="navbarDropdownMenuLink"
                                role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                登入
                            </a>
                            <ul class="dropdown-menu  " aria-labelledby="navbarDropdownMenuLink"
                                id="dropdown-menu_login">

                                <li><a class="dropdown-item narbar_text_color" href="login1"> 登入 </a></li>
                                <li><a class="dropdown-item narbar_text_color" href="register1"> 註冊 </a></li>
                                <li><a class="dropdown-item narbar_text_color" href="mySpace"> 個人空間 </a></li>

                            </ul>
                        </li>
                         <li class="nav-item ">
                            <a class="nav-link narbar_text_color" href="#">聊天室</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link narbar_text_color" href='<c:url value="/LastNote" />' tabindex="-1"
                                aria-disabled="false">GoodBye Letter</a>
                        </li>
                        
                        <li class="nav-item ">
                            <a class="nav-link disabled narbar_text_color" href="#" tabindex="-1"
                                aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
      
      

        <!--login-->
<!--         <div class="container login_form_class" id="login_form"> -->
<!--             <h1>登入</h1> -->
<!--             <form> -->
<!--                 <input type="text" placeholder="您的帳號"><br> -->
<!--                 <input type="text" placeholder="您的密碼"><br> -->
<!--                 <button type="submit" id="login_submit"> -->
<!--                     <h6 id="login_h6">登入</h6> -->
<!--                 </button> -->
<!--             </form> -->
<!--             <button type="submit" id="login_submit"> -->
<!--                 <h6 id="login_cencel">sorry 我沒有要登入</h6> -->
<!--             </button> -->
<!--             <a href="">忘記密碼</a> -->
<!--             <a href="">還沒有帳號，我要申請</a> -->
<!--         </div> -->

<!--         nav close -->


    <script>


//         const nav = document.getElementById('nav');
//         const nav_login = document.getElementById("nav_login");
//         const login_form = document.getElementById("login_form");
//         const login_cencel = document.getElementById('login_cencel');
//         // 按下Navbar登入 顯示login_form
//         nav_login.addEventListener('click', function () {
//             login_form.classList.add('login_show');
//             console.log('顯示login_form')
//         })
//         // 關閉login_form
//         login_cencel.addEventListener('click', function () {
//             login_form.classList.remove('login_show');
//             console.log('移除login_form');
//         })



        //調整nav顏色
        window.addEventListener('scroll', function () {
            if (window.scrollY > 50) {
                nav.classList.add('narbar_background_color');

            } else {
                nav.classList.remove('narbar_background_color');

            }
        });

    </script>
</body>
</html>
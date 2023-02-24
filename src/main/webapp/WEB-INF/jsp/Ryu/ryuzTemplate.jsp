<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>樣板空白頁</title>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>註冊畫面</title>
<link rel="stylesheet" href="assets/css/mymain.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
        crossorigin="anonymous"></script>
<style>
        /* * {
            border: 3px solid blue;
        } */

        #myspace {
            width: 100%;
            height: 100vh;
        }



        #space {
            height: 20vh;
        }

        #registerTitle {
            /* border: 3px solid blue; */
            color: #453c26;
            font-weight: 900;
            font-size: 50px;
            text-align: center;
        }
</style>

</head>
<body>

<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>

<h1>樣板空白頁</h1>

    <div id="mynavbar"></div>
    <div id="outline">
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
                                <li><a class="dropdown-item narbar_text_color" id="nav_login"> 登入 </a></li>
                                <li><a class="dropdown-item narbar_text_color" href="myregister.html"> 註冊 </a></li>
                                <li><a class="dropdown-item narbar_text_color" href="mySpace.html"> 個人空間 </a></li>
                            </ul>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link disabled narbar_text_color" href="#" tabindex="-1"
                                aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- myspace -->
        <article id="myspace" class="wrapper style2">
            <div class="container-fluid " id="register">
                <div id="space"></div>

            </div>
        </article>
    </div>











    <!-- Scripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/jquery.scrolly.min.js"></script>
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>

    <script>



        const nav = document.getElementById('nav');
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
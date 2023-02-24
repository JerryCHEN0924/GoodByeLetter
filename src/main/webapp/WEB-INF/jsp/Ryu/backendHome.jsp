<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>後臺管理介面</title>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    
    
    
<link rel="stylesheet" href="assets/css/mymain.css" />
    
    
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
        crossorigin="anonymous"></script>
        
        
        
        
        
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


<jsp:include page="../layout/backendNavbar.jsp"></jsp:include>





        
        
        
        
        
        
        <!-- <nav class="navbar .navbar-fixed-top navbar-expand-xl " id="nav">
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
                                <li><a class="dropdown-item narbar_text_color" href="#">諮商所</a></li>
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
                                <li><a class="dropdown-item narbar_text_color" href="#" id="nav_login"> 登入 </a></li>
                                <li><a class="dropdown-item narbar_text_color" href="myregister.html"> 註冊 </a></li>
                            </ul>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link disabled narbar_text_color" href="#" tabindex="-1"
                                aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav> -->
        
        
        
        
        
        
        
        
        

        <!--login-->
        <div class="container login_form_class login_show" id="login_form">
            <h1>登入</h1>
            <form>
                <input type="text" placeholder="您的帳號"><br>
                <input type="text" placeholder="您的密碼"><br>
                <button type="submit" id="login_submit">
                    <h6 id="login_h6">登入<h6>
                </button>
            </form>
            <button type="submit" id="login_submit">
                <h6 id="login_cencel">sorry 我沒有要登入<h6>
            </button>
            <a href="">忘記密碼</a>
            <a href="">還沒有帳號，我要申請</a>
        </div>

        <!--nav close-->









	<div>
        <!-- top1 -->
        <article id="top1">
            <div class="container-fluid article1 " id="topic">
                <div>
                    <div id="topicSpace"></div>
                    <h1 id="topicContent">寫下想說的話</h1>
                </div>
            </div>
        </article>
    </div>










    <!--work-->
    <article id="work" class="wrapper style2">
        <div class="container">
            <header>
                <h2>關於我們/這個網站</h2>
                <p>這裡應該會寫這個網站的資訊/我們的創作理念之類</p>
            </header>
            <div class="row aln-center">
                <div class="col-4 col-6-medium col-12-small">
                    <section class="box style1">
                        <span class="icon featured fa-comments"></span>
                        <h3>Consequat lorem</h3>
                        <p>Ornare nulla proin odio consequat sapien vestibulum ipsum primis sed amet consequat lorem
                            dolore.</p>
                    </section>
                </div>
                <div class="col-4 col-6-medium col-12-small">
                    <section class="box style1">
                        <span class="icon solid featured fa-camera-retro"></span>
                        <h3>Lorem dolor tempus</h3>
                        <p>Ornare nulla proin odio consequat sapien vestibulum ipsum primis sed amet consequat lorem
                            dolore.</p>
                    </section>
                </div>
                <div class="col-4 col-6-medium col-12-small">
                    <section class="box style1">
                        <span class="icon featured fa-thumbs-up"></span>
                        <h3>Feugiat posuere</h3>
                        <p>Ornare nulla proin odio consequat sapien vestibulum ipsum primis sed amet consequat lorem
                            dolore.</p>
                    </section>
                </div>
            </div>
            <footer>
                <p>Lorem ipsum dolor sit sapien vestibulum ipsum primis?</p>
                <a href="#portfolio" class="button large scrolly">See some of my recent work</a>
            </footer>
        </div>
    </article>
    
    
    
    
    
    
    

    <!--letter animation-->

    <article id="index_letter">
        <div class="container-fluid article1 " id="letter_animation">
            <div class="container ">
                <div id="letterSpace"></div>
                <h1 id="index_letter_container">寫信</h1>
                <form style="margin: auto 20%">
                    <input type="text" class="form-control" placeholder="主旨" /><br>
                    <input type="text" class="form-control" placeholder="收件者Email" /><br>
                    <textarea class="form-control" placeholder="內文"></textarea>
                    <input type="submit" value="我要寫信" id="index_letter_submit"></input>

                </form>

            </div>
        </div>
    </article>






    <!-- Scripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/jquery.scrolly.min.js"></script>
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>

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
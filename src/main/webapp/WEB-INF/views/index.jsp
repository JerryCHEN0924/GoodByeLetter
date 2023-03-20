<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:set var="contextUser" value="${pageContext.request.userPrincipal}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>首頁</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">


<style>
/* font for design-right */
@import
	url('https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap')
	;
/******************navbar*********************/
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	/* font-family: 'Patua One', cursive; */
}



/************article  *****************/
article {
	/* border: 3px solid red; */
	position: relative;
	width: 100vw;
	height: 100vh;
	margin: 0 auto;
	padding: 0px;
}

/* ***wrapper**** */
.wrapper {
	height: 100vh;
	background-image: url("assets/css/images/bg.png");
	box-shadow: inset 0px 1px 0px 0px rgba(0, 0, 0, 0.05), inset 0px 2px 3px
		0px rgba(0, 0, 0, 0.1);
	padding: 8em 0 8em 0;
	text-align: center;
}

.wrapper.style2 {
	background-color: #fafafa;
	text-shadow: 1px 1px 0px #fff;
}

/***box**/
.box {
	background: #fff;
	box-shadow: inset 0px 0px 0px 1px rgb(0 0 0/ 15%), 0px 2px 3px 0px
		rgb(0 0 0/ 10%);
	text-align: center;
	padding: 2em;
}

/***mydesign****/
.mydesign {
	/* position: relative;
             display: flex; */
	position: relative;
	width: 100vw;
	height: 100vh;
	display: flex;
}

/***mydesign--left****/
.mydesign .leftside {
	position: relative;
	flex: 50%;
	/* 文字置中*/
	display: flex;
	align-items: center;
	justify-items: center;
}

.mydesign .leftside .words {
	/* border: 3px green solid; */
	width: 100%;
	text-align: center;
	align-items: center;
	justify-items: center;
	line-height: 50px;
}

.mydesign .leftside .words h1 {
	font-size: 4em;
	font-weight: 900;
	letter-spacing: 5px;
}

/* 裝按鈕的容器 */
.containbtn {
	justify-content: center;
	position: relative;
	display: flex;
}

/* 按鈕 */
.designbtn {
	color: #1c1c1c;
	position: relative;
	font-size: 2em;
	padding: 12px 40px;
	user-select: none;
	transition: 0.5s;
	text-decoration: none;
	overflow: hidden;
}

.designbtn:hover {
	color: #fff;
}

.designbtn span {
	position: absolute;
	border: 3px solid rgb(33, 139, 244);
	transform: translate(-50%, -50%);
	/* 就算被蓋住也可以有效果 */
	pointer-events: none;
	border-radius: 50%;
	animation: animate 2s ease-in-out;
}

@keyframes animate { 
0% {
	width: 0px;
	height: 0%;
}
 100% {
     width: 500px;
     height: 500px;
}
}
/* 個別按鈕顏色 */
#designbtnLetter {
	background: linear-gradient(to right, #f9d423 0%, #ff4e50 100%);
}

#designbtnLetter:hover {
	background-image: linear-gradient(-225deg, #2CD8D5 0%, #6B8DD6 48%, #8E37D7 100%);
}

#designbtnChat {
	/* #fceabb, #f8b500 */
	background: linear-gradient(to right, #fceabb, #f8b500);
}

#designbtnChat:hover {
	background-image: linear-gradient(-225deg, #03001e, #7303c0, #ec38bc, #fdeff9);
}

#designbtnConsult {
	background: linear-gradient(to right, #3d7eaa, #3daaa5, #ffe47a);
}

#designbtnConsult:hover {
	background: linear-gradient(to right, #feac5e, #c779d0, #4bc0c8);
}

/* *******mydesign --right************** */
.mydesign .rightside {
	position: relative;
	flex: 50%;
	display: flex;
}

.rightLetter {
	width: 100%;
	height: 100%;
	justify-content: center;
	margin: auto;
}

</style>

</head>
<body>
	<%@ include file="layout/mynav.jsp"%>	

    <!-- letter animation  -->
    <article id="">
        <div class="mydesign">
            <div class="leftside " style="background: #fafafa; ">
                <div class="words">
                    <ion-icon name="heart" id="heart" style="font-size: 4em; color: #f26d48;"></ion-icon>
                    <h1>好好說再見</h1>
                    <p>傳達來不及說、開不了口的文字給自己所愛的人</p>
                    <div class="containbtn">
                        <a href="<c:url value='/LastNote'/>"class="designbtn" id="designbtnLetter" data-delay="500">寫信</a>
                    </div>
                </div>
            </div>
            <div class="rightside" data-aos="fade-left"
                style="display: flex; flex-direction: column;  background: rgba(239, 163, 138, 0.3); background-image: url('assets/css/images/bg.png');">
                <h1  style=" color: rgba(189, 112, 108, 1); font-size: 5em; text-align: center;
                font-family: 'Kaushan Script' , cursive;">
                    For<br> Someone<br> Special</h1>
                <div style="width:50%; height: auto;   margin:auto;  transform: rotate(-15deg);">
                    <!-- border: 3px solid red; -->
                    <img src="images/pixelEnvolop.png" class=" rightLetter" >
                </div>
            </div>
        </div>
    </article>

    <!-- shareIdea animation  -->
    <article id="">
        <div class="mydesign">

            <div class="rightside" data-aos="flip-up"
                style="display: flex; flex-direction: column; background: rgba(249, 212, 35, 0.45 ); background-image: url('assets/css/images/bg.png');">
                <h1 style=" color: rgba(126, 64, 196, 0.8); font-size: 5em; text-align: center;
                font-family: 'Kaushan Script' , cursive;">
                    Share<br> your<br> Thought</h1>
                <div style="width:90%; height: auto;   margin:auto;">
                    <!-- border: 3px solid red; -->
                    <img src="images/everyidea.png" class="rightLetter">
                </div>
            </div>
            <div class="leftside ">
                <div class="words">
                    <span class="material-icons"
                        style="font-size: 4em; color:rgba(230, 161, 42, 0.85)">insert_comment</span>
                    <h1>分享想法</h1>
                    <p>傳達來不及說、開不了口的文字給自己所愛的人</p>
                    <div class="containbtn">
                        <a href="<c:url value='/board/page'/>" class="designbtn" id="designbtnChat" data-delay="500">交流區</a>
                    </div>
                </div>
            </div>
        </div>
    </article>

    <!-- consult animation  -->
    <article id="">
        <div class="mydesign">
            <div class="leftside">
                <div class="words">
                    <span class="material-icons" style="font-size: 4em; color:rgba(87, 92, 233, 0.748) ;">
                        live_help
                    </span>
                    <h1>諮詢專業人士</h1>
                    <p>傳達來不及說、開不了口的文字給自己所愛的人</p>
                    <div class="containbtn">                    
                        <a href="<c:url value='/customer/page' />" class="designbtn" id="designbtnConsult" data-delay="500" >諮詢</a>
                    </div>
                </div>
            </div>
            <div class="rightside" data-aos="zoom-out"
                style="display: flex; flex-direction: column; background-color: rgba(61, 126, 170, 0.9); background-image: url('assets/css/images/bg.png');">
                <h1 style=" color: rgb(255, 255, 255); font-size: 5em; text-align: center;
                    font-family: 'Kaushan Script' , cursive;">
                    For<br> Someone<br> Special</h1>
                <div style="width:70%; height: auto;   margin:auto; ">
                    <!-- border: 3px solid red; -->
                    <img src="images/help-desk.png" class="rightLetter">
                </div>
            </div>
        </div>
    </article>

<!--work-->
    <article id="">
        <div class="container-fluid  wrapper style2">
            <div class="container" style="margin: auto auto;">
                <!-- border: 3px solid black; -->
                <header>
                    <h1 style=" font-size: 3em;font-weight: 700;letter-spacing: 5px;">關於我們/這個網站</h1>
                    <p>這裡應該會寫這個網站的資訊/我們的創作理念之類</p>
                </header>
                <div class="row aln-center" style="margin: auto 0;">
                    <div class=" col-4 col-6-medium col-12-small" data-aos="zoom-in">
                        <section class="box style1">
                            <span class="material-icons" style="font-size:1000%; color:rgb(220, 91, 27,0.8) ">
                                diversity_1</span>
                            <h2>留話給跟身邊的人</h2>
                            <p>Ornare nulla proin odio consequat sapien vestibulum ipsum primis sed amet
                                consequat lorem
                                dolore.</p>
                        </section>
                    </div>
                    <div class="col-4 col-6-medium col-12-small" data-aos="zoom-in">
                        <section class="box style1">
                            <!-- color:rgba(216, 163, 238, 0.8) -->
                            <span class="material-icons" style="font-size:1000%; color:rgba(249, 212, 35, 0.8)">
                                auto_awesome </span>
                            <h2>分享想法</h2>
                            <p>Ornare nulla proin odio consequat sapien vestibulum ipsum primis sed amet
                                consequat lorem
                                dolore.</p>
                        </section>
                    </div>

                    <div class="col-4 col-6-medium col-12-small" data-aos="zoom-in">
                        <section class="box style1">
                            <span class="material-icons"
                                style="font-size: 1000%; color: rgb(107, 141, 214, 0.8)">badge</span>
                            <h2>諮詢專業人士</h2>
                            <!-- <span class="material-icons"
                                style="font-size:1000%; color:rgb(107, 141, 214,0.8)">mark_as_unread</span>
                            <h2>說明後事處理形式</h2> -->
                            <p>Ornare nulla proin odio consequat sapien vestibulum ipsum primis sed amet
                                consequat lorem
                                dolore.</p>
                        </section>
                    </div>
                </div>
                <footer style="margin:50px 0;">
                    <p>Lorem ipsum dolor sit sapien vestibulum ipsum primis?</p>
                </footer>
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
	<script src="assets/js/main.js"></script>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>



	<script>
	
	 //AOS animation on slide 
	   AOS.init();
	//特殊按鈕
    let designbtn = document.querySelectorAll(".designbtn");
    designbtn.forEach(designbtn => {
        designbtn.onclick = function (e) {
        	 // 取消預設行為
            e.preventDefault();
        	 
            //抓取用戶點擊位置
            let rect = e.target.getBoundingClientRect();
            //clientX,Y只會計算當前畫面距離,不會計算已被捲動的距離; pageX,pageY會計算已被捲動的距離
            let x = e.clientX - rect.left;
            let y = e.clientY - rect.top;
            console.log(`x = ${x}, y = ${y}`);
            //隨機變色
            let color = "#" + Math.floor(Math.random() * 0xFFFFFF).toString(16)

            //增加水波紋(span)
            let ripples = document.createElement('span');
            ripples.style.left = x + "px";
            ripples.style.top = y + "px";
            ripples.style.borderColor = color;
            this.appendChild(ripples);

            setTimeout(() => {
                ripples.remove()
            }, 2000)
            
            
            //////增加延遲效果//不在裡面會無效
            const delayLinks = document.querySelectorAll("a[data-delay]");

            function delayedRedirect(link) {
              const delayTime = link.dataset.delay;
              console.log(delayTime);
              
              setTimeout(() => {
                window.location.href = link.href;
              }, delayTime);
            }

            delayLinks.forEach(link => {
              link.addEventListener("click", event => {
                event.preventDefault();
                delayedRedirect(link);
              });
            });
           ////end///// 
        }
    })
    
     
 
	</script>

</body>
</html>
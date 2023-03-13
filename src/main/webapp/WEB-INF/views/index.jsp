<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

/************** topic ****************/
#topic {
	position: absolute;
	width: 100%;
	height: 100vh;
	margin: 0 auto;
	padding: 0px;
	z-index: 1;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
	background-image: url(images/letters.jpg);
	opacity: 0.5;
	display: flex;
	align-items: center;
	/* 垂直置中 */
	justify-content: center;
	/* 水平置中 */
}

/* 文字置中 */
#topicContent {
	width: 100%;
	text-align: center;
	align-items: center;
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
	flex: 45%;
	background-color: #fafafa;
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
	border-radius: 30px;
	background: linear-gradient(to right, #f9d423 0%, #ff4e50 100%);
	/* background: linear-gradient(120deg, #f6d365 0%, #fda085 100%); */
	/* background-color: #eab814; */
	user-select: none;
	transition: 0.5s;
	text-decoration: none;
	overflow: hidden;
}

.designbtn:hover {
	color: #fff;
	background-image: linear-gradient(-225deg, #2CD8D5 0%, #6B8DD6 48%, #8E37D7 100%);
	/* background-image: linear-gradient(-225deg, #2CD8D5 0%, #C5C1FF 56%, #FFBAC3 100%); */
	/* background-color: #6464ef; */
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
/* *******mydesign --right************** */
.mydesign .rightside {
	position: relative;
	flex: 55%;
	background-color: rgba(244, 192, 19, 0.4);
	background-image: url("assets/css/images/bg.png");
	display: flex;
}

.rightLetter {
	width: 100%;
	height: 100%;
	justify-content: center;
	margin: auto;
}

/* slide in/out */
.align-left {
	float: left;
	margin-right: 20px;
}

.align-right {
	float: right;
	margin-left: 20px;
}

.slide-in {
	opacity: 0;
	transition: all .5s;
}

.align-left.slide-in {
	transform: translateX(-30%) scale(0.95);
}

.align-right.slide-in {
	transform: translateX(30%) scale(0.95);
}

.slide-in.active {
	opacity: 1;
	transform: translateX(0%) scale(1);
}
</style>

</head>
<body>

	<%-- <%@ include file="layout/mynav.jsp"%> --%>
	<%@ include file="layout/mynav.jsp"%>

	<!-- top1 -->
	<article>
		<div class="container-fluid article1 " id="topic">
			<div id="topicContent">
				<h1>寫下你的信~</h1>
			</div>
		</div>
	</article>

	<!--work-->

	<article id="">
		<div class="container-fluid  wrapper style2">
			<div class=" container" style="margin: auto auto;">
				<!-- border: 3px solid black; -->
				<header style="margin: 50px 0;">
					<h1 style="font-size: 3em; font-weight: 700; letter-spacing: 5px;">關於我們/這個網站</h1>
					<p>這裡應該會寫這個網站的資訊/我們的創作理念之類</p>
				</header>
				<div class="row aln-center" style="margin: auto 0;">
					<div class="col-4 col-6-medium col-12-small">
						<section class="box style1">
							<span class="material-icons"
								style="font-size: 1000%; color: rgba(216, 163, 238, 0.8)">
								auto_awesome </span>
							<h2>分享心事</h2>
							<p>Ornare nulla proin odio consequat sapien vestibulum ipsum
								primis sed amet consequat lorem dolore.</p>
						</section>
					</div>
					<div class=" col-4 col-6-medium col-12-small">
						<section class="box style1">
							<span class="material-icons"
								style="font-size: 1000%; color: rgb(220, 91, 27, 0.8)">
								diversity_1</span>
							<h2>留話給跟身邊的人</h2>
							<p>Ornare nulla proin odio consequat sapien vestibulum ipsum
								primis sed amet consequat lorem dolore.</p>
						</section>
					</div>
					<div class="col-4 col-6-medium col-12-small">
						<section class="box style1">
							<span class="material-icons"
								style="font-size: 1000%; color: rgb(107, 141, 214, 0.8)">mark_as_unread</span>
							<h2>說明後事處理形式</h2>
							<p>Ornare nulla proin odio consequat sapien vestibulum ipsum
								primis sed amet consequat lorem dolore.</p>
						</section>
					</div>
				</div>
				<footer style="margin: 50px 0;">
					<p>Lorem ipsum dolor sit sapien vestibulum ipsum primis?</p>
				</footer>
			</div>
		</div>
	</article>

	<!-- letter animation  -->
	<article>
		<div class="mydesign">
			<div class="leftside">
				<div class="words">
					<ion-icon name="heart" id="heart"
						style="font-size: 4em; color: #f26d48;"></ion-icon>
					<h1>好好說再見</h1>
					<p>傳達來不及說、開不了口的文字給自己所愛的人</p>
					<div class="containbtn">
						<a  class="designbtn">寫信</a>
					</div>
				</div>
			</div>
			<div class="rightside" style="display: flex; flex-direction: column;">
				<h1
					style="color: rgba(189, 112, 108, 1); font-size: 100px; text-align: center; font-family: 'Kaushan Script', cursive;">
					For<br> Someone<br> Special
				</h1>
				<div
					style="width: 50%; height: auto; margin: auto; transform: rotate(-15deg);">
					<!-- border: 3px solid red; -->
					<img src="images/pixelEnvolop.png"
						class="align-right slide-in rightLetter">
				</div>
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
	<script src="assets/js/jquery-3.6.3.min.js"></script>
	<script src="assets/js/main.js"></script>


	<script>
	//特殊按鈕
    let designbtn = document.querySelectorAll(".designbtn");
    designbtn.forEach(designbtn => {
        designbtn.onclick = function (e) {
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
        }
    })



    ////////////////slide in on scroll
    function debounce(func, wait = 10, immediate = true) {
        var timeout;
        return function () {
            var context = this, args = arguments;
            var later = function () {
                timeout = null;
                if (!immediate) func.apply(context, args);
            };
            var callNow = immediate && !timeout;
            clearTimeout(timeout);
            timeout = setTimeout(later, wait);
            if (callNow) func.apply(context, args);
        };
    };


    //抓+父元素的offsetTop
    function getImageBottom(el) {
        let rect = el.getBoundingClientRect();
        let offsetY = rect.bottom;

        while (el.parentElement) {
            el = el.parentElement;
            if (el.clientHeight) {
                offsetY += el.clientHeight - el.scrollHeight;
            }
            offsetY += el.offsetTop;
        }

        return offsetY;
    }


    const sliderImages = document.querySelectorAll('.slide-in');

    function checkSlide() {
        sliderImages.forEach(sliderImage => {

            // 位置信息都是相對於網頁視口的位置
            let rect = sliderImage.getBoundingClientRect();
            let offsetY = rect.bottom;


            // half way through the image
            const slideInAt = (window.scrollY + window.innerHeight) - sliderImage.height / 4;

            // bottom of the image
            const imageBottom = offsetY + sliderImage.height * 3 / 4;

            const isHalfShown = slideInAt > offsetY;
            console.log(`slideInAt=${slideInAt} > offsetY=${offsetY}`);

            const isNotScrolledPast = window.scrollY > imageBottom;
            console.log(`window.scrollY=${window.scrollY}>imageBottom=${imageBottom}`);

            if (isHalfShown && isNotScrolledPast) {
                sliderImage.classList.add('active');
            } else {
                sliderImage.classList.remove('active');
            }

        });
    }

    window.addEventListener('scroll', debounce(checkSlide));	
	</script>

</body>
</html>
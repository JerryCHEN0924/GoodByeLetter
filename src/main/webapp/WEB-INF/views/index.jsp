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
<link rel="stylesheet" href="assets/css/mymain.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<style>
</style>

</head>

<body>
<%-- 	<%@ include file="Tina/layout/mynav.jsp"%> --%>


	<div id="outline">
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
						<p>Ornare nulla proin odio consequat sapien vestibulum ipsum
							primis sed amet consequat lorem dolore.</p>
					</section>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<section class="box style1">
						<span class="icon solid featured fa-camera-retro"></span>
						<h3>Lorem dolor tempus</h3>
						<p>Ornare nulla proin odio consequat sapien vestibulum ipsum
							primis sed amet consequat lorem dolore.</p>
					</section>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<section class="box style1">
						<span class="icon featured fa-thumbs-up"></span>
						<h3>Feugiat posuere</h3>
						<p>Ornare nulla proin odio consequat sapien vestibulum ipsum
							primis sed amet consequat lorem dolore.</p>
					</section>
				</div>
			</div>
			<footer>
				<p>Lorem ipsum dolor sit sapien vestibulum ipsum primis?</p>
				<a href="#portfolio" class="button large scrolly">See some of my
					recent work</a>
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
	<script src="assets/js/jquery-3.6.3.min.js"></script>
	<script src="assets/js/main.js"></script>


	<script>
		
	</script>

</body>
</html>
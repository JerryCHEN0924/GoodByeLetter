<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
		<!DOCTYPE html>
		<html>

		<head>
			
			<link rel="stylesheet" href="<c:url value='/assets/css/mymain.css' />" />
			<style>
			.narbar_background_color {
			    background-color: #ecb21f;
			    opacity: 0.9;
			    /* rgb(240, 225, 173); */
			    /* background-color: transparent;*/
			}
			
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
			<nav class="navbar .navbar-fixed-top navbar-expand-xl narbar_background_color" id="nav">
				<div class="container-fluid">
					<a class="navbar-brand narbar_text_color" href="#">OurBrand</a>

					<div class="collapse navbar-collapse show" id="navbarWithDropdown">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active narbar_text_color" aria-current="page"
									href="${contextRoot}">首頁</a></li>
							<li class="nav-item dropdown "><a class="nav-link dropdown-toggle narbar_text_color"
									href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
									aria-expanded="false"> 會員 </a>
								<ul class="dropdown-menu  " aria-labelledby="navbarDropdownMenuLink"
									id="dropdown-menu_login">
									<c:choose>
										<c:when test="${existing.memberId != null}">
											<li><a class="dropdown-item narbar_text_color" href="<c:url value='register/logout' />">
													${existing.account}登出 </a></li>
											<li><a class="dropdown-item narbar_text_color" href="<c:url value='register/edit?memberId=${existing.memberId}' />">編輯帳號</a>
											<li><a class="dropdown-item narbar_text_color" href="<c:url value='register/memberDetail' />">編輯會員資料</a>
<%-- 											memberDetail/edit?memberId=${existing.memberId} --%>
											
											</li>
										</c:when>
										<c:otherwise>
											<li><a class="dropdown-item narbar_text_color" href="<c:url value='login1' />"> 登入 </a></li>
											<li><a class="dropdown-item narbar_text_color" href="<c:url value='register1' />"> 註冊 </a>
											</li>
										</c:otherwise>
									</c:choose>
									<li><a class="dropdown-item narbar_text_color" href="mySpace.html"> 個人空間 </a></li>
								</ul>
							</li>
							
							<li class="nav-item dropdown "><a class="nav-link dropdown-toggle narbar_text_color"
									href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
									aria-expanded="false"> 合作夥伴 </a>
								<ul class="dropdown-menu  " aria-labelledby="navbarDropdownMenuLink"
									id="dropdown-menu_company">
									<li><a class="dropdown-item narbar_text_color" href="<c:url value='/customer/add' />">廣告商註冊</a></li>
									<li><a class="dropdown-item narbar_text_color" href="<c:url value='/customer/page' />">廣告商登入</a></li>
									<li><a class="dropdown-item narbar_text_color disabled" href="#">XXX</a></li>
									<li><a class="dropdown-item narbar_text_color disabled" href="#">XXX</a></li>
								</ul>
							</li>
							

							<li class="nav-item dropdown "><a class="nav-link dropdown-toggle narbar_text_color"
									href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
									aria-expanded="false"> 留言板 </a>
								<ul class="dropdown-menu  " aria-labelledby="navbarDropdownMenuLink"
									id="dropdown-menu_login">
									<li><a href="<c:url value='/board/page' />" class="dropdown-item narbar_text_color">
											查看留言 </a></li>
									<li><a href="<c:url value='/board/add' />" class="dropdown-item narbar_text_color">
											增加留言 </a></li>
									<li><a href="" class="dropdown-item narbar_text_color" href="mySpace.html"> 個人空間
										</a></li>
								</ul>
							</li>

							<li class="nav-item  dropdown ">
								<a class="nav-link dropdown-toggle narbar_text_color" href="#" tabindex="-1"
									data-bs-toggle="dropdown" role="button" id="navbarDropdownMenuLink"
									aria-disabled="false">GoodBye Letter</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink"
									id="dropdown-menu_GL">
									<li><a class="dropdown-item narbar_text_color"
											href="<c:url value='/LastNote' />">撰寫</a></li>
									<li><a class="dropdown-item narbar_text_color"
											href="<c:url value='/LastNote/edit' />">編輯</a></li>
									<li><a class="dropdown-item narbar_text_color  disabled" href="#">XXX</a></li>
								</ul>
							</li>
							<li class="nav-item "><a class="nav-link narbar_text_color" href="#">Features</a></li>
							<li class="nav-item "><a class="nav-link disabled narbar_text_color" href="#" tabindex="-1"
									aria-disabled="true">Disabled</a></li>
						</ul>
					</div>
				</div>
			</nav>
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
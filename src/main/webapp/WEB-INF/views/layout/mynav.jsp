<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
				<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
				<c:set var="contextUser" value="${pageContext.request.userPrincipal}" />
				<!DOCTYPE html>
				<html>

				<head>
					<style>
						.navigation {
							position: fixed;
							width: auto;
							height: 130px;
							display: flex;
							align-items: center;
 							background: transparent;
							z-index: 1;
						}

						.navigation ul {
							position: relative;
							display: flex;
							width: auto;
							/* 	background:red;  */
							/* 調整nav裡元素的位置 */
							justify-content: left;
						}

						.navigation ul .list {
							position: relative;
							justify-content: center;
							list-style: none;
							width: 120px;
							height: 140px;
							z-index: 1;
						}

						.navigation ul .list .list_a {
							position: relative;
							display: flex;
							justify-content: center;
							align-items: center;
							flex-direction: column;
							width: 100%;
							text-align: center;
							font-weight: 500;
						}

						.navigation ul .list .list_a .icon {
							position: relative;
							display: block;
							font-size: 2em;
							line-height: 150px;
							transition: 0.5s;
							/* color: rgba(103, 103, 103, 0.5); */
							color: rgba(114, 176, 176, 0.5);
						}

						.navigation ul .list.active a .icon {
							transform: translateY(-16px);
							color: #f9d423;
						}

						.navigation ul .list .list_a .text {
							position: absolute;
							/* font-weight: 0.5em; */
							font-size: 1.2em;
							font-weight: bold;
							/* color: #fff; */
							color: #140101;
							transition: 0.5s;
							letter-spacing: 0.05em;
							text-transform: uppercase;
							transform: translateY(0px);
						}

						.navigation ul .list.active .list_a .text {
							transform: translateY(24px);
							opacity: 1;
						}

						.indicator {
							position: absolute;
							width: 120px;
							height: 140px;
							display: flex;
							justify-content: center;
							align-items: center;
							transition: 0.5s;
						}

						.indicator::before {
							content: "";
							position: absolute;
							bottom: 26px;
							width: 90%;
							height: 28px;
							background: #f9d423;
							border-radius: 10px;
						}

						/* 右邊版 */
						/* .navigation ul li:nth-child(1).active ~.indicator { */
						/* 	transform: translateX(calc(-120px * 5)); */
						/* } */

						/* .navigation ul li:nth-child(2).active ~.indicator { */
						/* 	transform: translateX(calc(-120px * 4)); */
						/* } */

						/* .navigation ul li:nth-child(3).active ~.indicator { */
						/* 	transform: translateX(calc(-120px * 3)); */
						/* } */

						/* .navigation ul li:nth-child(4).active ~.indicator { */
						/* 	transform: translateX(calc(-120px * 2)); */
						/* } */

						/* .navigation ul li:nth-child(5).active ~.indicator { */
						/*  	transform: translateX(calc(-120px * 1));  */
						/* } */

						/* .navigation ul li:nth-child(6).active ~.indicator { */
						/* 	transform: translateX(calc(-120px * 0)); */
						/* } */

						/* 左邊版 */

						.navigation ul li:nth-child(2).active~.indicator {
							transform: translateX(calc(120px * 1));
						}



						.navigation ul li:nth-child(3).active~.indicator {
							transform: translateX(calc(120px * 2));
						}



						.navigation ul li:nth-child(4).active~.indicator {
							transform: translateX(calc(120px * 3));
						}

						.navigation ul li:nth-child(5).active~.indicator {
							transform: translateX(calc(120px * 4));
						}

						.navigation ul li:nth-child(6).active~.indicator {
							transform: translateX(calc(120px * 5));
						}

						ion-icon {
							font-size: 2em;
						}

						.div_dropdown {
							width: 120px;
							position: absolute;
							/* display: none; */
							box-shadow: 0 0 10px 0px rgba(102, 136, 164, 0.5);
							/* border: 3px solid rgb(52, 52, 52); */
							border-radius: 5px;
							top: 120px;
							left: 6px;
							visibility: hidden;
							opacity: 0;
							transform: 0.25s;
							position: absolute;
							background: #fff;
						}

						.div_dropdown.active {
							visibility: visible;
							opacity: 1;
						}

						/* dropdown */
						.dropdown {
							margin: 0px;
							padding: 0px;
							flex-direction: column;
							list-style: none;
							/* border: 3px solid indianred; */
							/* border: 2px solid #cfcccc; */
							border-radius: 5px;
						}

						.dropdown li {
							display: flex;
							justify-content: center;
							border-bottom: 3px solid rgba(114, 176, 176, 0.3);
							/* border-bottom: 2px solid #cfcccc; */
						}

						.dropdown li:last-child {
							border: none;
						}

						.dropdown li:hover {
							background-color: #f9d423;
						}

						.dropdown a {
							/* border: 3px lawngreen solid; */
							color: #140101;
							text-align: center;
							font-size: 18px;
							font-weight: 700;
							text-decoration: none;
							margin: 2px 0px;
						}

						.dropdown a:hover {
							font-size: 20px;
						}
					</style>
				</head>

				<body>
					<!--Nav Bootstrap-->
					<div class="navigation">
						<ul>
							<li class="list active"><a href="${contextRoot}" class="list_a">
									<span class="icon"><ion-icon name="planet-outline"></ion-icon></span>
									<span class="text">首頁</span>
								</a></li>

							<li class="list"><a href="<c:url value='/register/login1' />" class="list_a"> <span
										class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
									<span class="text">會員</span>
								</a>
								<div class="div_dropdown ">
									<!-- 				style="width: 120px;" -->
									<ul class="dropdown">
										<c:choose>
											<c:when test="${existing.memberId != null}">
												<li><a href="<c:url value='/register/logout' />">
														${existing.account}登出 </a></li>
												<li><a
														href="<c:url value='/register/edit?memberId=${existing.memberId}' />">編輯帳號</a>
												<li><a
														href="<c:url value='/memberDetail/edit?memberId=${existing.memberId}' />">編輯會員資料</a>
													<%-- memberDetail/edit?memberId=${existing.memberId} --%>
												</li>
											</c:when>
											<c:otherwise>
												<li><a href="<c:url value='/register/login1' />"> 會員登入 </a></li>
												<li><a href="<c:url value='/register' />"> 會員註冊 </a></li>
											</c:otherwise>
										</c:choose>
										<!-- 										<li><a href="mySpace.html"> 個人空間 </a></li> -->
									</ul>
								</div>
							</li>

							<li class="list"><a href="<c:url value='/customer/login/page' />" class="list_a"> <span
										class="icon"><ion-icon name="people-outline"></ion-icon></span> <span
										class="text">合作夥伴</span>
								</a>
								<div class="div_dropdown">
									<ul class="dropdown">
										<c:choose>
											<c:when test="${exis.memberId != null}">
												<li><a href="<c:url value='/customer/logout'/>">${exis.account}登出</a>
												</li>
												<li><a href="<c:url value='/customer/home/page'/>">${exis.account}
														Home</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="<c:url value='/customer/login/page' />">夥伴登入</a></li>
												<li><a href="<c:url value='/customer/add/page' />">夥伴註冊</a></li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</li>
							<li class="list"><a href="<c:url value='/LastNote' />" class="list_a"> <span
										class="icon"><ion-icon name="mail-open-outline"></ion-icon></span>
									<span class="text">寫信</span>
								</a>
								<div class="div_dropdown " id="div_dropdown">
									<ul class="dropdown">
										<li><a href="<c:url value='/LastNote' />">撰寫</a></li>
										<li><a href="<c:url value='/LastNote/edit' />">編輯</a></li>
										<li><a href="<c:url value='/ECPay' />">支持GoodBye Letter</a></li>
									</ul>
								</div>
							</li>

							<li class=" list "><a href="<c:url value='/board/page' />" class="list_a"> <span
										class="icon"><ion-icon name="chatbox-ellipses-outline"></ion-icon></span>
									<span class="text">交流區</span>
								</a>
								<div class="div_dropdown " id="div_dropdown">
									<ul class="dropdown">
										<li><a href="<c:url value='/board/page' />"> 查看留言 </a></li>
										<c:if test="${not empty existing or not empty exis}">
											<li><a href="<c:url value='/board/add' />"> 增加留言 </a></li>
										</c:if>
									</ul>
								</div>
							</li>

							<%-- <li class="list"><a href="<c:url value='/wschat' />" class="list_a"> <span
										class="icon"><ion-icon name="chatbubbles-outline"></ion-icon></span> <span
										class="text">聊天室</span>
								</a>
								</li>--%>
								<li class="list" id="navChatRoom"><a class="list_a">
										<span class="icon"><ion-icon name="chatbubbles-outline"></ion-icon></span>
										<span class="text">聊天室</span>
									</a>
								</li>

								<div class="indicator"></div>
						</ul>
					</div>

					<!-- 				插入聊天室 -->
					<div>
						<%@ include file="../Tina/wsChat.jsp" %>
					</div>












					<script src="${contextRoot}/assets/js/jquery.min.js"></script>
					<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
					<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

					<script>

						// navbar
						let list = document.querySelectorAll(".list");
						function activeLink() {
							list.forEach((item) => {
								//console.log(`click`);
								return item.classList.remove("active")
							});
							this.classList.add("active");
						}
						list.forEach((item) =>
							item.addEventListener("mouseover", activeLink));


						//dropdown
						list.forEach((item) => {
							// const div_dropdown = .querySelectorAll(".div_dropdown");
							item.addEventListener("mouseover", function () {
								const div_dropdown = this.querySelector('.div_dropdown');
								div_dropdown.classList.add("active");
							})

							item.addEventListener("mouseout", function () {
								const div_dropdown = this.querySelector('.div_dropdown');
								div_dropdown.classList.remove("active");
							})
						})

						//顯示chatRoom
						var navChatRoom = document.getElementById("navChatRoom");
						var wholeChatroomDiv = document.getElementById("wholeChatroomDiv");
						navChatRoom.addEventListener("click", function () {
							wholeChatroomDiv.style.visibility = "visible";
						})
					</script>
				</body>

				</html>
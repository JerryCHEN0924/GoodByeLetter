<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>chatroom</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style type="text/css">
  .card-bordered {
            border: 1px solid #ebebeb;
        }

        .card {
            border: 0;
            border-radius: 0px;
            /* margin-bottom: 30px; */
            -webkit-box-shadow: 0 2px 3px rgba(0, 0, 0, 0.03);
            box-shadow: 0 2px 3px rgba(0, 0, 0, 0.03);
            -webkit-transition: .5s;
            transition: .5s;
        }

        .padding {
            padding: 3rem !important
        }

        body {
            background-color: #f9f9fa
        }

        .card-header:first-child {
            border-radius: calc(.25rem - 1px) calc(.25rem - 1px) 0 0;
        }


        .card-header {
            display: -webkit-box;
            display: flex;
            -webkit-box-pack: justify;
            justify-content: space-between;
            -webkit-box-align: center;
            align-items: center;
            padding: 15px 20px;
            background-color: transparent;
            border-bottom: 1px solid rgba(77, 82, 89, 0.07);
        }

        .card-header .card-title {
            padding: 0;
            border: none;
        }

        h4.card-title {
            font-size: 17px;
        }

        .card-header>*:last-child {
            margin-right: 0;
        }

        .card-header>* {
            margin-left: 8px;
            margin-right: 8px;
        }

        .btn-secondary {
            color: #4d5259 !important;
            background-color: #e4e7ea;
            border-color: #e4e7ea;
            color: #fff;
        }

        .btn-xs {
            font-size: 11px;
            padding: 2px 8px;
            line-height: 18px;
        }

        .btn-xs:hover {
            color: #fff !important;
        }




        .card-title {
            font-family: Roboto, sans-serif;
            font-weight: 300;
            line-height: 1.5;
            margin-bottom: 0;
            padding: 15px 20px;
            border-bottom: 1px solid rgba(77, 82, 89, 0.07);
        }


        .ps-container {
            position: relative;
        }

        .ps-container {
            -ms-touch-action: auto;
            touch-action: auto;
            overflow: hidden !important;
            -ms-overflow-style: none;
        }

        .media-chat {
            padding-right: 64px;
            margin-bottom: 0;
        }

        .media {
            padding: 16px 12px;
            -webkit-transition: background-color .2s linear;
            transition: background-color .2s linear;
        }

        .media .avatar {
            flex-shrink: 0;
        }

        .avatar {
            position: relative;
            display: inline-block;
            width: 36px;
            height: 36px;
            line-height: 36px;
            text-align: center;
            border-radius: 100%;
            background-color: #f5f6f7;
            color: #8b95a5;
            text-transform: uppercase;
        }

        .media-chat .media-body {
            -webkit-box-flex: initial;
            flex: initial;
            display: table;
        }

        .media-body {
            min-width: 0;
        }

        .media-chat .media-body p {
            position: relative;
            padding: 6px 8px;
            margin: 4px 0;
            background-color: #f5f6f7;
            border-radius: 3px;
            font-weight: 100;
            color: #9b9b9b;
        }

        .media>* {
            margin: 0 8px;
        }

        .media-chat .media-body p.meta {
            background-color: transparent !important;
            padding: 0;
            opacity: .8;
        }

        .media-meta-day {
            -webkit-box-pack: justify;
            justify-content: space-between;
            -webkit-box-align: center;
            align-items: center;
            margin-bottom: 0;
            color: #8b95a5;
            opacity: .8;
            font-weight: 400;
        }

        .media {
            padding: 16px 12px;
            -webkit-transition: background-color .2s linear;
            transition: background-color .2s linear;
        }

        .media-meta-day::before {
            margin-right: 16px;
        }

        .media-meta-day::before,
        .media-meta-day::after {
            content: '';
            -webkit-box-flex: 1;
            flex: 1 1;
            border-top: 1px solid #ebebeb;
        }

        .media-meta-day::after {
            content: '';
            -webkit-box-flex: 1;
            flex: 1 1;
            border-top: 1px solid #ebebeb;
        }

        .media-meta-day::after {
            margin-left: 16px;
        }

        .media-chat.media-chat-reverse {
            padding-right: 12px;
            padding-left: 64px;
            -webkit-box-orient: horizontal;
            -webkit-box-direction: reverse;
            flex-direction: row-reverse;
        }

        .media-chat {
            padding-right: 64px;
            margin-bottom: 0;
            display: flex;
        }

        .media {
            padding: 16px 12px;
            -webkit-transition: background-color .2s linear;
            transition: background-color .2s linear;
        }

        .media-chat.media-chat-reverse .media-body p {
            /* 用float不一定會緊貼最右側 所以用flex:justify-content: flex-end */
            justify-content: flex-end;
            float: right;
            clear: right;
/*             background-color: #48b0f7; */
/*             color: #fff; */
            
            background-color: #f7e048;
            color: #4d5259;
        }

        .media-chat .media-body p {
            position: relative;
            padding: 6px 8px;
            margin: 4px 0;
            background-color: #f5f6f7;
            color: #4d5259;
            border-radius: 3px;
        }


        .border-light {
            border-color: #f1f2f3 !important;
        }

        .bt-1 {
            border-top: 1px solid #ebebeb !important;
        }

        .publisher {
            position: relative;
            display: -webkit-box;
            display: flex;
            -webkit-box-align: center;
            align-items: center;
            padding: 12px 20px;
            background-color: #f9fafb;
        }

        .publisher>*:first-child {
            margin-left: 0;
        }

        .publisher>* {
            margin: 0 8px;
        }

        .publisher-input {
            -webkit-box-flex: 1;
            flex-grow: 1;
            border: none;
            outline: none !important;
            background-color: transparent;
        }

        button,
        input,
        optgroup,
        select,
        textarea {
            font-family: Roboto, sans-serif;
            font-weight: 300;
        }

        .publisher-btn {
            background-color: transparent;
            border: none;
            color: #8b95a5;
            font-size: 16px;
            cursor: pointer;
            overflow: -moz-hidden-unscrollable;
            -webkit-transition: .2s linear;
            transition: .2s linear;
        }

        .file-group {
            position: relative;
            overflow: hidden;
        }

        .publisher-btn {
            background-color: transparent;
            border: none;
            color: #cac7c7;
            font-size: 16px;
            cursor: pointer;
            overflow: -moz-hidden-unscrollable;
            -webkit-transition: .2s linear;
            transition: .2s linear;
        }

        .file-group input[type="file"] {
            position: absolute;
            opacity: 0;
            z-index: -1;
            width: 20px;
        }

        .text-info {
            color: #48b0f7 !important;
        }
    </style>
</head>

<body>


<!-- 	<div style="width: 100vw; height: 100vh; background-color: #48b0f7;"> -->
<!-- 	固定位置 -->
		<div class="d-flex justify-content-end d-flex align-items-end"
			style="height: 100vh; position: fixed">
			<div class="card card-bordered">
				<div class="card-header">
					<h4 class="card-title">
						<strong id="showToName">Chat</strong>
					</h4>
					<a class="btn btn-xs btn-secondary" href="#" data-abc="true">${existing.account}在線上</a>
				</div>

				<!-- chat_content -->
				<div class="ps-container ps-theme-default ps-active-y"
					id="chat-content"
					style="overflow-y: scroll !important; height: 400px !important;">
				<!-- 內文放置區 -->
				



					<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
						<div class="ps-scrollbar-x" tabindex="0"
							style="left: 0px; width: 0px;"></div>
					</div>
					<div class="ps-scrollbar-y-rail"
						style="top: 0px; height: 0px; right: 2px;">
						<div class="ps-scrollbar-y" tabindex="0"
							style="top: 0px; height: 2px;"></div>
					</div>
				</div>

				<!-- 輸入聊天對象 -->
				<div class="publisher bt-1 border-light">
					<input class="publisher-input" type="text"
						placeholder="Type the person chats with" id="toName"
						name="userName">
					<button class="publisher-btn" data-abc="true" id="btn_join">
						<span class="material-icons"  style="color:#f7e048">spatial_audio_off</span>
					</button>
				</div>
				<!-- 輸入聊天內容 -->
				<div class="publisher bt-1 border-light">
					<img class="avatar avatar-xs"
						src="https://img.icons8.com/color/36/000000/administrator-male.png"
						alt="..."> 
					<input class="publisher-input" type="text"
						placeholder="Write something" id="send_text" name="sendText">
					<button class="publisher-btn" data-abc="true" id="btn_send">
						<span class="material-icons"  style="color:#f7e048">send</span>
					</button>
					<!-- <span class="publisher-btn file-group">
                        <i class="fa fa-paperclip file-browser"></i>
                        <input type="file">
                    </span> -->
					<!-- <a class="publisher-btn" href="#" data-abc="true"><i class="fa fa-smile"></i></a>
                    <a class="publisher-btn text-info" href="#" data-abc="true"><i class="fa fa-paper-plane"></i></a> -->
				</div>

			</div>
		</div>
<!-- 	</div> -->
	
	
	<%-- 
                    <h1>Main.jsp聊天室</h1>
                    <h3>${user}在線上</h3>
                    <h5 id="showToName" style="color:gray"></h5>
                   
                    
                    <div id="chat-content" style="width:500px;height:500px;border:3px solid black">
                    <div id="righttext" style="background:pink"></div>
                    <div id="lefttext" style="background:purple"></div>
                    </div>
                    <hr>
                    傳送對象：<input type="text" id="toName" value="" name="userName" />
                    <button id="btn_join">對象</button>
                    <button id="btn_exit">退出聊天室</button>

                    <br>

                    消息：<input type="text" id="send_text" value="" name="sendText" />
                    <button id="btn_send">发送</button>
					--%>








	<script type="text/javascript">
		var prefixUrl = 'ws://localhost:8080/index/ws/chatRoom/';

		var ws;

		var toName;

		var userName;

		$(function() {

			//WebSocket连接对象

			//判断当前浏览器是否支持WebSocket
			if (!('WebSocket' in window)) {
				alert('Not support websocket');
			}

			// $('#btn_join').click(function () {

			//var userName = $('#user_name').val();
			userName = "${existing}";
			//创建WebSocket连接对象
			ws = new WebSocket(prefixUrl + userName);

			//连接成功建立的回调方法
			ws.onopen = function(event) {
				console.log('建立连接:' + ws);
			}

			//接收到Server的消息後會觸發的事件 //event事件對象 //event.data獲取server發送過來的消息
			ws.onmessage = function(event) {
				 var dataStr = event.data;
				 var dataJson = JSON.parse(event.data);
				console.log(dataStr);
				 <%--if(dataJson.isSystem){
					 var names = dataJson.message;
					 for (var names of name) {
						 var str = '<div class="media media-chat">'
								+'<img class="avatar" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="...">'
								+'<div class="media-body">'
								+'<p>'
								+ name
								+ '</p></div></div>';
					}	 
				 }
				 else{--%>
				 var str = '<div class="media media-chat">'
					+'<img class="avatar" src="https://img.icons8.com/color/36/000000/administrator-male.png" alt="...">'
					+'<div class="media-body">'
					+'<p>'
					+ dataJson.fromName + ":" + dataJson.message
					+ '</p></div></div>';
			<%--}--%>

				console.log('接收到内容(event.data)：' + event.data);
				//$('#chat-content').append( event.data + '\n');
				$('#chat-content').append(str);
			}

			//连接发生错误的回调方法
			ws.onerror = function(event) {
				console.log('发生错误');
			}

			//连接关闭的回调方法
			ws.onclose = function(event) {
				console.log('关闭连接');
			}

			//})

			//指定發送對象
			$('#btn_join').click(function() {
				toName = $("#toName").val();
				console.log("toName: " + toName);
				if(toName.trim() != ""|| toName != null){
					$("#showToName").html("跟" + toName + "聊天");
				}else{
					$("#showToName").html("沒有指定對話對象!");
				}
				
			})

			//发送消息
			function sendMessage(message) {
				ws.send(message);

			}

			//关闭连接
			function closeWebSocket() {
				ws.close();
			}

			//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
			window.onbeforeunload = function() {
				wx.close();
			}

			//发送消息
			$('#btn_send')
					.click(
							function() {
								// sendMessage($('#send_text').val());
								//新增toName對象
								toName = $("#toName").val();
								console.log("toName: " + toName);
								if(toName.trim() != ""|| toName != null){
									$("#showToName").html("跟" + toName + "聊天");
								}else{
									$("#showToName").html("沒有指定對話對象!");
								}
								//////
							
								var data = $('#send_text').val();
								//清空傳送的input
								$('#send_text').val("");
								//顯示自己輸入的訊息在對話框裡
								var str = '<div class="media media-chat media-chat-reverse"><div class="media-body"><p>'
										+ userName + ": " + data + '</p></div></div>'
								$('#chat-content').append(str);
								//把傳送對象+訊息裝成json型別
								var json = {
									"toName" : toName,
									"messagetext" : data
								};
								var json_stringify = JSON.stringify(json);
								console.log("json_stringify: "+ json_stringify);

								//傳給ws.send()方法
								sendMessage(json_stringify);
							})

			//点击退出聊天室
			//$('#btn_exit').click(function () {
			//closeWebSocket();
			//})
		})
	</script>
</body>

</html>
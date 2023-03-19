<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>聊天室</title>
<link rel="stylesheet" href="/index/assets/css/mymain.css" />
</head>
<body>
 <div class="container mt-5">
	<div class="row" >
		<div class="offset-sm-2 col-sm-8 border shadow p-5">
			<h4 class="text-center pb-3">即時聊天室</h4>
			<h5><span class="h6 badge bg-primary float-end" id="connect-status">離線中</span></h5>
			<form id="form1" class="p-5">
				<div class="pb-3">
					<div class="form-control" style="height:250px;overflow:auto;" id="msg-io"></div>
				</div>
				<div class="pb-3">
					<input class="form-control" type="text" name="msg-input" id="msg-input" placeholder="請輸入訊息" />
				</div>
				<div class="pb-3">
					<button type="submit" class="btn btn-primary">送出</button>
					<button type="button" id="disconnect-btn" class="btn btn-danger float-end">斷線</button>
				</div>							
			</form>
		</div>
	</div>
</div>
<script>
$(function(){
// 	let ws = new WebSocket('ws://localhost:8088/ws/instant-chat');
	let ws = new WebSocket('ws://localhost:8080/index/chat');
	//連線資訊:Controller/Tina/ws/WebSocketConfiguration.java
// p.innerHTML="";
	ws.onopen = function(){
		console.log('Connection 開啟了...');
		
		$("#connect-status").text("連線中"); 
		
	}
	ws.onclose = function(){
		console.log('Connection 關閉了...');
		
		$("#connect-status").text("離線中"); 
	}
	ws.onmessage = function(event) {
		var msg = event.data;
		var msgTime = new Date().toLocaleTimeString();
		//$("#msg-io").append(`<h6>${msg}</h6>`);//注意：JSP的EL與JavaScript的Template literal語法衝到
	    $("#msg-io").append("<h6>" + msg + "</h6>"); 
	    $("#msg-io").append("<h6>" + msgTime + "</h6>"); 
	    var msgIoDiv = $("#msg-io")[0];	    
	    console.log(msgTime);
	    msgIoDiv.scrollTo(0,msgIoDiv.scrollHeight);	    
	    msgIoDiv.scrollTo(0,msgIoDiv.scrollHeight);	    
	    //element.scrollTo(x-coord, y-coord)
	    //The scrollTo() method of the Element interface scrolls to a particular set of coordinates inside a given element.
	    //Element.scrollHeight是衡量元素包含因為overflow而沒顯示在螢幕上的內容高度的唯讀屬性.
	}	
	$("#form1").submit(function(){
		
		ws.send($("#msg-input").val());
		$("#msg-input").val("");
		
		return false;
	});
	
    $("#disconnect-btn").click(function () {
        ws.close(1000, "正常斷線");
        //1000(Normal Closure) 表示 The connection successfully completed the purpose for which it was created.

        //WebSocket.close(code, reason);
        /*
        code (選用)：
            A numeric value indicating the status code explaining why the connection is being closed.
            If this parameter is not specified, a default value of 1005(No Status Received) is assumed.
            可用的code列表：https://developer.mozilla.org/en-US/docs/Web/API/CloseEvent/code
        reason (選用)
            A human - readable string explaining why the connection is closing.
            This string must be no longer than 123 bytes of UTF-8 text.
        */
    });

});

</script>
</body>
</html>

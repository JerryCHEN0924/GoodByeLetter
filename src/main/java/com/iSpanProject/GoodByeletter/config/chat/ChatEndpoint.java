package com.iSpanProject.GoodByeletter.config.chat;


import java.util.Map;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iSpanProject.GoodByeletter.controller.Lillian.registerController;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.chat.Message;
import com.iSpanProject.GoodByeletter.model.Tina.chat.utils.MessageUtils;


//取得目前的用戶名
@SessionAttributes({ "existing" })
@ServerEndpoint(value = "/ws/chatRoom/{userName}", configurator = GetHttpSessionConfigurator.class)
@Component
//每個客戶端都有一個自己的ChatEndpoint與之相對應			
//可用ChatEndpoint裡的websocket session獲取發送資料的對象+把資料發給指定的客戶端
public class ChatEndpoint {
	
	//用來存取每個客戶端對象對應的ChatEndpoint對象  //static:共用
	private static Map<String, ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();
	
	//聲明session對象,通過該對象可以發送消息給指定用戶
	private Session session;
	
	//存取目前所有在線用戶的session,用來記錄目前誰在線上
	//private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();
	
	
	
	//連接建立時使用
	@OnOpen
	public void onOpen(Session session, @PathParam("userName") String userName, EndpointConfig config) {
		// 取得Httpsession的很麻煩的動作
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		
		Register existing =  (Register) httpSession.getAttribute("existing");
		userName = existing.getAccount(); 
		//將局部session對想賦值給成員session
		this.session=session;		
		//儲存已連線用戶的EndPoint //this是目前chatPoint對象
		onlineUsers.put(userName, this);		
		System.out.println(userName + " 加入聊天室;");
		//livingSessions.put(userName, session);
		sendMessageToAll(userName + " 加入聊天室");
	}

	//接收到client端發送數據時使用
	@OnMessage
	public void onMessage(String message, Session session, @PathParam("userName") String userName) throws JsonProcessingException {
		// sendMessageToAll(userName + " : " + message);
		//session = livingSessions.get(session.getId());
		try {
			//將String message 轉換成message bean
			ObjectMapper mapper = new ObjectMapper();
			Message mess = mapper.readValue(message, Message.class);
			//獲取傳送對象
			String toName = mess.getToName();
			System.out.println(toName);
			//獲取傳送的訊息
			String messagetext = mess.getMessagetext();
			System.out.println(messagetext);
	
			//透過toName找到對方的session,把訊息給對方
			String getResultMessageString =MessageUtils.getResultMessage(false ,userName, messagetext);
			System.out.println("onMessage: "+userName);
			onlineUsers.get(toName).session.getAsyncRemote().sendText(getResultMessageString);
			
			//將當前在線用戶(系統消息)推給所有用戶
//			String systemResultMessageString = MessageUtils.getResultMessage(true, null, getOnlineNames());
//			sendMessageToAll(systemResultMessageString);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} 
		//sendMessage(session, userName + " : " + message);
	}
	
	
	//取得所有在線用戶
	private Set<String> getOnlineNames(){
		return onlineUsers.keySet();
	}
	
	
	//發生錯誤時使用
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}
	
	//連接關閉時使用
	@OnClose
	public void onClose(Session session, @PathParam("userName") String userName) {
		onlineUsers.remove(userName);
		//livingSessions.remove(session.getId());
		sendMessageToAll(userName + " 退出聊天室");
	}

	// 群發
	public void sendMessageToAll(String message) {
		//透過onlineUsers取得endPoint集合,然後再取得對應的session
		Set<String> names = onlineUsers.keySet();
		for (String name : names) {
		ChatEndpoint chatEndpoint = onlineUsers.get(name);
		chatEndpoint.session.getAsyncRemote().sendText(message);
		}
				
		//透過livingSessions的session集合 取得要傳送的客戶端session
		/*livingSessions.forEach((sessionId, session) -> {
			sendMessage(session, message);
		});*/
	}

	// 單獨聊天
	/*public void sendMessage(Session session, String message) {		
		onlineUsers.get(toUsername).session.getAsyncRemote().sendText(message);		
		session.getAsyncRemote().sendText(message);
	}*/
}

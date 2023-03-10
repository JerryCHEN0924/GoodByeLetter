package com.iSpanProject.GoodByeletter.controller.Tina.ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@SessionAttributes({"authenticated","existing"})
public class ChatWebSocketHandler extends TextWebSocketHandler{
	
	private final List<WebSocketSession> webSocketSessions = new ArrayList<>();
	
	private void broadCast(String message) {
		for (WebSocketSession webSocketSession : webSocketSessions) {
			try {
				webSocketSession.sendMessage(new TextMessage(message));			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		webSocketSessions.add(session);
		System.out.println("=============");
		System.out.println(session.getAttributes().get("existing"));
		System.out.println("=============");
		broadCast(session.getAttributes().get("existing")+"#"+session.getId().substring(0, 5)+":"+"connected...");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String clientMessage = message.getPayload();
		
		//標註時間格式
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss EEEE");
		//設定時間
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateFormat.format(date));
//		broadCast(String.format("【%s#%s】%s", session.getAttributes().get("authenticated"),
//				session.getId().substring(0, 5) + "...", clientMessage));
		broadCast( session.getAttributes().get("authenticated")+ "#"+
				session.getId().substring(0, 5) + ":"+ clientMessage);
//		broadCast(dateFormat.format(date));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		webSocketSessions.remove(session);
		broadCast(session.getAttributes().get("existing")+"#"+session.getId().substring(0, 5)+":"+"disconnected...");
	}
	

}

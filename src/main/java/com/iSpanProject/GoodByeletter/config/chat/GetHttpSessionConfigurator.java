package com.iSpanProject.GoodByeletter.config.chat;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		//透過HandshakeRequest獲取Httpsession對象
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		//將HttpSession存到ServerEndpointConfig
		sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
	}
}
package com.iSpanProject.GoodByeletter.config.chat;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {
	
	@Bean
	//注入ServerEndpointExporter bean對象,自動註冊使用@ServerEndpoint註解的bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

}

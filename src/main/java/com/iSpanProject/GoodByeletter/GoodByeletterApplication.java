package com.iSpanProject.GoodByeletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoodByeletterApplication {
	
//	@Autowired
//	private SendMailService sendMailService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GoodByeletterApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() throws MessagingException {
//		sendMailService.sendEmail("ldesf28961234@gmail.com","123","123");
//	}

}

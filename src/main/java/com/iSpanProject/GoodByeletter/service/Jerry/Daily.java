package com.iSpanProject.GoodByeletter.service.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;

// 專案啟動後，每天早上XX點會自動執行程式碼
@Component
@EnableScheduling
@PropertySource("classpath:GoodByeLetter.properties")
public class Daily {
	@Value("${GBL.dailyJob}")
	private String time;

	@Autowired
	LastNoteDao ld;
	
	@Autowired
	VerifyService vs;


	// @Scheduled(cron = "秒 分 時 日 月 年")
	@Scheduled(cron = "${GBL.dailyJob}")
	public void dailyWork() {
		//搞笑
		System.out.println("=====================");
		System.out.println("我要轉職軟體工程師!!我要年薪百萬!!!我要進Google!!!!!");
		System.out.println("=====================");
		
//		驗證日為當日，寄出驗證信給使用者本人
		vs.checkLocalDateWithVerifyDateAndSendVerifyEmail();
		
//		驗證日過期2天，寄驗證信給第二驗證人
//		vs.checkLocalDateWithVerifyDateAndSendVerifyEmail2();
		
//		驗證日過期6天，將GoodBye Letter寄給指定收件人
//		vs.sendUserGoodByeLetter();
		
	}



}

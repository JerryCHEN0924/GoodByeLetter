package com.iSpanProject.GoodByeletter.service.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;

// 專案啟動後，每天早上八點會自動執行程式碼
@Component
@EnableScheduling

public class Daily {

	@Autowired
	LastNoteDao ld;
	
	@Autowired
	LastnoteService ls;



	// @Scheduled(cron = "秒 分 時 日 月 年")
	@Scheduled(cron = "00 00 11 * * ?")
	public void dailyWork() {
		//搞笑
		System.out.println("=====================");
		System.out.println("我要轉職軟體工程師!!我要年薪百萬!!!我要進Google!!!!!");
		System.out.println("=====================");
		
		//這個service會執行透過驗證日到期找遺囑並執行寄信功能
		ls.checkLocalDateWithVerifyDate();
	}



}

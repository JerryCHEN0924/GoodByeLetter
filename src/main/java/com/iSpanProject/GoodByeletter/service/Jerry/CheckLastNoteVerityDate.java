package com.iSpanProject.GoodByeletter.service.Jerry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

@Component
public class CheckLastNoteVerityDate {

//這邊是GPT先產生的每日檢查資料庫用法。
	    @Autowired
	    private LastNoteDao lDao;

	    @Scheduled(cron = "0 0 9 * * ?") // 每天上午 9 點執行
	    public void checkExpirationDate() {
	        List<LastNote> entities = lDao.findAll();
	        for (LastNote entity : entities) {
//	            if (entity.getVerifyTime().isBefore(LocalDate.now())) {
//	                // 資料已經到期，進行相應的操作
//	                // 例如發送通知、更新資料、刪除資料等等
//	            }
	        }
	    }
	

}

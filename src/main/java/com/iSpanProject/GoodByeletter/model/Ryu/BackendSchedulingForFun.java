package com.iSpanProject.GoodByeletter.model.Ryu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@PropertySource("classpath:RyuzScheduling.properties")
public class BackendSchedulingForFun {
	
	
	@Value("${ryuz.joke.01}")
	private String ryuzFun01;
	
	@Value("${ryuz.joke.02}")
	private String ryuzFun02;
	
	@Value("${ryuz.joke.03}")
	private String ryuzFun03;
	
	@Value("${ryuz.joke.04}")
	private String ryuzFun04;
	
	@Value("${ryuz.joke.05}")
	private String ryuzFun05;
	
	
	
	
	// @Scheduled(cron = "秒 分 時 日 月 年")
//	@Scheduled(cron = "00 38 10 * * ?")
	@Scheduled(cron = "${ryuz.joke.01}")
	@Scheduled(cron = "${ryuz.joke.02}")
	@Scheduled(cron = "${ryuz.joke.03}")
	@Scheduled(cron = "${ryuz.joke.04}")
	@Scheduled(cron = "${ryuz.joke.05}")
	public void wulala() {
		
		// 我也要玩
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("「桃花塢裏桃花庵，桃花庵下桃花仙。桃花仙人種桃樹，又摘桃花換酒錢。\r\n"
				+ "酒醒隻在花前坐，酒醉還來花下眠。半醒半醉日複日，花落花開年複年。\r\n"
				+ "但願老死花酒間，不願鞠躬車馬前。車塵馬足顯者勢，酒盞花枝隱士緣。\r\n"
				+ "若將顯者比隱士，一在平地一在天。若將花酒比車馬，彼何碌碌我何閑。\r\n"
				+ "別人笑我太瘋癲，我笑他人看不穿。不見五陵豪傑墓，無花無酒鋤作田…」");
		System.out.println("=================================");
		System.out.println("=================================");
		
	}
	
	


}

package com.iSpanProject.GoodByeletter.controller.YiJie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;
import com.iSpanProject.GoodByeletter.model.YiJie.YJLevelRespository;

public class YJLevelController {
	
	@Autowired
	private YJLevelRespository levelDao;
	
	@ResponseBody
	@PostMapping("/levelname1")
	public YJLevel savelevel1() {
		YJLevel level1 = new YJLevel();
		level1.setLevelName("一般會員");
		level1.setPlevel(1);
		YJLevel retLevel = levelDao.save(level1);
		return retLevel;
	}
	
	@ResponseBody
	@PostMapping("/levelname2")
	public YJLevel saveleve2() {
		YJLevel level2 = new YJLevel();
		level2.setLevelName("廠商會員");
		level2.setPlevel(2);
		YJLevel retLeve2 = levelDao.save(level2);
		return retLeve2;
	}
	
}

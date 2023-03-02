package com.iSpanProject.GoodByeletter.controller.YiJie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.YiJie.YJLevelRespository;

@Controller
public class YJLevelController {
	
	@Autowired
	private YJLevelRespository levelDao;
	
	@ResponseBody
	@PostMapping("/levelname1")
	public Level savelevel1() {
		Level level1 = new Level();
		level1.setPlevel(1);
		level1.setLevelName("一般會員");
		
		Level retLevel = levelDao.save(level1);
		return retLevel;
	}
	
	@ResponseBody
	@PostMapping("/levelname2")
	public Level saveleve2() {
		Level level2 = new Level();		
		level2.setPlevel(2);
		level2.setLevelName("廠商會員");
		Level retLeve2 = levelDao.save(level2);
		return retLeve2;
	}
	
}

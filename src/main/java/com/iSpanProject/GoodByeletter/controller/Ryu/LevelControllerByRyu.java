package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Ryu.LevelRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;

@Controller
public class LevelControllerByRyu {
	
	@Autowired
	private LevelRepositoryByRyu levelDao;
	
	@ResponseBody
	@PostMapping("/levelByRyu/addTest")
	public String saveLevel() {
		
		LevelByRyu l1 = new LevelByRyu();
		
		
		l1.setLevelName("超級管理員");
		
		levelDao.save(l1);
		
		return "OKOK";
		
		
	}
	
	
	
	
	
	
	
	
	
	


}

package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Ryu.LevelRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;
import com.iSpanProject.GoodByeletter.service.Ryu.LevelServiceByRyu;

@Controller
public class LevelControllerByRyu {
	
	@Autowired
	private LevelRepositoryByRyu levelRepositoryByRyu;
	
	
	@Autowired
	private LevelServiceByRyu levelServiceByRyu;
	
	
	@ResponseBody
	@PostMapping("/levelByRyu/addTest")
	public String saveLevel() {
		
		LevelByRyu l1 = new LevelByRyu();
		
		
		l1.setLevelName("超級管理員");
		
		levelRepositoryByRyu.save(l1);
		
		return "OKOK";
		
	}
	
	
	
	@GetMapping("/topGun/LevelByRyu/add")
	public String addNewLevelPage(Model model) {
		
		LevelByRyu l1 = new LevelByRyu();
		model.addAttribute("levelByRyu", l1);
		
		
		return "/Ryu/ryuzAddLevel";
		
		
	}
	
	
	@PostMapping("/topGun/LevelByRyu/post")
	public String addLevelPost(@ModelAttribute LevelByRyu l1, Model model ) {
		
		levelServiceByRyu.insert(l1);
		
		LevelByRyu l2 = new LevelByRyu();
		model.addAttribute("levelByRyu", l2);
		
		return "/Ryu/ryuzAddLevel";
		
	}
	
	
	
	
	
	
	
	


}

package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	@GetMapping("/topGun/levelByRyu/add")
	public String addNewLevelPage(Model model) {
		
		LevelByRyu l1 = new LevelByRyu();
		model.addAttribute("levelByRyu", l1);
		
		
		return "/Ryu/ryuzAddLevel";
		
		
	}
	
	
	@PostMapping("/topGun/levelByRyu/post")
	public String addLevelPost(@ModelAttribute LevelByRyu l1, Model model ) {
		
		levelServiceByRyu.insert(l1);
		
		LevelByRyu l2 = new LevelByRyu();
		model.addAttribute("levelByRyu", l2);
		
		return "/Ryu/ryuzAddLevel";
		
	}
	
	
	
	
	@GetMapping("/topGun/levelByRyu/page")
	public String showLevelByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		
		Page<LevelByRyu> page = levelServiceByRyu.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/ryuzShowLevel";
		
		
	}
	
	
	
	@GetMapping("/topGun/levelByRyu/edit")
	public String editLevelPage(@RequestParam("pLevel") Integer pLevel, Model model) {
		
		LevelByRyu l1 = levelServiceByRyu.findById(pLevel);
		
		model.addAttribute("levelByRyu", l1);
		
		return "/Ryu/ryuzEditLevel";
		
		
	}
	
	
	
	@PutMapping("/topGun/levelByRyu/editPost")
	public String editPostLevel(@ModelAttribute("levelByRyu") LevelByRyu levelByRyu) {
		
		levelServiceByRyu.insert(levelByRyu);
		
		return "redirect:/topGun/levelByRyu/page";
		
		
		
	}
	
	
	
	@DeleteMapping("/topGun/levelByRyu/delete")
	public String deleteLevel(@RequestParam("pLevel") Integer pLevel) {
		
		levelServiceByRyu.deleteById(pLevel);
		
		return "redirect:/topGun/levelByRyu/page";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

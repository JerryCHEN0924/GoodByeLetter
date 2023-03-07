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

import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLevelService;





@Controller
public class BackendLevelController {
	
	
	@Autowired
	private BackendLevelService backendLevelService;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	// 新增權限等級跳頁
	@GetMapping("/topGun/level/add")
	public String addNewLevelForm(Model model) {
		
		Level level = new Level();
		
		model.addAttribute("level", level);
		
		return "/Ryu/backendAddNewLevelForm";
		
	}
	
	
	
	// 新增權限等級
	@PostMapping("/topGun/level/post")
	public String addLevelPost(@ModelAttribute("level") Level level, Model model ) {
		
		backendLevelService.insertLevel(level);
		
		Level newlevel = new Level();
		
		model.addAttribute("level", newlevel);
		
		return "/Ryu/backendAddNewLevelForm";
		
	}
	
	
	
	// 分頁查詢
	@GetMapping("/topGun/level/page")
	public String showLevelByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Level> page = backendLevelService.findLevelByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowLevel";
		
	}
	
	
	
	// 修改權限等級跳頁
	@GetMapping("/topGun/level/edit")
	public String editLevelPage(@RequestParam("plevel") Integer plevel, Model model) {
		
		Level level = backendLevelService.findLevelById(plevel);
		
		model.addAttribute("level", level);
		
		return "/Ryu/backendEditLevelForm";
		
	}
	
	
	
	// 修改權限等級
	@PutMapping("/topGun/level/editPost")
	public String editPostLevel(@ModelAttribute("level") Level level) {
		
		backendLevelService.insertLevel(level);
		
		return "redirect:/topGun/level/page";
		
	}
	
	
	
	// 刪除權限等級
	@DeleteMapping("/topGun/level/delete")
	public String deleteLevel(@RequestParam("plevel") Integer plevel) {
		
		backendLevelService.deleteLevelById(plevel);
		
		return "redirect:/topGun/level/page";
		
	}
	
	
	
	
	
	
	
	
	
	

}

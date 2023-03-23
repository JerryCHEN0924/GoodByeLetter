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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLevelService;





@Controller
@RequestMapping("/topGun")
public class BackendLevelController {
	
	
	@Autowired
	private BackendLevelService backendLevelService;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	// 新增權限等級跳頁
	@GetMapping("/level/add")
	public String addNewLevelForm(Model model) {
		
		Level level = new Level();
		
		model.addAttribute("level", level);
		
		return "/Ryu/backendAddNewLevelForm";
		
	}
	
	
	
	// 新增權限等級
	@PostMapping("/level/post")
	public String addLevelPost(@ModelAttribute("level") Level level, Model model,
			 RedirectAttributes redirectAttributes) {
		
		String levelName = level.getLevelName();
		
		boolean checkLevelExist = backendLevelService.checkLevelExist(levelName);
		
		if(checkLevelExist) {
			
			redirectAttributes.addFlashAttribute("backendHomeMessages", "權限名稱 [ " + levelName + " ] 已存在");
			
			return "redirect:/topGun/level/add";
			
		}
		
		
		backendLevelService.insertLevel(level);
		
//		Level newlevel = new Level();
//		
//		model.addAttribute("level", newlevel);
		
//		return "/Ryu/backendAddNewLevelForm";
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "權限名稱 [ " + levelName + " ] 新增成功");
		
		return "redirect:/topGun/level/add";
		
	}
	
	
	
	// 分頁查詢
	@GetMapping("/level/page")
	public String showLevelByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Level> page = backendLevelService.findLevelByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowLevel";
		
	}
	
	
	
	// 修改權限等級跳頁
	@GetMapping("/level/edit")
	public String editLevelPage(@RequestParam("plevel") Integer plevel, Model model) {
		
		Level level = backendLevelService.findLevelById(plevel);
		
		model.addAttribute("level", level);
		
		return "/Ryu/backendEditLevelForm";
		
	}
	
	
	
	// 修改權限等級
	@PutMapping("/level/editPost")
	public String editPostLevel(@ModelAttribute("level") Level level,
			 RedirectAttributes redirectAttributes) {
		
		String levelName = level.getLevelName();
		
		backendLevelService.insertLevel(level);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "權限名稱 [ " + levelName + " ] 修改成功");
		
		
		return "redirect:/topGun/level/page";
		
	}
	
	
	
	// 刪除權限等級
	@DeleteMapping("/level/delete")
	public String deleteLevel(@RequestParam("plevel") Integer plevel,
			 RedirectAttributes redirectAttributes) {
		
		Level presentLevel = backendLevelService.findLevelById(plevel);
		
		String levelName = presentLevel.getLevelName();
		
		backendLevelService.deleteLevelById(plevel);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "權限名稱 [ " + levelName + " ] 刪除成功");
		
		return "redirect:/topGun/level/page";
		
	}
	
	
	
	
	
	
	
	
	
	

}

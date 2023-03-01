package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;

@Controller
public class LastNoteController {
	
	@Autowired
	private LastNoteDao lastNoteDao;

	@Autowired
	private LastnoteService lastnoteService;
	
	//撰寫遺囑頁面
	@GetMapping("/LastNote")
	public String addNote(Model model) {
		LastNote lastnote = new LastNote();
		model.addAttribute("lastNote",lastnote);
		return "Jerry/LastNote";
	}
	
	//Post方法，存入遺囑
	@PostMapping("/LastNote/post")
	public String addLastNote(@ModelAttribute("lastNote") LastNote lastNote) {
		lastnoteService.SaveLastNote(lastNote);
		return "redirect:/LastNote";
	}
	
	//遺囑編輯頁面
	@GetMapping("/LastNoteCRUD")
	public String LastNoteCRUD() {
		return "Jerry/LastNoteCRUD";
	}
	
	//JSON方式存入遺囑頁面
//	@ResponseBody
//	@PostMapping("/LastNote/addJSON")
//	public LastNote SaveLastNoteJSON(@RequestBody LastNote lastNote) {
//		return lastNoteDao.save(lastNote);
//	}
	
}

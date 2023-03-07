package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;

@Controller
public class LastNotePageController {

	@Autowired
	private LastnoteService lastnoteService;
	
	// 跳頁，進入撰寫遺囑頁面。
	@GetMapping("/LastNote")
	public String addNote(Model model) {
		LastNote lastnote = new LastNote();
		model.addAttribute("lastNote", lastnote);
		return "Jerry/LastNote";
	}

	// 跳頁，進入編輯遺囑頁面。
	@GetMapping("/LastNote/edit")
	public String LastNoteEdit(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<LastNote> page = lastnoteService.findByPage(pageNumber);
		model.addAttribute("page", page);
		return "Jerry/LastNoteEditPage";
	}
	
}

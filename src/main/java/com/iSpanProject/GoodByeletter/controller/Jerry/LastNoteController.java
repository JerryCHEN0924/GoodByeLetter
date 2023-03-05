package com.iSpanProject.GoodByeletter.controller.Jerry;

import javax.servlet.http.HttpSession;

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

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;

@Controller
public class LastNoteController {

	@Autowired
	private LastnoteService lastnoteService;
	
	//跳頁，進入撰寫遺囑頁面
	@GetMapping("/LastNote")
	public String addNote(Model model) {
		LastNote lastnote = new LastNote();
		model.addAttribute("lastNote",lastnote);
		return "Jerry/LastNote";
	}
	
	//Post方法，存入遺囑後，重新導向到個人遺囑編輯頁面
	@PostMapping("/LastNote/post")
	public String addLastNote(@ModelAttribute("lastNote") LastNote lastNote,HttpSession session) {
		lastnoteService.SaveLastNote(lastNote, null);
		return "redirect:/LastNote/edit";
	}
	
	//跳頁，進入編輯遺囑頁面
	@GetMapping("/LastNote/edit")
	public String LastNoteEdit(@RequestParam(name="p",defaultValue = "1") Integer pageNumber, Model model) {
		Page<LastNote> page = lastnoteService.findByPage(pageNumber);
		model.addAttribute("page",page);
		return "Jerry/LastNoteEditPage";
	}
	
//	跳頁按鈕，進入遺囑更新與刪除頁面
	@GetMapping("/LastNote/CRUD")
	public String LastNoteCRUD(@RequestParam("noteId")Integer id,Model model) {
		LastNote nId = lastnoteService.findById(id);
		model.addAttribute("nId",nId);
		return "Jerry/LastNoteCRUDPage";
	}
	
//	遺囑編輯Put請求更新資料後，跳轉回LastNoteEditPage
	@PutMapping("/LastNote/CRUD/put")
	public String LastNoteCRUDPut(@ModelAttribute("nId")LastNote lastnote) {
		lastnoteService.SaveLastNote(lastnote, null);
		return "redirect:/LastNote/edit";
		
	}
	
	
//	遺囑刪除
	@DeleteMapping("/LastNote/CRUD/delete")
	public String LastNoteCRUDdelete(@RequestParam("noteId") Integer id) {
		lastnoteService.deleteById(id);
		return "redirect:/LastNote/edit";
		
	}
	
	
	//JSON方式存入遺囑頁面
//	@ResponseBody
//	@PostMapping("/LastNote/addJSON")
//	public LastNote SaveLastNoteJSON(@RequestBody LastNote lastNote) {
//		return lastNoteDao.save(lastNote);
//	}
	
}

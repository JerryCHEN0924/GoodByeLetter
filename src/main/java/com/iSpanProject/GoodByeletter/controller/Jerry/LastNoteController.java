package com.iSpanProject.GoodByeletter.controller.Jerry;

import javax.mail.MessagingException;
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
import com.iSpanProject.GoodByeletter.service.Jerry.SendMail;

@Controller
public class LastNoteController {

	@Autowired
	private LastnoteService lastnoteService;
	@Autowired
	private SendMail sm;
	
	//Post方法，存入遺囑後，重新導向到個人遺囑編輯頁面
	@PostMapping("/LastNote/post")
	public String addLastNote(@ModelAttribute("lastNote") LastNote lastNote) {
		lastnoteService.SaveLastNote(lastNote);
		return "redirect:/LastNote/edit";
	}
	
//	按鈕，跳頁進入遺囑更新與刪除頁面
	@GetMapping("/LastNote/CRUD")
	public String LastNoteCRUD(@RequestParam("noteId")Integer id,Model model) {
		LastNote nId = lastnoteService.findById(id);
		model.addAttribute("nId",nId);
		return "Jerry/LastNoteCRUDPage";
	}
	
//	遺囑編輯Put請求更新資料後，跳轉回LastNoteEditPage
	@PutMapping("/LastNote/CRUD/put")
	public String LastNoteCRUDPut(@ModelAttribute("nId")LastNote lastnote) {
		lastnoteService.SaveLastNote(lastnote);
		return "redirect:/LastNote/edit";
		
	}
	
	
//	遺囑刪除
	@DeleteMapping("/LastNote/CRUD/delete")
	public String LastNoteCRUDdelete(@RequestParam("noteId") Integer id) {
		lastnoteService.deleteById(id);
		return "redirect:/LastNote/edit";
		
	}
	
//	寄信功能成功
//	try {
//		sm.sendEmail("jk2455892@gmail.com", "test", "testemail");
//	} catch (MessagingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	//JSON方式存入遺囑頁面
//	@ResponseBody
//	@PostMapping("/LastNote/addJSON")
//	public LastNote SaveLastNoteJSON(@RequestBody LastNote lastNote) {
//		return lastNoteDao.save(lastNote);
//	}
	
}

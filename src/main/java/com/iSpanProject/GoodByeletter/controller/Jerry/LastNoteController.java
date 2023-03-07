package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;
import com.iSpanProject.GoodByeletter.service.Jerry.SendMail;

@Controller
@SessionAttributes("existing")
public class LastNoteController {

	@Autowired
	private LastnoteService lastnoteService;
	@Autowired
	private SendMail sm;
	
	//Post方法，存入遺囑後，重新導向到個人遺囑編輯頁面
	@PostMapping("/LastNote/post")
	public String addLastNote(@ModelAttribute("lastNote") LastNote lastNote,Model model) {
//		目前只能從前端送會員外鍵進來，無法使用32-33行程式碼，從後端寫入會員外鍵，報錯原因說是分離物件無法存入永續物件中，待解。		
//		Register memberid = (Register) model.getAttribute("existing");
//		lastNote.setFK_memberId(memberid);
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
	public String LastNoteCRUDPut(@ModelAttribute("noteId")LastNote lastnote) {
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

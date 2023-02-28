package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNoteRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Controller
public class LastNoteController {
	
	@Autowired
	private LastNoteRepository lastNoteRepositDao;
	
//	@GetMapping("/LastNote")
//	public String note(Model model) {
//		//MemberDetail memberdetail = new MemberDetail();
//		return "LastNote";
//	}
	
	//測試失敗
	@ResponseBody
	@PostMapping("/LastNote/add")
	public LastNote SaveLastNote() {
		LastNote lastNote1 = new LastNote();
		lastNote1.setNotedetail("遺書內容測試");
		lastNote1.setRecipientEmail("test@gmail.com");
		lastNote1.setVerify1("testaaa1");
		LastNote returnLastNote = lastNoteRepositDao.save(lastNote1);
		return returnLastNote;
	}
	
	@ResponseBody
	@PostMapping("/LastNote/addJSON")
	public LastNote SaveLastNoteJSON(@RequestBody LastNote lastNote) {
		return lastNoteRepositDao.save(lastNote);
	}
}

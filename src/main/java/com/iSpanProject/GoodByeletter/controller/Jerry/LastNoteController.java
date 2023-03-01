package com.iSpanProject.GoodByeletter.controller.Jerry;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Controller
public class LastNoteController {
	
	@Autowired
	private LastNoteDao lastNoteDao;
	private RegisterDao registerDao;
	
//	@GetMapping("/LastNote")
//	public String note(Model model) {
//		//MemberDetail memberdetail = new MemberDetail();
//		return "LastNote";
//	}
	
	

	//測試
	@ResponseBody
	@PostMapping("/LastNote/add")
	public LastNote SaveLastNote() {
		Optional<Register> member = registerDao.findById(2);
		Register memberId = member.get();
		LastNote lastNote1 = new LastNote();
		lastNote1.setNotedetail("遺書內容測試");
		lastNote1.setRecipientEmail("test@gmail.com");
		lastNote1.setVerify1("testaaa1");
		lastNote1.setFK_memberId(memberId); 
		LastNote returnLastNote = lastNoteDao.save(lastNote1);
		return returnLastNote;
	}
	
	@ResponseBody
	@PostMapping("/LastNote/addJSON")
	public LastNote SaveLastNoteJSON(@RequestBody LastNote lastNote) {
		return lastNoteDao.save(lastNote);
	}
}

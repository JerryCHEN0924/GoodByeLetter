package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLastNoteService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;
import com.iSpanProject.GoodByeletter.validate.LastNoteValidator;

@Controller
@SessionAttributes({"authenticated","existing"})
public class BackendLastNoteController {
	
	
	@Autowired
	private BackendLastNoteService backendLastNoteService;
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增LastNote跳頁
	@GetMapping("/topGun/lastNote/add")
	public String addNewLastNoteForm(Model model) {
		
		LastNote lastNote = new LastNote();
		
		model.addAttribute("lastNote", lastNote);
		
		return "/Ryu/backendAddNewLastNoteForm";
		
	}
	
	
	
	// 新增LastNote
	@PostMapping("/topGun/lastNote/post")
	public String addNewLastNotePost(@ModelAttribute("lastNote") LastNote lastNote, Model model, BindingResult bindingResult) {
		
		new LastNoteValidator().validate(lastNote, bindingResult);
		
		System.out.println("新增LastNote資料: " + lastNote);
		
		if (bindingResult.hasErrors()) {
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			
			System.out.println("======================");
			return "/Ryu/backendAddNewLastNoteForm";
			
		}
		
		System.out.println("bean==>" + lastNote);
		
		Register register = (Register) model.getAttribute("authenticated");
		
		lastNote.setFK_memberId(register);
		
		
		
//		Register register = (Register) model.getAttribute("authenticated");
//		
//		Integer memberId = register.getMemberId();
//		
//		Optional<Register> optional = backendRegisterRepository.findById(memberId);
//		
//		if(optional.isPresent()) {
//			
//			System.out.println("====================");
//			System.out.println("====================");
//			System.out.println(optional.get());
//			System.out.println("====================");
//			System.out.println("====================");
//			
//		}
//		
//		Register lastNoteFK = optional.get();
//		
//		lastNote.setFK_memberId(lastNoteFK);
		
		
		
		
		
		
		backendLastNoteService.insertLastNote(lastNote);
		
		return "redirect:/topGun/lastNote/add";
		
	}
	
	
	
	// 分頁查詢LastNote
	@GetMapping("/topGun/lastNote/page")
	public String showLastNoteByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		
		Page<LastNote> page = backendLastNoteService.findLastNoteByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowLastNote";
		
	}
	
	
	
	// 修改LastNote跳頁
	@GetMapping("/topGun/lastNote/edit")
	public String editLastNotePage(@RequestParam("noteId") Integer noteId, Model model) {
		
		LastNote lastNote = backendLastNoteService.findLastNoteById(noteId);
		
		model.addAttribute("lastNote", lastNote);
		
		return "/Ryu/backendEditLastNoteForm";
		
		
	}
	
	
	
	// 修改LastNote
	@PutMapping("/topGun/lastNote/editPost")
	public String editPostLastNote(@ModelAttribute("lastNote") LastNote lastNote) {
		
		backendLastNoteService.updateLastNote(lastNote);
		
		return "redirect:/topGun/lastNote/page";
		
	}
	
	
	
	// 刪除LastNote
	@DeleteMapping("/topGun/lastNote/delete")
	public String deleteBoard(@RequestParam("noteId") Integer noteId) {
		
		backendLastNoteService.deleteLastNoteById(noteId);
		
		return "redirect:/topGun/lastNote/page";
		
	}
	
	
	
	// 依帳號查詢LastNote跳頁
	@GetMapping("/topGun/lastNote/queryLikeAccount")
	public String getLastNoteByAccountForm(Model model) {
		
		Register register = new Register();
		model.addAttribute("register", register);
		
		return "/Ryu/backendShowLastNoteByAccount";
	}
	
	
	// 依帳號查詢LastNote
	public String getLastNoteByAccount(@RequestParam("account") String account, Model model) {
		
		List<Register> register = backendRegisterService.findRegisterByAccountNativeLikeQuery(account);
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendShowLastNoteByAccount";
		
	}
	
	
	
	
	
	
	
	
	
	


}

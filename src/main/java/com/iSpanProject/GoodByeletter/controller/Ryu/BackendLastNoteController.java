package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.List;

import org.jasypt.encryption.StringEncryptor;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLastNoteService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;
import com.iSpanProject.GoodByeletter.validate.LastNoteValidator;

@Controller
@SessionAttributes({"authenticated","existing"})
@RequestMapping("/topGun")
public class BackendLastNoteController {
	
	
	@Autowired
	private BackendLastNoteService backendLastNoteService;
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	
	@Autowired
	private StringEncryptor stringEncryptor;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增LastNote跳頁
	@GetMapping("/lastNote/add")
	public String addNewLastNoteForm(Model model) {
		
		LastNote lastNote = new LastNote();
		
		model.addAttribute("lastNote", lastNote);
		
		return "/Ryu/backendAddNewLastNoteForm";
		
	}
	
	
	
	// 新增LastNote
	@PostMapping("/lastNote/post")
	public String addNewLastNotePost(@ModelAttribute("lastNote") LastNote lastNote,
			Model model, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes) {
		
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
		
		Register register = (Register) model.getAttribute("existing");
		
		String account = register.getAccount();
		
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
		
		
//		####################### Ryuz divider #######################
		
		// 加密 GoodBye Letter 開始
		String notedetail = lastNote.getNotedetail();
		String encrypt = stringEncryptor.encrypt(notedetail);
		lastNote.setNotedetail(encrypt);
		// 加密  GoodBye Letter 結束
		
//		####################### i am divider #######################
		
		
		
		
		backendLastNoteService.insertLastNote(lastNote);
		
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] GoodBye Letter 新增成功");
		
		
		return "redirect:/topGun/lastNote/add";
		
	}
	
	
	
	// 分頁查詢LastNote
	@GetMapping("/lastNote/page")
	public String showLastNoteByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		
		Page<LastNote> page = backendLastNoteService.findLastNoteByPage(pageNumber);
		
		
//		####################### Ryuz divider #######################
		
		// 加密 GoodBye Letter 開始	
		if (!page.isEmpty()) {
			for (LastNote lastNote : page) {
				String notedetail = lastNote.getNotedetail();
				String decrypt = stringEncryptor.decrypt(notedetail);
				lastNote.setNotedetail(decrypt);
			}
		}
		// 加密  GoodBye Letter 結束
		
//		####################### i am divider #######################
		
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowLastNote";
		
	}
	
	
	
	
	
	
	
	
	// 修改LastNote跳頁
	@GetMapping("/lastNote/edit")
	public String editLastNotePage(@RequestParam("noteId") Integer noteId, Model model) {
		
		LastNote lastNote = backendLastNoteService.findLastNoteById(noteId);
		
		model.addAttribute("lastNote", lastNote);
		
		return "/Ryu/backendEditLastNoteForm";
		
		
	}
	
	
	
	// 修改LastNote
	@PutMapping("/lastNote/editPost")
	public String editPostLastNote(@ModelAttribute("lastNote") LastNote lastNote, 
			RedirectAttributes redirectAttributes) {
		
		Integer lastNoteId = lastNote.getNoteId();
		
		
		
//		####################### Ryuz divider #######################
		
		// 加密 GoodBye Letter 開始
		String notedetail = lastNote.getNotedetail();
		String encrypt = stringEncryptor.encrypt(notedetail);
		lastNote.setNotedetail(encrypt);
		// 加密  GoodBye Letter 結束
		
//		####################### i am divider #######################
		
		
		
		
		
		backendLastNoteService.updateLastNote(lastNote);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "編號 [ " + lastNoteId + " ] GoodBye Letter 修改成功");
		
		return "redirect:/topGun/lastNote/page";
		
	}
	
	
	
	// 刪除LastNote
	@DeleteMapping("/lastNote/delete")
	public String deleteBoard(@RequestParam("noteId") Integer noteId, 
			RedirectAttributes redirectAttributes) {
		
		backendLastNoteService.deleteLastNoteById(noteId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "編號 [ " + noteId + " ] GoodBye Letter 修改成功");
		
		return "redirect:/topGun/lastNote/page";
		
	}
	
	
	
	// 依帳號查詢LastNote跳頁
	@GetMapping("/lastNote/queryLikeAccount")
	public String getLastNoteByAccountForm(Model model) {
		
//		Register register = new Register();
//		model.addAttribute("register", register);
		
		return "/Ryu/backendShowLastNoteByAccount";
	}
	
	
	// 依帳號查詢LastNote
	@GetMapping("/lastNote/queryLikeAccountPost")
	public String getLastNoteByAccount(@RequestParam("account") String account, Model model) {
		
		List<Register> register = backendRegisterService.findRegisterByAccountNativeLikeQuery(account);
		
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(register);
		System.out.println("=====================");
		System.out.println("=====================");
		
		
		
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendShowLastNoteByAccount";
		
	}
	
	// 依帳號查詢LastNote的Detail
	@GetMapping("/lastNote/queryLikeAccountDetail")
	public String getLastNoteByAccountDetail(@RequestParam("fkm") Register register, Model model) {
		
		List<LastNote> lastNoteDetail = backendLastNoteService.findLastNoteByAccountGroupByFKM(register);
		
		
		
//		####################### Ryuz divider #######################
		
		// 加密 GoodBye Letter 開始	
		if (!lastNoteDetail.isEmpty()) {
			for (LastNote lastNote : lastNoteDetail) {
				String notedetail = lastNote.getNotedetail();
				String decrypt = stringEncryptor.decrypt(notedetail);
				lastNote.setNotedetail(decrypt);
			}
		}
		// 加密  GoodBye Letter 結束
		
//		####################### i am divider #######################
		
		
		
		model.addAttribute("lastNoteDetail", lastNoteDetail);
		
		return "/Ryu/backendShowLastNoteDetailByAccount";
		
	}
	
	
	
	
	
	
	// 條件搜尋之修改LastNote跳頁
	@GetMapping("/lastNote/editByAccount")
	public String editLastNotePageByAccount(@RequestParam("noteId") Integer noteId, Model model) {
		
		LastNote lastNote = backendLastNoteService.findLastNoteById(noteId);
		
		model.addAttribute("lastNote", lastNote);
		
		return "/Ryu/backendHomeEditLastNoteForm";
		
		
	}
	
	
	
	
	
	// 條件搜尋之修改LastNote
	@PutMapping("/lastNote/editPostByAccount")
	public String editPostLastNoteByAccount(@ModelAttribute("lastNote") LastNote lastNote, 
			RedirectAttributes redirectAttributes) {
		
		Integer lastNoteId = lastNote.getNoteId();
		
		Register presentRegister = lastNote.getFK_memberId();
		
		String account = presentRegister.getAccount();
		
//		####################### Ryuz divider #######################
		
		// 加密 GoodBye Letter 開始
		String notedetail = lastNote.getNotedetail();
		String encrypt = stringEncryptor.encrypt(notedetail);
		lastNote.setNotedetail(encrypt);
		// 加密  GoodBye Letter 結束
		
//		####################### i am divider #######################
		
		
		backendLastNoteService.updateLastNote(lastNote);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ]，編號 [ " + lastNoteId + " ] GoodBye Letter 修改成功");
		
		return "redirect:/topGun/lastNote/queryLikeAccount";
		
	}
		
	
	
	
	
	// 刪除LastNote
	@DeleteMapping("/lastNote/deleteByAccount")
	public String deleteLastNoteByAccount(@RequestParam("noteId") Integer noteId, 
			RedirectAttributes redirectAttributes) {
		
		LastNote presentLastNote = backendLastNoteService.findLastNoteById(noteId);
		
		Register presentRegister = presentLastNote.getFK_memberId();
		
		String account = presentRegister.getAccount();
		
		backendLastNoteService.deleteLastNoteById(noteId);
		
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ]，編號 [ " + noteId + " ] GoodBye Letter 刪除成功");
		
		return "redirect:/topGun/lastNote/queryLikeAccount";
		
	}
	
	
	
	
	
	
	


}

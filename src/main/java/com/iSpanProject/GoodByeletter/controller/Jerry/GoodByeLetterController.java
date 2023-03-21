package com.iSpanProject.GoodByeletter.controller.Jerry;

import java.util.List;

import javax.validation.Valid;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;

@Controller
@SessionAttributes("existing")
@RequestMapping("/LastNote")
@Validated
public class GoodByeLetterController {

	@Autowired
	private LastnoteService lastnoteService;

	@Autowired
	private StringEncryptor stringEncryptor;

	// 跳頁，進入撰寫遺囑頁面。
	@GetMapping("")
	public String addNote(Model model) {
		// 如果不是會員，就導向去登入頁面
//		if (!model.containsAttribute("existing")) {
//			return "redirect:/register/login1";
//		}
		LastNote lastnote = new LastNote();
		model.addAttribute("lastNote", lastnote);
		return "Jerry/LastNote";
	}

	// Post方法存入遺囑，重新導向到遺囑編輯頁面，目前採前端表單控制輸入欄位，但後端因為使用validation驗證資料，還沒有用方法去捕捉錯誤並處理，回傳的畫面會很醜。
	@PostMapping("/post")
	public String addLastNote(@Valid @ModelAttribute("lastNote") LastNote lastNote, Model model,
			RedirectAttributes redirectAttributes, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// 如果有錯誤訊息，返回錯誤訊息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			redirectAttributes.addFlashAttribute("errorMessages", allErrors);
			return "Jerry/LastNote";
		} else {
			Register memberid = (Register) model.getAttribute("existing");
			lastNote.setFK_memberId(memberid);

			// 加密
			String notedetail = lastNote.getNotedetail();
			String encrypt = stringEncryptor.encrypt(notedetail);
			lastNote.setNotedetail(encrypt);
			// 加密結束

			lastnoteService.SaveLastNote(lastNote);
			return "redirect:/LastNote/edit";
		}

	}

	// 跳頁，進入編輯遺囑頁面。
	@GetMapping("/edit")
	public String LastNoteEdit(Model model) {
		// 如果不是會員，就導向去登入頁面
//		if (!model.containsAttribute("existing")) {
//			return "redirect:/login1";
//		}
		Register memberid = (Register) model.getAttribute("existing");
		List<LastNote> lastNotes = lastnoteService.findlastNoteBymember(memberid);
		// 解密
		if (!lastNotes.isEmpty()) {
			for (LastNote lastNote : lastNotes) {
				String notedetail = lastNote.getNotedetail();
				String decrypt = stringEncryptor.decrypt(notedetail);
				lastNote.setNotedetail(decrypt);
			}
		}
		// 解密結束
		model.addAttribute("lastNotes", lastNotes);
		return "Jerry/LastNoteEditPage";
	}

//	按鈕，跳頁進入遺囑更新與刪除頁面
	@GetMapping("/CRUD")
	public String LastNoteCRUD(@RequestParam("noteId") Integer id, Model model) {
		LastNote nId = lastnoteService.findById(id);
		// 解密
		String notedetail = nId.getNotedetail();
		String decrypt = stringEncryptor.decrypt(notedetail);
		nId.setNotedetail(decrypt);
		// 解密結束
		model.addAttribute("nId", nId);
		return "Jerry/LastNoteCRUDPage";
	}

//	Put請求更新編輯遺囑，跳轉回LastNoteEditPage
	@PutMapping("/CRUD/put")
	public String LastNoteCRUDPut(@ModelAttribute("noteId") @Valid LastNote lastNote) {
		// 加密
		String notedetail = lastNote.getNotedetail();
		String encrypt = stringEncryptor.encrypt(notedetail);
		lastNote.setNotedetail(encrypt);
		// 加密結束
		lastnoteService.SaveLastNote(lastNote);
		return "redirect:/LastNote/edit";

	}

//	遺囑刪除
	@DeleteMapping("/CRUD/delete")
	public String LastNoteCRUDdelete(@RequestParam("noteId") Integer id) {
		lastnoteService.deleteById(id);
		return "redirect:/LastNote/edit";

	}


}

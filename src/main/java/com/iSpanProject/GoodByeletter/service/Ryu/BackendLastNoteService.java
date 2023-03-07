package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendLastNoteRepository;
import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
@SessionAttributes({"authenticated","existing"})
public class BackendLastNoteService {
	
	@Autowired
	private BackendLastNoteRepository backendLastNoteRepository;
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增LastNote
	public void insertLastNote(LastNote lastNote) {
		
//	public void insertLastNote(LastNote lastNote, Model model) {
		
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
		
		backendLastNoteRepository.save(lastNote);
		
		
	}
	
	
	
	// 查詢ID找留言
	public LastNote findLastNoteById(Integer id) {
		
		Optional<LastNote> optional = backendLastNoteRepository.findById(id);
		
		if(optional.isEmpty()) {
			
			return null;
			
		}
		
		return optional.get();
		
	}
	
	
	
	// 查詢ID找留言2
	public LastNote getLastNoteById(Integer id) {
		
		LastNote lastNote = null;
		
		Optional<LastNote> optional = backendLastNoteRepository.findById(id);
		
		if(optional.isPresent()) {
			
			lastNote = optional.get();
			
		}
		
		return lastNote;
		
	}
	
	
	
	// 查詢ID刪除留言
	public void deleteLastNoteById(Integer id) {
		
		Optional<LastNote> optional = backendLastNoteRepository.findById(id);
		
		if(optional.isPresent()) {
			
			backendLastNoteRepository.deleteById(id);
			
		}
		
	}
	
	
	
	// 分頁功能
	public Page<LastNote> findLastNoteByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "noteId");
		
		Page<LastNote> page = backendLastNoteRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	// 修改LastNote
	public void updateLastNote(LastNote lastNote) {
		
		backendLastNoteRepository.save(lastNote);
		
	}
	
	
	// 依帳號查詢LastNote跳頁
	
	
	
	
	
	
	
	
	

}

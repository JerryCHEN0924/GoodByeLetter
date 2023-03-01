package com.iSpanProject.GoodByeletter.service.Jerry;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
public class LastnoteService {

	@Autowired
	private LastNoteDao lDao;
	@Autowired
	private RegisterDao registerDao;

	@Transactional
	public void SaveLastNote(LastNote lastNote) {
		//外鍵的會員ID欄位待補
		Optional<Register> member = registerDao.findById(2);
		Register m1 = member.get();
		lastNote.setFK_memberId(m1);
		lDao.save(lastNote);
	}
	
	@Transactional
	public void insert(LastNote lastNote) {
		lDao.save(lastNote);
		
	}

	@Transactional
	public LastNote findById(Integer id) {
		Optional<LastNote> optional = lDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Transactional
	public void deleteById(Integer id) {
		lDao.deleteById(id);
	}
	
	@Transactional
	public void deleteByEntity(LastNote lastNote) {
		lDao.delete(lastNote);
	}
	
	public Page<LastNote> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 3,Sort.Direction.ASC,"noteId");
		Page<LastNote> page = lDao.findAll(pgb);
		return page;
	}
	
	public LastNote updateById(Integer id,String newNotedetail) {
		Optional<LastNote> optional = lDao.findById(id);
		if(optional.isPresent()) {
			LastNote lastNote = optional.get();
			lastNote.setNotedetail(newNotedetail);
			return lastNote;
		}
		System.out.println("沒有這筆資料。");
		return null;
		
	}
	
}

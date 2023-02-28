package com.iSpanProject.GoodByeletter.service.Jerry;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

@Service
public class LastnoteService {

	@Autowired
	private LastNoteDao lDao;

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

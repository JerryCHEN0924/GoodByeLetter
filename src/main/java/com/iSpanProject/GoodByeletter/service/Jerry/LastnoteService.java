package com.iSpanProject.GoodByeletter.service.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

@Service
public class LastnoteService {
	@Autowired
	private LastNoteDao lDao;
	
	@Transactional
	public void save(LastNote lastnote) {
		lDao.save(lastnote);
	}
}

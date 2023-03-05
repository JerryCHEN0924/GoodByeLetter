package com.iSpanProject.GoodByeletter.service.Jerry;


import java.util.Optional;

import javax.servlet.http.HttpSession;

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
	public void SaveLastNote(LastNote lastNote,HttpSession session) {
		
//		Register memberid = (Register) session.getAttribute("帶有會員資料的物件屬性名");
//		lastNote.setFK_memberId(memberid);
//		待亮竹會員登入系統完成，有會員物件的session後才可改為上面方式，以下方法獲得會員ID外鍵為暫時性作法。
		Integer mId = lastNote.getmId();
		Optional<Register> member = registerDao.findById(mId);
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

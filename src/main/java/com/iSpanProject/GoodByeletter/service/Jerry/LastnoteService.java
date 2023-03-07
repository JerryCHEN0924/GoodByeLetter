package com.iSpanProject.GoodByeletter.service.Jerry;

import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

import net.bytebuddy.utility.RandomString;

@Service
public class LastnoteService {

	@Autowired
	private LastNoteDao lDao;

	@Autowired
	private RegisterDao registerDao;

	@Autowired
	private Validator validator;

	@Transactional
	public void SaveLastNote(LastNote lastNote) {
//		####以下是驗證####
//		String token = RandomString.make(64);
//		lastNote.setVerificationCode(token);
//		####以上是驗證####
		lDao.save(lastNote);
//		Set<ConstraintViolation<LastNote>> violations = validator.validate(lastNote);
//		if (!violations.isEmpty()) {
//			StringBuilder sb = new StringBuilder();
//			for (ConstraintViolation<LastNote> constraintViolation : violations) {
//				sb.append(constraintViolation.getMessage());
//			}
//			throw new ConstraintViolationException(sb.toString(), violations);
//		}
//		LastNote newUser = lDao.save(lastNote);
//	}

//		我是分隔線，以上是資料驗證，只完成40%，先丟一旁，優先研究驗證。
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
		Optional<LastNote> optional = lDao.findById(id);
		if (optional.isPresent()) {
			lDao.deleteById(id);
		}
	}

	@Transactional
	public void deleteByEntity(LastNote lastNote) {
		lDao.delete(lastNote);
	}

	public Page<LastNote> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.ASC, "noteId");
		Page<LastNote> page = lDao.findAll(pgb);
		return page;
	}

//	public LastNote updateById(Integer id, String newNotedetail) {
//		Optional<LastNote> optional = lDao.findById(id);
//		if (optional.isPresent()) {
//			LastNote lastNote = optional.getClass();
//			lastNote.
//			return lastNote;
//		}
//		System.out.println("沒有這筆資料。");
//		return null;

//	}

}

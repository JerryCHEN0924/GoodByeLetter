package com.iSpanProject.GoodByeletter.service.Jerry;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;

import net.bytebuddy.utility.RandomString;

@Service
@SessionAttributes("existing")
public class LastnoteService {

	@Autowired
	private LastNoteDao lDao;

	@Autowired
	private MemberDetailService mds;

	@Autowired
	private SendMail sendMail;

//	@Autowired
//	private GenerateJWT generateJWT;
//	
//	@Autowired
//	private VerifyJWT verifyJWT;

//	@Autowired
//	private Validator validator;

	@Transactional
	public void SaveLastNote(LastNote lastNote) {
		Register member = lastNote.getFK_memberId();
//		####JWT測試####
//		String account = member.getAccount();
//		String token2 = generateJWT.createToken(account, new Date(System.currentTimeMillis() + 7200000) , "GoodByeLetter.iii");
//		####JWT測試####

//		####當遺囑儲存，存入一組驗證碼並將Enabled狀態轉為false####
		String token = RandomString.make(64);
		lastNote.setVerificationCode(token);
		lastNote.setEnabled(false);
//		####當遺囑儲存，存入一組驗證碼並將Enabled狀態轉為false####

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
	
	public List<LastNote> findlastNoteBymember(Register register) {
		return lDao.findLastNoteBymemberId(register);
		
	}
	
	
	@Transactional
	public LastNote findById(Integer id) {
		Optional<LastNote> optional = lDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<LastNote> findAll() {

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

}

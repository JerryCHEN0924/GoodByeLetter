package com.iSpanProject.GoodByeletter.service.Jerry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

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
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;

import net.bytebuddy.utility.RandomString;

@Service
@SessionAttributes("existing")
public class LastnoteService {

	@Autowired
	private LastNoteDao lDao;

	@Autowired
	MemberDetailService mds;

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

	// 寄送驗證信
	public void sendVerificationEmail() {

		// ###思考如何抓到「驗證日到期」的「收件人Email」###
//		String memberEmail = md.getEmail();
//		String lastnoteVerificationCode = ln.getVerificationCode();
		// ###思考如何抓到「驗證日到期」的「收件人Email」###

		Optional<LastNote> optional = lDao.findById(10);
		LastNote lastNote = optional.get();
		String verificationCode = lastNote.getVerificationCode();
		String subject = "請驗證您在GoodBye Letter的信件";
		String mailContent = "親愛的使用者，請點擊連結以進行驗證:" + "http://localhost:8080/index/LastNote/verify?code="
				+ verificationCode + "，若於收到信的X時間內未驗證通過，您存放的信件會自動寄出。謝謝您。好好說再見開發團隊敬上";

		try {
			sendMail.sendEmail("jk2455892@gmail.com", subject, mailContent);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	// 檢查TOKEN 成功
	public void checkToken(String token) {
		Optional<LastNote> optional = lDao.findById(10);
		LastNote lastNote = optional.get();
		String verificationCode = lastNote.getVerificationCode();
		System.out.println("===========================");
		System.out.println(token);
		System.out.println(verificationCode);
		System.out.println("===========================");
		if (verificationCode.equals(token)) {
			lastNote.setEnabled(true);
			lDao.save(lastNote);
		} else {
			System.out.println("87做錯了呵呵");
		}
	}

	// 檢查JWT
	public void checkJWT(String token) {
		Optional<LastNote> optional = lDao.findById(10);
		LastNote lastNote = optional.get();
		String verificationCode = lastNote.getVerificationCode();
//		verifyJWT.isTokenExpired(token, "GoodByeLetter.iii");
	}

	public List<String> checkLocalDateWithVerifyDate() {
		LocalDate today = LocalDate.now();
		List<LastNote> verifyLetter = lDao.findLastNoteVerifyTimeQuery(today);

		for (LastNote lastNote : verifyLetter) {
			Register member = lastNote.getFK_memberId();
			String subject = "請驗證您在GoodBye Letter的信件";
			String verificationCode = lastNote.getVerificationCode();
			String mailContent = "親愛的使用者，請點擊連結以進行驗證:" + "http://localhost:8080/index/LastNote/verify?code="
					+ verificationCode + "，若於收到信的X時間內未驗證通過，您存放的信件會自動寄出。謝謝您。好好說再見開發團隊敬上";
			Integer memberId = member.getMemberId();
			MemberDetail memberDetail = mds.findById(memberId);
			String email = memberDetail.getEmail();
			// 在for迴圈中開始寄信
			try {
				sendMail.sendEmail(email, subject, mailContent);
			} catch (MessagingException e) {
				System.out.println("失敗送不出去");
				e.printStackTrace();
			}
		}
		return null;
	}

}

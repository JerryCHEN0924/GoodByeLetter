package com.iSpanProject.GoodByeletter.service.Jerry;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;

@Service
@SessionAttributes("existing")
public class VerifyService {

	@Autowired
	private LastNoteDao lDao;

	@Autowired
	MemberDetailService mds;

	@Autowired
	private SendMail sendMail;

	// 檢查TOKEN
	public boolean checkToken(String token) {
		boolean exists = lDao.existsByverificationCode(token);
		// 透過TOKEN去對比資料庫內的TOKE，如果有比對到，則將驗證日向後推移六個月
		if (exists) {
			LastNote ln = lDao.findByverificationCode(token);
			Date today = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(today);
			calendar.add(Calendar.MONTH, 6);
			Date newDate = calendar.getTime();
			ln.setVerifyTime(newDate);
			lDao.save(ln);
			return true;
		} else {
			return false;
		}

	}

	// 每日檢查會啟動的功能2:檢測資料庫內的驗證日是否超過兩天，若超過視為驗證失敗，將寄出資料庫內的信
	public void sendUserGoodByeLetter() {
		LocalDate today = LocalDate.now();

		List<LastNote> allData = lDao.findAll();
		for (LastNote lastNote : allData) {
			Date verifyTime = lastNote.getVerifyTime();
			LocalDate dbDate = verifyTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			// 如果驗證日期比今天日期慢兩天，就寄信
			if (dbDate.isBefore(today.minusDays(2))) {
				lastNote.setEnabled(true);
				lDao.save(lastNote);
				String recipientEmail = lastNote.getRecipientEmail();
				String subject = "From GoodByeLetter好好說再見";
				String notedetail = lastNote.getNotedetail();
				try {
					sendMail.sendEmail(recipientEmail, subject, notedetail);
				} catch (MessagingException e) {
					System.out.println("寄出遺囑信件失敗。");
					e.printStackTrace();
				}
			}

		}

	}

	// 每日檢查會啟動的功能1:撈出資料庫內是否有驗證日為今日的遺書，有的話寄出驗證信。
	public void checkLocalDateWithVerifyDateAndSendVerifyEmail() {
		LocalDate today = LocalDate.now();
		List<LastNote> verifyLetter = lDao.findLastNoteVerifyTimeQuery(today);
		if (verifyLetter != null) {
			for (LastNote lastNote : verifyLetter) {
				Register member = lastNote.getFK_memberId();
				String subject = "請驗證您在GoodBye Letter的信件";
				String verificationCode = lastNote.getVerificationCode();
				String mailContent = "親愛的使用者，請點擊連結以進行驗證:" + "http://localhost:8080/index/LastNote/verify?code="
						+ verificationCode + "，若於收到信的48小時內未驗證通過，您存放的信件會自動寄出。謝謝您。好好說再見開發團隊敬上";
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
		} else {
			System.out.println("=================");
			System.out.println("就空的你要我做什麼?????");
			System.out.println("=================");
		}
	}

	// 檢查JWT
	public void checkJWT(String token) {
		Optional<LastNote> optional = lDao.findById(10);
		LastNote lastNote = optional.get();
		String verificationCode = lastNote.getVerificationCode();
//		verifyJWT.isTokenExpired(token, "GoodByeLetter.iii");
	}

	// 寄送驗證信
//	public void sendVerificationEmail() {

	// ###思考如何抓到「驗證日到期」的「收件人Email」###
//		String memberEmail = md.getEmail();
//		String lastnoteVerificationCode = ln.getVerificationCode();
	// ###思考如何抓到「驗證日到期」的「收件人Email」###
//
//		Optional<LastNote> optional = lDao.findById(10);
//		LastNote lastNote = optional.get();
//		String verificationCode = lastNote.getVerificationCode();
//		String subject = "請驗證您在GoodBye Letter的信件";
//		String mailContent = "親愛的使用者，請點擊連結以進行驗證:" + "http://localhost:8080/index/LastNote/verify?code="
//				+ verificationCode + "，若於收到信的X時間內未驗證通過，您存放的信件會自動寄出。謝謝您。好好說再見開發團隊敬上";
//
//		try {
//			sendMail.sendEmail("jk2455892@gmail.com", subject, mailContent);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}

	// 檢查TOKEN (完成但寫死不好)
//	public void checkToken(String token) {
//		Optional<LastNote> optional = lDao.findById(10);
//		LastNote lastNote = optional.get();
//		String verificationCode = lastNote.getVerificationCode();
//		if (verificationCode.equals(token)) {
//			lastNote.setEnabled(true);
//			lDao.save(lastNote);
//		} else {
//			System.out.println("87做錯了呵呵");
//		}
//	}

}

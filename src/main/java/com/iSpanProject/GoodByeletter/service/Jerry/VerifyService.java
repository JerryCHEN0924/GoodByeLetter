package com.iSpanProject.GoodByeletter.service.Jerry;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.Jerry.LastNoteDao;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;

@Service
@SessionAttributes("existing")
@PropertySource("classpath:GoodByeLetter.properties")
public class VerifyService {

	@Value("${GBL.extendVerifyMonth}")
	private Integer extendVerifyMonth;
	
	@Value("${GBL.secondVerifyDay}")
	private Integer secondVerifyDay;

	@Value("${GBL.verifyFailDay}")
	private Integer verifyFailDay;

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
			calendar.add(Calendar.MONTH, extendVerifyMonth);
			Date newDate = calendar.getTime();
			ln.setVerifyTime(newDate);
			lDao.save(ln);
			return true;
		} else {
			return false;
		}

	}

	// Daily功能1:撈出資料庫內是否有「驗證日為今日」的遺書，有的話向「使用者」寄出驗證信。
	public void checkLocalDateWithVerifyDateAndSendVerifyEmail() {
		LocalDate today = LocalDate.now();
		List<LastNote> verifyLetter = lDao.findLastNoteVerifyTimeQuery(today);
		if (!verifyLetter.isEmpty()) {
			for (LastNote lastNote : verifyLetter) {
				Integer noteId = lastNote.getNoteId();
				Integer memberId = lastNote.getFK_memberId().getMemberId();
				System.out.println("===================");
				System.out.println(memberId);
				System.out.println("===================");
				MemberDetail memberDetail = mds.findByMemberId(memberId);
				String memberName = memberDetail.getName();
				String verificationCode = lastNote.getVerificationCode();
				
				String subject = memberName +"，請驗證您在GoodBye Letter的信件";
				String mailContent = "<h2>親愛的使用者，本日為您GoodBye Letter編號:「"+ noteId +"」的驗證日。</h2><br>"
						+ "<span style='font-size:20px;color:blue;'>請點擊連結以進行驗證:</span>" 
						+ "<a href='http://localhost:8080/index/LastNote/verify?code="+ verificationCode +"'>" 
						+ "<span style='font-size:20px;color:red;'>驗證連結</span></a><br>"
						+ "<span style='font-size:16px;'>請於收到驗證信的48小時內進行驗證，系統會將驗證信寄給您指定的第二驗證人，進行第二階段驗證。<br>"
						+ "若第二驗證人收到信後，於48小時後也未進行驗證，則會將您保存的信件寄出給指定收件人。</span><br>"
						+ "<span style='font-size:14px;'>謝謝您。好好說再見開發團隊敬上</span>";
				String email = memberDetail.getEmail();
				
				System.out.println("===即將寄信到" + email + "===");

				try {
					sendMail.sendEmail(email, subject, mailContent);
				} catch (MessagingException e) {
					System.out.println("寄信失敗");
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("=================");
			System.out.println("空的，Do Nothing，下班。");
			System.out.println("=================");
		}
	}

	// Daily功能2:撈出資料庫內是否有「驗證日過期兩天」的遺書，有的話向「第二驗證人」寄出驗證信。
	public void checkLocalDateWithVerifyDateAndSendVerifyEmail2() {
		LocalDate today = LocalDate.now();
		List<LastNote> allData = lDao.findAll();
		for (LastNote lastNote : allData) {
			Date verifyTime = lastNote.getVerifyTime();
			LocalDate dbDate = verifyTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (dbDate.isBefore(today.minusDays(secondVerifyDay))) {
				Integer memberId = lastNote.getFK_memberId().getMemberId();
				MemberDetail memberDetail = mds.findByMemberId(memberId);
				String memberName = memberDetail.getName();
				String verificationCode = lastNote.getVerificationCode();

				String subject = "請協助驗證「" + memberName + "」在GoodBye Letter的信件";
				String mailContent = "<h2>您好，這是一封來自GoodBye Letter的驗證信件</h2>。" 
						+ "<span style='font-size:20px;'>因「" + memberName + "」先生/小姐指定您為GoodBye Letter的第二驗證人，"
						+ "若您確認「" + memberName + "」依然健在，" + "請點擊連結以進行驗證:</span>"
						+ "<a href='http://localhost:8080/index/LastNote/verify?code="+ verificationCode +"'>"
						+ "<span style='font-size:20px;color:green;'>驗證連結</span></a><br>"
						+ "<span style='font-size:16px;;'>若您未於收到信後的48小時進行驗證，「" + memberName + "」存放的信件將會自動寄出。</span>" 
						+ "<span style='font-size:14px;'>謝謝。好好說再見開發團隊敬上</span>";

				String email = lastNote.getVerify1();
				String email2 = lastNote.getVerify2();
				System.out.println("===即將寄信到" + email + "===");

				try {
					sendMail.sendEmail(email, subject, mailContent);
					sendMail.sendEmail(email2, subject, mailContent);
				} catch (MessagingException e) {
					System.out.println("信件寄送失敗");
					e.printStackTrace();
				}
			} 
		}
	}

	// Daily功能3:檢測資料庫內的驗證日是否超過五天，若超過視為驗證失敗，寄出GoodBye Letter。
	public void sendUserGoodByeLetter() {
		LocalDate today = LocalDate.now();
		List<LastNote> allData = lDao.findAll();
		for (LastNote lastNote : allData) {
			Date verifyTime = lastNote.getVerifyTime();
			LocalDate dbDate = verifyTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			// 如果驗證日期比今天日期慢兩天，就寄信
			if (dbDate.isBefore(today.minusDays(verifyFailDay))) {
				lastNote.setEnabled(true);
				lDao.save(lastNote);
				Integer memberId = lastNote.getFK_memberId().getMemberId();
				MemberDetail memberDetail = mds.findByMemberId(memberId);
				String memberName = memberDetail.getName();
				
				String recipientEmail = lastNote.getRecipientEmail();
				String subject = "請是一封來自「" + memberName + "」的GoodBye Letter";
				String notedetail = "<span style='font-size:18px;'>" +lastNote.getNotedetail() + "</span>";
				
				try {
					sendMail.sendEmail(recipientEmail, subject, notedetail);
				} catch (MessagingException e) {
					System.out.println("寄出遺囑信件失敗。");
					e.printStackTrace();
				}
			}

		}

	}

	// 檢查JWT
//	public void checkJWT(String token) {
//		Optional<LastNote> optional = lDao.findById(10);
//		LastNote lastNote = optional.get();
//		String verificationCode = lastNote.getVerificationCode();
//		verifyJWT.isTokenExpired(token, "GoodByeLetter.iii");
//	}

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

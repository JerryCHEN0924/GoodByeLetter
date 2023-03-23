package com.iSpanProject.GoodByeletter.service.Jerry;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.jasypt.encryption.StringEncryptor;
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

	@Autowired
	private StringEncryptor stringEncryptor;

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
				MemberDetail memberDetail = mds.findByMemberId(memberId);
				String memberName = memberDetail.getName();
				String verificationCode = lastNote.getVerificationCode();

				String subject = memberName + "，請驗證您在GoodBye Letter的信件";
				String mailContent = "<h2>親愛的使用者，本日為您GoodBye Letter編號:「" + noteId + "」的驗證日。</h2>"
						+ "<span style='font-size:20px;color:blue;'>請點擊連結以進行驗證:</span>"
						+ "<a href='http://localhost:8080/index/LastNote/verify?code=" + verificationCode + "'>"
						+ "<span style='font-size:20px;color:red;'>驗證連結</span></a><br>"
						+ "<span style='font-size:16px;color:black'>"
						+ "請於收到驗證信的48小時內進行驗證。若未於48小時內通過驗證，系統會將驗證信寄給您指定的第二驗證人，進行第二階段驗證。<br>"
						+ "若第二驗證人收到信後，於48小時後也未進行驗證，則會將您保存的信件寄出給指定收件人。</span><br>"
						+ "---------------------------------------------------------------<br>"
						+ "<span style='font-size:14px;'>謝謝您。好好說再見開發團隊敬上</span>";
				String email = memberDetail.getEmail();
				if (email.isEmpty())
					return;

				try {
					sendMail.sendEmail(email, subject, mailContent);
					System.out.println("========");
					System.out.println("寄出TOKEN驗證信給會員本人");
					System.out.println("========");
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
		// 找出狀態為尚未啟用的遺書
		List<LastNote> allData = lDao.findByenabledFalse();
		if (!allData.isEmpty()) {
			for (LastNote lastNote : allData) {
				Date verifyTime = lastNote.getVerifyTime();
				LocalDate dbDate = verifyTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if (dbDate.isBefore(today.minusDays(secondVerifyDay))) {
					Integer memberId = lastNote.getFK_memberId().getMemberId();
					MemberDetail memberDetail = mds.findByMemberId(memberId);
					String memberName = memberDetail.getName();
					String verificationCode = lastNote.getVerificationCode();

					String subject = "請協助驗證「" + memberName + "」在GoodBye Letter的信件";
					String mailContent = "<h2>您好，這是一封來自GoodBye Letter的驗證信件。</h2>" + "<span style='font-size:18px;'>「"
							+ memberName + "」先生/小姐指定您為GoodBye Letter的第二驗證人，" + "若您確認「" + memberName + "」先生/小姐安然無恙，"
							+ "請點擊連結以進行驗證:</span>" + "<a href='http://localhost:8080/index/LastNote/verify?code="
							+ verificationCode + "'>" + "<span style='font-size:20px;color:green;'>驗證連結</span></a><br>"
							+ "<br><span style='font-size:16px;;'>若您未於收到信後的48小時進行驗證，「" + memberName
							+ "」先生/小姐存放的信件將會自動寄出。</span>" + "<br>---------------------<br>"
							+ "<span style='font-size:14px;'>謝謝。好好說再見開發團隊敬上</span>";

					String email = lastNote.getVerify1();
					String email2 = lastNote.getVerify2();
					if (email.isEmpty() || email2.isEmpty())
						return;

					try {
						sendMail.sendEmail(email, subject, mailContent);
						sendMail.sendEmail(email2, subject, mailContent);
						System.out.println("========");
						System.out.println("寄出第二驗證人驗證信");
						System.out.println("========");
					} catch (MessagingException e) {
						System.out.println("信件寄送失敗");
						e.printStackTrace();
					}
				}
			}
		}

	}

	// Daily功能3:檢測資料庫內的驗證日是否超過六天，若超過視為驗證失敗，寄出GoodBye Letter。
	public void sendUserGoodByeLetter() {
		LocalDate today = LocalDate.now();
		List<LastNote> allData = lDao.findByenabledFalse();
		if (!allData.isEmpty()) {
			for (LastNote lastNote : allData) {
				Date verifyTime = lastNote.getVerifyTime();
				LocalDate dbDate = verifyTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				// 如果驗證日期比今天日期慢六天，就寄信
				if (dbDate.isBefore(today.minusDays(verifyFailDay))) {
					Integer memberId = lastNote.getFK_memberId().getMemberId();
					MemberDetail memberDetail = mds.findByMemberId(memberId);
					String memberName = memberDetail.getName();
					String notedetail = lastNote.getNotedetail();
					// 解密
					String decryptNoteDetail = stringEncryptor.decrypt(notedetail);
					// 解密結束

					String recipientEmail = lastNote.getRecipientEmail();
					String subject = "請是一封來自「" + memberName + "」的GoodBye Letter";
					String body = "<span style='font-size:18px;'>" + decryptNoteDetail + "</span>";
					body += "<br>---------------------<br>" + "<a href='http://localhost:8080/index/LastNote/'>"
							+ "<span style='font-size:14px;color:blue;'>GoodBye Letter 好好說再見</span></a>";
					if (recipientEmail.isEmpty())
						return;

					try {
						sendMail.sendEmail(recipientEmail, subject, body);
						System.out.println("========");
						System.out.println("寄出GoodBye Letter");
						System.out.println("========");
					} catch (MessagingException e) {
						System.out.println("寄出信件失敗。");
						e.printStackTrace();
					}
					lastNote.setEnabled(true);
					lDao.save(lastNote);
				}

			}
		}

	}

}

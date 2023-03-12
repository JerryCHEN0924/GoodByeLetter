package com.iSpanProject.GoodByeletter.service.Lillian;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.Lillian.MemberDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
public class SendMailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MemberDetailDao mDao;

	// 忘記密碼+驗證
	public void sendEmail(String email) throws MessagingException {
		// 檢查電子郵件是否存在
		MemberDetail memberDetail = mDao.findByEmail(email);
		if (memberDetail == null) {
			throw new IllegalArgumentException("User not found for email: " + email);
		}

		// 生成密碼重置連接 限時
		String token = UUID.randomUUID().toString();
		memberDetail.setToken(token);

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MINUTE, 15);
		Date verifyTimeEmail = calendar.getTime();
		memberDetail.setVerifyTimeEmail(verifyTimeEmail);
		mDao.save(memberDetail);

		// 發送重置密碼郵件
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("goodbyeletter.iii@gmail.com");
		message.setTo(email);
		String subject = "Password Reset Request";
		String content = "Click the following link to reset your password: " + "http://localhost:8080/index/?code="
				+ token ;
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);
		System.out.println("Mail Sent successfully...");
	}

	public void updatePassword(String token, String password) {
		// 查找帶有指定重置令牌的用户
		MemberDetail memberDetail = mDao.findByToken(token);
		if (memberDetail == null) {
			throw new IllegalArgumentException("Invalid reset token: " + token);
		}

		// 更新用户密碼
		Register fk_memberId = memberDetail.getFK_memberId();
		fk_memberId.setPassword(password);
		mDao.save(memberDetail);

	}

}

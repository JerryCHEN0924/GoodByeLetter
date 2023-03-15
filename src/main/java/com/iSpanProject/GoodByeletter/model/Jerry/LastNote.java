package com.iSpanProject.GoodByeletter.model.Jerry;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Entity
@Table(name="lastnote")
public class LastNote implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="noteId")
	private Integer noteId;
	
	@ManyToOne //(cascade= CascadeType.PERSIST) 加了此段，後端拿會員物件時會變成分離物件
	@JoinColumn(name="FK_memberId", foreignKey=@ForeignKey(name = "FK_lastnote_member"), nullable = false)
	private Register FK_memberId;
	
	@Email(message = "信箱格式錯誤")
	@NotBlank(message = "信箱不可為空")
	@Column(name="recipientEmail", nullable = false)
	private String recipientEmail;
	
	@Column(name="notedetail",columnDefinition = "nvarchar(500)", nullable = false)
	@Size(min = 0, max=500, message = "字數必須在0到500之間")
	private String notedetail;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="createTime", nullable = false)
	private Date createTime;
	
	@NotBlank(message = "請至少填寫一位第二驗證人")
	@Email(message = "信箱格式錯誤")
	@Column(name="verify1Email")
	private String verify1;
	
	@Email(message = "信箱格式錯誤")
	@Column(name="verify2Email")
	private String verify2;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	@Column(name="verifyTime")
	private Date verifyTime;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name="verificationCode",updatable = false)
	private String verificationCode;


	@PrePersist
	public void onCreate() {
		if(createTime == null) {
			createTime = new Date();
		}
		
		if(verifyTime == null) {
			Date time = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);
//			此功能為存入遺囑時就將驗證日設定為六個月後。
			cal.add(Calendar.MONTH, 6);
			verifyTime = cal.getTime();
		}
	}
	
//	資料更新前會做:
	@PreUpdate
	public void onUpdate() {
		createTime = new Date();
		Date time = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
//		更新遺囑就將驗證日設定當日的六個月後。
		cal.add(Calendar.MONTH, 6);
		verifyTime = cal.getTime();
	}

	public LastNote() {
		super();
	}

	public LastNote(Integer noteId, Register fK_memberId, String recipientEmail, String notedetail, Date createTime,
			String verify1, String verify2, Date verifyTime, Boolean enabled, String verificationCode) {
		super();
		this.noteId = noteId;
		FK_memberId = fK_memberId;
		this.recipientEmail = recipientEmail;
		this.notedetail = notedetail;
		this.createTime = createTime;
		this.verify1 = verify1;
		this.verify2 = verify2;
		this.verifyTime = verifyTime;
		this.enabled = enabled;
		this.verificationCode = verificationCode;

	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public Register getFK_memberId() {
		return FK_memberId;
	}

	public void setFK_memberId(Register fK_memberId) {
		FK_memberId = fK_memberId;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public String getNotedetail() {
		return notedetail;
	}

	public void setNotedetail(String notedetail) {
		this.notedetail = notedetail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getVerify1() {
		return verify1;
	}

	public void setVerify1(String verify1) {
		this.verify1 = verify1;
	}

	public String getVerify2() {
		return verify2;
	}

	public void setVerify2(String verify2) {
		this.verify2 = verify2;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	
	
}

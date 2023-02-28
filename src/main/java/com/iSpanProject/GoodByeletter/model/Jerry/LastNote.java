package com.iSpanProject.GoodByeletter.model.Jerry;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Entity
@Table(name="lastnote")
public class LastNote implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noteId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST })
	@JoinColumn(name="FK_memberId", foreignKey=@ForeignKey(name = "FK_memberDetail_member"))
	private Register FK_memberId;
	
	private String recipientEmail;
	
	private String notedetail;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date createTime;
	
	private String verify1;
	
	private String verify2;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date verifyTime;

	public LastNote() {
		super();
	}

	public LastNote(Integer noteId, Register fK_memberId, String recipientEmail, String notedetail, Date createTime,
			String verify1, String verify2, Date verifyTime) {
		super();
		this.noteId = noteId;
		FK_memberId = fK_memberId;
		this.recipientEmail = recipientEmail;
		this.notedetail = notedetail;
		this.createTime = createTime;
		this.verify1 = verify1;
		this.verify2 = verify2;
		this.verifyTime = verifyTime;
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
	
}

package com.iSpanProject.GoodByeletter.model.Jerry;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lastnote")
public class LastNoteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer fk_memberId;
	
	private String recipientEmail;
	
	private String noteDetail;
	
	private Date createTime;
	
	private String verify1;
	
	private String verify2;
	
	private Date verifyTime;
	//多對一

	public LastNoteBean(Integer id, Integer fk_memberId, String recipientEmail, String noteDetail, Date createTime,
			String verify1, String verify2, Date verifyTime) {
		super();
		this.id = id;
		this.fk_memberId = fk_memberId;
		this.recipientEmail = recipientEmail;
		this.noteDetail = noteDetail;
		this.createTime = createTime;
		this.verify1 = verify1;
		this.verify2 = verify2;
		this.verifyTime = verifyTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFk_memberId() {
		return fk_memberId;
	}

	public void setFk_memberId(Integer fk_memberId) {
		this.fk_memberId = fk_memberId;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public String getNoteDetail() {
		return noteDetail;
	}

	public void setNoteDetail(String noteDetail) {
		this.noteDetail = noteDetail;
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

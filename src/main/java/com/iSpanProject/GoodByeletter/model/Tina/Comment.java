package com.iSpanProject.GoodByeletter.model.Tina;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Entity
@Table(name = "childComment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="id")
	private Integer commentId;

	// @Column(name="reply")
	private String reply;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE")
	// @Column(name="createTime")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE")
	// @Column(name="updateTime")
	private Date updateTime;

	// 連到ParentBoard的id
	@ManyToOne
	@JoinColumn(name = "FK_parentId")
	private Board FK_parentId;

	// 連到Register的id
	@ManyToOne
	@JoinColumn(name = "FK_memberId")
	private Register FK_memberId;
	
	
//	####################### Ryuz divider start #######################
	
	// 暫時性欄位，後台建置Comment使用，不會增加表格欄位
	// 於此類別中，有增加對應之getter/setter
	// 經判斷為操作上必要屬性，由後臺選單選擇之權限而定，與FK_Plevel之getter/setter無關
	// 勿刪、勿刪、勿刪
	@Transient
	private Integer bId;
	
//	======================= Block =======================
	
	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}
	
//	####################### Ryuz divider end #######################
	
	
	
	public Comment() {
		super();
	}
	
	
	

	public Comment(Integer commentId, String reply, Date createTime, Date updateTime, Board fK_parentId,
			Register fK_memberId, Integer bId) {
		super();
		this.commentId = commentId;
		this.reply = reply;
		this.createTime = createTime;
		this.updateTime = updateTime;
		FK_parentId = fK_parentId;
		FK_memberId = fK_memberId;
		this.bId = bId;
	}
	
	
	
	@PrePersist
	public void onCreate() {
		if (createTime == null) {
			createTime = new Date();
		}
	}
	
	

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Board getFK_parentId() {
		return FK_parentId;
	}

	public void setFK_parentId(Board fK_parentId) {
		FK_parentId = fK_parentId;
	}

	public Register getFK_memberId() {
		return FK_memberId;
	}

	public void setFK_memberId(Register fK_memberId) {
		FK_memberId = fK_memberId;
	}
	


}

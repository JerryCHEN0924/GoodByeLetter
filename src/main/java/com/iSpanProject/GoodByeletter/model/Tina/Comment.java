package com.iSpanProject.GoodByeletter.model.Tina;

import java.util.Date;

import javax.persistence.Entity;
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

	public Comment(Integer commentId, String reply, Date createTime, Date updateTime, Board fK_parentId,
			Register fK_memberId) {
		super();
		this.commentId = commentId;
		this.reply = reply;
		this.createTime = createTime;
		this.updateTime = updateTime;
		FK_parentId = fK_parentId;
		FK_memberId = fK_memberId;
	}

	public Comment() {
		super();
	}

}

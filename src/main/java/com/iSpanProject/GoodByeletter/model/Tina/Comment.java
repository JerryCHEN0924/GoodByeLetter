package com.iSpanProject.GoodByeletter.model.Tina;

import java.util.Date;

import javax.persistence.Entity;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Entity
@Table(name = "childComment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="commentId")
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
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FK_parentId")
	private Board board;

	// 連到Register的id
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FK_memberId")
	private Register register;

	
	// 增加創建時間
	@PrePersist
	public void onCreateComment() {
		if(createTime == null) {
			createTime = new Date();
		}
	}
	// 增加更新時間
	@PreUpdate
	public void onUpdateComment() {
		updateTime = new Date();
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

	

	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	
	
	public Comment(Integer commentId, String reply, Date createTime, Date updateTime, Board board, Register register) {
		super();
		this.commentId = commentId;
		this.reply = reply;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.board = board;
		this.register = register;
	}
	public Comment() {
		super();
	}

}

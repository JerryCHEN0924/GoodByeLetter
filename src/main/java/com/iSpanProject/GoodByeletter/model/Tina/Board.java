package com.iSpanProject.GoodByeletter.model.Tina;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "parentBoard")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="id")
	private Integer boardId;

	// @Column(name="title")
	private String title;

	// @Column(name="boradMessage")
	private String boardMessage;


	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	// @Column(name="createTime")
	private Date createTime;


	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS", timezone = "GMT+8")
	// @Column(name="updateTime")
	private Date updateTime;

	// 連到Register的memberId
	@ManyToOne
	@JoinColumn(name = "FK_memberId")
	private Register register;

	// 連到ChildCommet
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	Set<Comment> comments = new HashSet<>();

	// 增加創建時間
	@PrePersist
	public void onCreate() {
		if (createTime == null) {
			createTime = new Date();
		}
	}

	// 增加更新時間
	@PreUpdate
	public void onUpdate() {
		updateTime = new Date();
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardMessage() {
		return boardMessage;
	}

	public void setBoardMessage(String boardMessage) {
		this.boardMessage = boardMessage;
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

	

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	

	public Board(Integer boardId, String title, String boardMessage, Date createTime, Date updateTime,
			Register register, Set<Comment> comments) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.boardMessage = boardMessage;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.register = register;
		this.comments = comments;
	}

	public Board() {
		super();
	}

}

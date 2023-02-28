package com.iSpanProject.GoodByeletter.model.Tina;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Entity(name ="ChildCommet")
@Table(name="childCommet")
public class Commet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer commetId;
	
	//@Column(name="reply")
	private Clob reply;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss EEEE")
	//@Column(name="createTime")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss EEEE")	
	//@Column(name="updateTime")
	private Date updateTime;
	
	
	//連到ParentBoard的id
	@ManyToOne
	@JoinColumn(name = "FK_parentId" )
	private Board parentBoard; 
	
	//連到Register的id
	@ManyToOne
	@JoinColumn(name = "FK_memberId" )
	private Register01 register01;

	public Commet() {
		super();
	}

	

	public Commet(Integer commetId, Clob reply, Date createTime, Date updateTime, Board parentBoard,
			Register01 register01) {
		super();
		this.commetId = commetId;
		this.reply = reply;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.parentBoard = parentBoard;
		this.register01 = register01;
	}



	public Integer getCommetId() {
		return commetId;
	}

	public void setCommetId(Integer commetId) {
		this.commetId = commetId;
	}

	public Clob getReply() {
		return reply;
	}

	public void setReply(Clob reply) {
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

	public Board getParentBoard() {
		return parentBoard;
	}

	public void setParentBoard(Board parentBoard) {
		this.parentBoard = parentBoard;
	}

	public Register01 getRegister01() {
		return register01;
	}

	public void setRegister01(Register01 register01) {
		this.register01 = register01;
	}

	
	
	

}

package com.iSpanProject.GoodByeletter.model.Tina;

import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name ="ParentBoard")
@Table(name = "parentBoard")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer boradId;
	
	
	//@Column(name="boradMessage")
	private Clob boardMessage;
	
	
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
	
	
	//連到Register的memberId
	@ManyToOne
	@JoinColumn(name ="FK_memberId" )
	private Register01 register01;
	
	//連到ChildCommet
	@OneToMany(mappedBy = "parentBoard", cascade = CascadeType.ALL)
	Set<Commet> comments = new HashSet<>();
	
	
	public Board() {
		super();
	}


	


	public Board(Integer boradId, Clob boardMessage, Date createTime, Date updateTime, Register01 register01,
			Set<Commet> comments) {
		super();
		this.boradId = boradId;
		this.boardMessage = boardMessage;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.register01 = register01;
		this.comments = comments;
	}





	public Integer getBoradId() {
		return boradId;
	}


	public void setBoradId(Integer boradId) {
		this.boradId = boradId;
	}


	public Clob getBoardMessage() {
		return boardMessage;
	}


	public void setBoardMessage(Clob boardMessage) {
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


	

	public Register01 getRegister01() {
		return register01;
	}


	public void setRegister01(Register01 register01) {
		this.register01 = register01;
	}


	public Set<Commet> getComments() {
		return comments;
	}


	public void setComments(Set<Commet> comments) {
		this.comments = comments;
	}





}

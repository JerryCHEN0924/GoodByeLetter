package com.iSpanProject.GoodByeletter.model.Ryu;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="memberByRyu")
public class MemberByRyu {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberId")
	private Integer memberId;
	
	
	@Column(name = "account")
	private String account;
	
	
	@Column(name = "password")
	private String password;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="registerTime")
	private Date registerTime;
	
	
	@JsonBackReference // 不要進行序列化，由另外一邊進行
	@JoinColumn(name="FK_Plevel")
	@ManyToOne(cascade=CascadeType.ALL)
	private LevelByRyu level;


	public MemberByRyu() {
		super();
	}
	
	
	@PrePersist
	public void onCreate() {
		if(registerTime == null) {
			registerTime = new Date();
		}
	}


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getRegisterTime() {
		return registerTime;
	}


	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}


//	public LevelByRyu getLevel() {
//		return level;
//	}
//
//
//	public void setLevel(LevelByRyu level) {
//		this.level = level;
//	}
	
	
	
	
	
	
	


}

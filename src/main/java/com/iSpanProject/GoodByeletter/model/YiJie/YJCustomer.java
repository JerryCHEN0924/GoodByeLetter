package com.iSpanProject.GoodByeletter.model.YiJie;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//用來做映射
@Entity
@Table(name = "member")
public class YJCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // JPA 實體類別在新增紀錄時自動產生主鍵值
	@Column(name = "memberId")
	private Integer id;
	
	@Column(name = "account")
	private String acc;

	@Column(name = "password")
	private String pass;
	
	@Column(name = "FK_Plevel")
	private Integer level;
	
	@Column(name = "registerTime")
	private Date rtime;
	
	public YJCustomer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}


//	public YJCustomer(String acc, String pass, int level, LocalDateTime rtime) {
//        this.acc = acc;
//        this.pass = pass;
//        this.level = level;
//        this.rtime = rtime;
//    }

}

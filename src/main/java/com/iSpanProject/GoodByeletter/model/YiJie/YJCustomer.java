package com.iSpanProject.GoodByeletter.model.YiJie;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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

import com.fasterxml.jackson.annotation.JsonFormat;

//用來做映射
@Entity
@Table(name = "member")
public class YJCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // JPA 實體類別在新增紀錄時自動產生主鍵值
	@Column(name = "memberId")
	private Integer id;
	
	@Column(name = "account",columnDefinition = "nvarchar(50)", nullable = false)
	private String acc;

	@Column(name = "password",columnDefinition = "nvarchar(50)", nullable = false)
	private String pass;
	
	@ManyToOne(cascade= {CascadeType.PERSIST })
	@JoinColumn(name="FK_Plevel", foreignKey=@ForeignKey(name = "FK_member_level"))
	private YJLevel fk_level;
	
	@Column(name = "registerTime")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date rtime;
	
	@PrePersist
	public void onCreate() {
		if(rtime == null) {
			rtime = new Date();
		}
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

	public YJLevel getLevel() {
		return fk_level;
	}

	public void setLevel(YJLevel YJlevel) {
		fk_level = YJlevel;
	}

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
	
	public YJCustomer() {
	}

}

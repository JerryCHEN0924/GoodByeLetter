package com.iSpanProject.GoodByeletter.model.Ryu;

import java.util.Date;

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
import javax.persistence.Transient;

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
	
	
	@Transient
	private Integer pId;
	
	
	
	@JsonBackReference // 不要進行序列化，由另外一邊進行
	@JoinColumn(name="FK_Plevel")
	@ManyToOne // cascade=CascadeType.ALL => 這邊設定這個會把整個 member 刪除掉 ... 乾 ...
	private LevelByRyu levelByRyu;


	public MemberByRyu() {
		super();
	}
	
	
	
	





	public MemberByRyu(Integer memberId, String account, String password, Date registerTime, Integer pId,
			LevelByRyu levelByRyu) {
		super();
		this.memberId = memberId;
		this.account = account;
		this.password = password;
		this.registerTime = registerTime;
		this.pId = pId;
		this.levelByRyu = levelByRyu;
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






	public LevelByRyu getLevelByRyu() {
		return levelByRyu;
	}






	public void setLevelByRyu(LevelByRyu levelByRyu) {
		this.levelByRyu = levelByRyu;
	}







	public Integer getpId() {
		return pId;
	}




	public void setpId(Integer pId) {
		this.pId = pId;
	}


	
	
	
	
	
	
	


}

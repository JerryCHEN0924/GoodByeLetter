package com.iSpanProject.GoodByeletter.model.Ryu;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="memberDetailByRyu")
// @PropertySources({@PropertySource("classpath:ValidationMessages_en.properties"),@PropertySource("classpath:ValidationMessages_zh_TW.properties")})
@PropertySource("classpath:ValidationMessages_zh_TW.properties")
public class MemberDetailByRyu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberDetailId")
	private Integer memberDetailId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birthday")
	private java.sql.Date birthday;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="registerTime")
	private Date registerTime;
	
	
	
	
	
	
	@PrePersist
	public void onCreate() {
		if(registerTime == null) {
			registerTime = new Date();
		}
	}
	
	
	
	
	
	

	public MemberDetailByRyu() {
		
	}

	
	
	
	
	
	
	

	public MemberDetailByRyu(Integer memberDetailId, String name, String gender, java.sql.Date birthday, String email,
			String address, Date registerTime) {
		super();
		this.memberDetailId = memberDetailId;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.registerTime = registerTime;
	}














	public Integer getMemberDetailId() {
		return memberDetailId;
	}


	public void setMemberDetailId(Integer memberDetailId) {
		this.memberDetailId = memberDetailId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public java.sql.Date getBirthday() {
		return birthday;
	}


	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getRegisterTime() {
		return registerTime;
	}


	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	
	
	
	

}

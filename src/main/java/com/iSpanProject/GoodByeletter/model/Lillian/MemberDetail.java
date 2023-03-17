package com.iSpanProject.GoodByeletter.model.Lillian;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "memberDetail")
public class MemberDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Column(name = "County",columnDefinition = "nvarchar(50)", nullable = false)
	private String County;

//	@Column(name = "Email")
	@Column(unique = true)
	private String Email;

//	@Column(name = "address",columnDefinition = "nvarchar(50)", nullable = false)
	private String address;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birthday")
	private Date birthday;
	
//	@Column(name = "gender",columnDefinition = "nvarchar(50)", nullable = false)
	private String gender;
	
//	@Column(name = "name",columnDefinition = "nvarchar(50)", nullable = false)
	private String name;

	@ManyToOne(cascade= {CascadeType.PERSIST })
	@JoinColumn(name="FK_Plevel", foreignKey=@ForeignKey(name = "FK_memberDetail_level"))
	private Level FK_Plevel;

	@OneToOne(cascade= {CascadeType.PERSIST })
	@JoinColumn(name = "FK_memberId", foreignKey=@ForeignKey(name = "FK_memberDetail_member"))
	private Register FK_memberId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="verifyTime")
	private Date verifyTimeEmail;
	
	private String token;
	
//	####################### Ryuz divider start #######################
	
	// 暫時性欄位，後台建置MemberDetail使用，不會增加表格欄位
	// 於此類別中，有增加對應之getter/setter
	// 勿刪、勿刪、勿刪
	@Transient
	private String account;
	
//	======================= Block =======================
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
//	####################### Ryuz divider end #######################
	
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	public Register getFK_memberId() {
		return FK_memberId;
	}


	public void setFK_memberId(Register fK_memberId) {
		FK_memberId = fK_memberId;
	}

	public Level getFK_Plevel() {
		return FK_Plevel;
	}


	public void setFK_Plevel(Level fK_Plevel) {
		FK_Plevel = fK_Plevel;
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


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getCounty() {
		return County;
	}


	public void setCounty(String county) {
		County = county;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getVerifyTimeEmail() {
		return verifyTimeEmail;
	}

	public void setVerifyTimeEmail(Date verifyTimeEmail) {
		this.verifyTimeEmail = verifyTimeEmail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public MemberDetail() {

	}
//判斷email是否存在
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}

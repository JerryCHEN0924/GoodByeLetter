package com.iSpanProject.GoodByeletter.model.YiJie;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "memberDetail")
public class YJCustomerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade= {CascadeType.PERSIST })
	@JoinColumn(name="FK_memberId", foreignKey=@ForeignKey(name = "FK_memberDetail_member"))
	private YJCustomer FK_memberId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST })
	@JoinColumn(name="FK_Plevel", foreignKey=@ForeignKey(name = "FK_memberDetail_level"))
	private YJLevel plevel;
	private String name;
	private String gender;
	private Date birthday;
	private String Email;
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public YJCustomer getFK_memberId() {
		return FK_memberId;
	}
	public void setFK_memberId(YJCustomer fK_memberId) {
		FK_memberId = fK_memberId;
	}
	public YJLevel getFK_Plevel() {
		return plevel;
	}
	public void setFK_Plevel(YJLevel plevel) {
		this.plevel = plevel;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public YJCustomerDetail() {
		
	}
	
}

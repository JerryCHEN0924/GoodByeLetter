package com.iSpanProject.GoodByeletter.model.YiJie;

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
	
	@Column(name = "companyName")
	private String name;
	@Column(name = "companyType")
	private String type;
	@Column(name = "Email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "picPath")
	private String picPath;
	@Column(name = "picValue")
	private String picValue;
	
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

	public YJLevel getPlevel() {
		return plevel;
	}

	public void setPlevel(YJLevel plevel) {
		this.plevel = plevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicValue() {
		return picValue;
	}

	public void setPicValue(String picValue) {
		this.picValue = picValue;
	}

	public YJCustomerDetail() {
		
	}
	
}

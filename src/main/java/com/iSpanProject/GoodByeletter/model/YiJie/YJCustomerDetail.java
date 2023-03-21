package com.iSpanProject.GoodByeletter.model.YiJie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Entity
@Table(name = "companydetail")
public class YJCustomerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "FK_memberId", foreignKey=@ForeignKey(name = "FK_companydetail_member"))
	private Register FK_memberId;

	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "FK_Plevel", foreignKey = @ForeignKey(name = "FK_companydetail_level"))
	private Level plevel;

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
	

	//@JsonManagedReference //主要控管序列化方(由此方控管序列化註釋)
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "picture", orphanRemoval = true), mappedBy = "picture"
	//0317
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "picture")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="fk_companydetail_id")//單向一對多的JoinColumn是寫在一方，雙向控管時寫在多方
	private List<Picture> pictures = new ArrayList<>();
	
	public List<Picture> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

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

	public Level getPlevel() {
		return plevel;
	}

	public void setPlevel(Level plevel) {
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

	public YJCustomerDetail() {}

}

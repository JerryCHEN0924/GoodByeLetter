package com.iSpanProject.GoodByeletter.model.Ryu;

import java.sql.Blob;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;



@Entity
@Table(name = "VendorDetails",
	   uniqueConstraints = { @UniqueConstraint(name="UNIC_VendorDetails_CompanyName", columnNames = "companyName") })
public class VendorDetails {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vendorDetailsId;
	
	private String companyName;
	
	private String companyType;
	
	private String email;
	
	private String address;
	
	private Blob vendorDetailsImage;
	
	private String fileName;
	
	@Transient
	MultipartFile image;
	
	@Transient
	private String account;
	
	@JsonBackReference // 不要進行序列化，由另外一邊進行，雙向情況才需要使用
//	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true) // 別再玩我了 又往上砍了MEMBER 到底要玩幾次
	@OneToOne
	@JoinColumn(name = "memberId", nullable = false, foreignKey = @ForeignKey(name = "FKC_VendorDetails_Register"))
	private Register register;
	
	
//	@ManyToOne(cascade = { CascadeType.ALL }) // 別再玩我了 又往上砍了LEVEL 到底要玩幾次
	@ManyToOne
	@JoinColumn(name = "levelId", nullable = false, foreignKey = @ForeignKey(name = "FKC_VendorDetails_Level"))
	private Level level;
	
	
	@OneToMany(mappedBy="vendorDetails")
	private Set<VendorPhotos> vendorPhotos = new LinkedHashSet<>();
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="createTime")
	private Date createTime;
	
	
	@PrePersist
	public void onCreate() {
		if(createTime == null) {
			createTime = new Date();
		}
	}
	
	
	@PreUpdate
	public void onUpdate() {
		createTime = new Date();
	}


	public VendorDetails() {
		super();
	}
	




	public VendorDetails(Integer vendorDetailsId, String companyName, String companyType, String email, String address,
			Blob vendorDetailsImage, String fileName, MultipartFile image, String account, Register register,
			Level level, Set<VendorPhotos> vendorPhotos, Date createTime) {
		super();
		this.vendorDetailsId = vendorDetailsId;
		this.companyName = companyName;
		this.companyType = companyType;
		this.email = email;
		this.address = address;
		this.vendorDetailsImage = vendorDetailsImage;
		this.fileName = fileName;
		this.image = image;
		this.account = account;
		this.register = register;
		this.level = level;
		this.vendorPhotos = vendorPhotos;
		this.createTime = createTime;
	}


	public Integer getVendorDetailsId() {
		return vendorDetailsId;
	}


	public void setVendorDetailsId(Integer vendorDetailsId) {
		this.vendorDetailsId = vendorDetailsId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyType() {
		return companyType;
	}


	public void setCompanyType(String companyType) {
		this.companyType = companyType;
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


	public Blob getVendorDetailsImage() {
		return vendorDetailsImage;
	}


	public void setVendorDetailsImage(Blob vendorDetailsImage) {
		this.vendorDetailsImage = vendorDetailsImage;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public Register getRegister() {
		return register;
	}


	public void setRegister(Register register) {
		this.register = register;
	}


	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}


	public Set<VendorPhotos> getVendorPhotos() {
		return vendorPhotos;
	}


	public void setVendorPhotos(Set<VendorPhotos> vendorPhotos) {
		this.vendorPhotos = vendorPhotos;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	
	


	

	
	

}

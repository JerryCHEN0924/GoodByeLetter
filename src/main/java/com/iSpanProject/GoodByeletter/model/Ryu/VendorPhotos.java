package com.iSpanProject.GoodByeletter.model.Ryu;

import java.io.Serializable;
import java.sql.Blob;
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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="VendorPhotos")
public class VendorPhotos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer vendorPhotosId ;
	
	private Blob vendorPhotosImage;
	
	private String fileName;
	
	private String title;
	
	private String description;
	
	private boolean enabled;
	
//	@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="FK_VendorDetails_Id")
	private VendorDetails vendorDetails;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="createTime")
	private Date createTime;
	
	
	@Transient
	MultipartFile image;
	
	
	@Transient
	private String account;


	public VendorPhotos() {
		super();
	}
	
	
	
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

	
	


	public VendorPhotos(Integer vendorPhotosId, Blob vendorPhotosImage, String fileName, String title,
			String description, boolean enabled, VendorDetails vendorDetails, Date createTime, MultipartFile image,
			String account) {
		super();
		this.vendorPhotosId = vendorPhotosId;
		this.vendorPhotosImage = vendorPhotosImage;
		this.fileName = fileName;
		this.title = title;
		this.description = description;
		this.enabled = enabled;
		this.vendorDetails = vendorDetails;
		this.createTime = createTime;
		this.image = image;
		this.account = account;
	}



	public Integer getVendorPhotosId() {
		return vendorPhotosId;
	}



	public void setVendorPhotosId(Integer vendorPhotosId) {
		this.vendorPhotosId = vendorPhotosId;
	}



	public Blob getVendorPhotosImage() {
		return vendorPhotosImage;
	}



	public void setVendorPhotosImage(Blob vendorPhotosImage) {
		this.vendorPhotosImage = vendorPhotosImage;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public VendorDetails getVendorDetails() {
		return vendorDetails;
	}



	public void setVendorDetails(VendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	
	
	
	


	
	
	

}

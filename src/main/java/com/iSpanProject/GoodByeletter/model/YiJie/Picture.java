package com.iSpanProject.GoodByeletter.model.YiJie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="picture")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Lob
	@JsonIgnore
	@Column(name="photo_file")
	private byte[] photoFile;
	
	@Column(name="enable")
	private boolean enable;
	
	///  #### FK ###  //做一個外鍵存companydetail_id
//	@ManyToOne
//	@JoinColumn(name="fk_companydetail_id")
//	private Integer companydetailId;
//	
//	public Integer getCompanydetailId() {
//		return companydetailId;
//	}
//
//	public void setCompanydetailId(Integer companydetailId) {
//		this.companydetailId = companydetailId;
//	}

	//////////////////////////////////////////////////
//	private YJCustomerDetail FK_ComDetailId;
//	
//	public YJCustomerDetail getFK_ComDetailId() {
//		return FK_ComDetailId;
//	}
//
//	public void setFK_ComDetailId(YJCustomerDetail fK_ComDetailId) {
//		FK_ComDetailId = fK_ComDetailId;
//	}

	///  ###########  ///
	public Picture() {}
	
	
	
	
	@ManyToOne
	@JoinColumn(name="fk_companydetail_id")
	private YJCustomerDetail customerDetail;
	
	
	
//	####################### Ryuz divider #######################
//	===================== 後臺管控預留項目 勿刪 勿刪 勿刪 =====================
//	===================== 後臺管控預留項目 勿刪 勿刪 勿刪 =====================
//	===================== 後臺管控預留項目 勿刪 勿刪 勿刪 =====================
	
	
	@Transient
	MultipartFile image;
	
	@Transient
	private String account;
	
	
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

	public YJCustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(YJCustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	
//	===================== 後臺管控預留項目 勿刪 勿刪 勿刪 =====================
//	===================== 後臺管控預留項目 勿刪 勿刪 勿刪 =====================
//	===================== 後臺管控預留項目 勿刪 勿刪 勿刪 =====================
//	####################### i am divider #######################
	
	
	
	
	
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(byte[] photoFile) {
		this.photoFile = photoFile;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	//////////////////////////////////////////////
	//雙方控管才需要
//	@JsonBackReference //不要做控管註釋
//	@JoinColumn(name="fk_companydetail_id")
//	@ManyToOne
//	private YJCustomerDetail cusdetail;
//
//	public YJCustomerDetail getCusdetail() {
//		return cusdetail;
//	}
//
//	public void setCusdetail(YJCustomerDetail cusdetail) {
//		this.cusdetail = cusdetail;
//	}
	/////////////////////////////////////////////
}

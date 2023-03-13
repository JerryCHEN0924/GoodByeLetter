package com.iSpanProject.GoodByeletter.model.YiJie;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	///  #### FK ###  ///0311做一個外鍵存companydetail_id	
//	@OneToOne(cascade= {CascadeType.PERSIST })
//	@JoinColumn(name="FK_ComDetailId",foreignKey=@ForeignKey(name="fk_companydetail_id"))
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

package com.iSpanProject.GoodByeletter.model.YiJie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	
	public Picture() {}
	
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
	
	
	
	
}

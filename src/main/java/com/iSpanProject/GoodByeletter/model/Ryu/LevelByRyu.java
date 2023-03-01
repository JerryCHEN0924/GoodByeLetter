package com.iSpanProject.GoodByeletter.model.Ryu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="levelByRyu")
public class LevelByRyu {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pLevel")
	private Integer pLevel;
	
	
	@Column(name = "levelName")
	private String levelName;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name="createTime")
	private Date createTime;
	
	
	@JsonManagedReference // 主要序列化方 雙向情況才需要使用
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "levelByRyu", orphanRemoval = true) // 設定這個 orphanRemoval = true 不然會把整個 member 對應的刪光 ......
	private List<MemberByRyu> member = new ArrayList<>();


	public LevelByRyu() {
		super();
	}
	
	
	
	
	






	public LevelByRyu(Integer pLevel, String levelName, Date createTime, List<MemberByRyu> member) {
		super();
		this.pLevel = pLevel;
		this.levelName = levelName;
		this.createTime = createTime;
		this.member = member;
	}







	@PrePersist
	public void onCreate() {
		if(createTime == null) {
			createTime = new Date();
		}
	}







	public Integer getpLevel() {
		return pLevel;
	}


	public void setpLevel(Integer pLevel) {
		this.pLevel = pLevel;
	}


	public String getLevelName() {
		return levelName;
	}


	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	
	
	public Date getCreateTime() {
		return createTime;
	}




	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	


	public List<MemberByRyu> getMember() {
		return member;
	}


	public void setMember(List<MemberByRyu> member) {
		this.member = member;
	}









	
	
	
	
	


}

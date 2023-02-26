package com.iSpanProject.GoodByeletter.model.Ryu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	
	@JsonManagedReference // 主要序列化方 雙向情況才需要使用
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "levelByRyu", orphanRemoval = true)
	private List<MemberByRyu> member = new ArrayList<>();


	public LevelByRyu() {
		super();
	}
	
	
	
	
	
	


	public LevelByRyu(Integer pLevel, String levelName, List<MemberByRyu> member) {
		super();
		this.pLevel = pLevel;
		this.levelName = levelName;
		this.member = member;
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


	public List<MemberByRyu> getMember() {
		return member;
	}


	public void setMember(List<MemberByRyu> member) {
		this.member = member;
	}
	
	
	
	
	


}

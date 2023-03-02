package com.iSpanProject.GoodByeletter.model.YiJie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class YJLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Plevel")
	private Integer Plevel;

	//@Column(name = "levelName", columnDefinition = "[nvarchar](20)", nullable = true)
	@Column(name = "levelName")
	private String levelName;
	
	public Integer getPlevel() {
		return Plevel;
	}

	public void setPlevel(Integer plevel) {
		this.Plevel = plevel;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public YJLevel() {
	}
	
}

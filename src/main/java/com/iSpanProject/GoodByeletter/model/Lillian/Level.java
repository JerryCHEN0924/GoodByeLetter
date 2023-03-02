package com.iSpanProject.GoodByeletter.model.Lillian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer plevel;

	//@Column(name = "levelName", columnDefinition = "[nvarchar](20)", nullable = true)
	private String levelName;

	public Integer getPlevel() {
		return plevel;
	}

	public void setPlevel(Integer plevel) {
		this.plevel = plevel;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Level(Integer plevel, String levelName) {
		super();
		this.plevel = plevel;
		this.levelName = levelName;
	}

	public Level() {
		super();
	}


}

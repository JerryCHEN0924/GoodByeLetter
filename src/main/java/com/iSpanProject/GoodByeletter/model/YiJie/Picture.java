package com.iSpanProject.GoodByeletter.model.YiJie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
	@JsonBackReference //不要做控管註釋
	@JoinColumn(name="fk_companydetail_id")
	@ManyToOne
	private Picture picture;
	
	
	
}

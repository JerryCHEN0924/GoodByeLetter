package com.iSpanProject.GoodByeletter.model.Lillian;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "memberDetail")
public class MemberDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;

	@OneToOne
	@JoinColumn(name = "Plevel")
	private Level Plevel;

//	@Column(name = "Plevel", nullable = true)
//	private Integer Plevel;

	@Column(name = "name", columnDefinition = "[nvarchar](50)", nullable = true)
	private String name;

	@Column(name = "gender", columnDefinition = "[nvarchar](50)", nullable = true)
	private String gender;

	@Column(name = "birthday", columnDefinition = "[nvarchar](50)", nullable = true)
	private String birthday;

	@Column(name = "Email", columnDefinition = "[nvarchar](50)", nullable = true)
	private String Email;

	private String address;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Level getPlevel() {
		return Plevel;
	}

	public void setPlevel(Level plevel) {
		Plevel = plevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MemberDetail() {
//		super();
	}

}

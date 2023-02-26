package com.iSpanProject.GoodByeletter.model.Jerry;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MemberBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private String account;
	private String password;
	private Integer FK_Plevel;
	private Date registerTime;
	
	private Set<LastNoteBean> lastnote; //= ## ;

	// 一對多
	public MemberBean(Integer memberId, String account, String password, Integer fK_Plevel, Date registerTime) {
		super();
		this.memberId = memberId;
		this.account = account;
		this.password = password;
		FK_Plevel = fK_Plevel;
		this.registerTime = registerTime;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFK_Plevel() {
		return FK_Plevel;
	}

	public void setFK_Plevel(Integer fK_Plevel) {
		FK_Plevel = fK_Plevel;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}

package com.iSpanProject.GoodByeletter.model.Lillian;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="member")
public class Register {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "memberId")
		private Integer memberId;
		
		@Column(name = "account",columnDefinition = "nvarchar(50)", nullable = false)
		private String account;
		
		
		@Column(name = "password",columnDefinition = "nvarchar(50)", nullable = false)
		private String password;
		
		@ManyToOne(cascade= {CascadeType.PERSIST })
		@JoinColumn(name="FK_Plevel", foreignKey=@ForeignKey(name = "FK_member_level"))
		private Level FK_Plevel;
		
		@Column(name = "registerTime")
		@Temporal(TemporalType.TIMESTAMP)
		@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
		private Date registerTime;
		
		@PrePersist
		public void onCreate() {
			if(registerTime ==null) {
				registerTime = new Date();
			}
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




		public Level getFK_Plevel() {
			return FK_Plevel;
		}




		public void setFK_Plevel(Level fK_Plevel) {
			FK_Plevel = fK_Plevel;
		}




		public Date getRegisterTime() {
			return registerTime;
		}




		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
		}




		public Register() {
		}

}

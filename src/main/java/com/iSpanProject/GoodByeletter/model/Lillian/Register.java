package com.iSpanProject.GoodByeletter.model.Lillian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.springframework.lang.Nullable;

@Entity
@Table(name="member")
public class Register {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Nullable
		private Integer memberId;
		
//		@Nationalized
		@Column(columnDefinition = "nvarchar(50)", nullable = false)
		private String account;
		
		
		@Column(columnDefinition = "nvarchar(50)", nullable = false)
		private String password;
		
		private 
		
		
		
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



		public Integer getMemberId() {
			return memberId;
		}



		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}



		public Register() {
		}

}

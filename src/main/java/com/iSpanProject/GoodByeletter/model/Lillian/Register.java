package com.iSpanProject.GoodByeletter.model.Lillian;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer memberId;
		
		
		
		public Integer getMemberId() {
			return memberId;
		}



		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}



		public Register() {
		}

}

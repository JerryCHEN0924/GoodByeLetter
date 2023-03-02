package com.iSpanProject.GoodByeletter.model.Tina;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="member")
public class Register01 {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@Column(name = "memberId")
		private Integer memberId;
		
		//@Column(name = "account",columnDefinition = "nvarchar(50)", nullable = false)
		private String account;
		
		
		//@Column(name = "password",columnDefinition = "nvarchar(50)", nullable = false)
		private String password;
		
//		@ManyToOne(cascade= {CascadeType.PERSIST })
//		@JoinColumn(name="FK_Plevel", foreignKey=@ForeignKey(name = "FK_member_level"))
//		private Level FK_Plevel;
		
		//@Column(name = "registerTime")
		@Temporal(TemporalType.TIMESTAMP)
		@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
		private Date registerTime;
		
		
		//連到Board
		@OneToMany(mappedBy = "FK_memberId", cascade = CascadeType.ALL)
		Set<Board> boards = new HashSet<>();
		
		//連到Commet
		@OneToMany(mappedBy = "FK_memberId", cascade = CascadeType.ALL)
		Set<Comment> comments = new HashSet<>();

		public Register01() {
			super();
		}

		public Register01(Integer memberId, String account, String password, Date registerTime, Set<Board> boards,
				Set<Comment> comments) {
			super();
			this.memberId = memberId;
			this.account = account;
			this.password = password;
			this.registerTime = registerTime;
			this.boards = boards;
			this.comments = comments;
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

		public Date getRegisterTime() {
			return registerTime;
		}

		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
		}

		public Set<Board> getBoards() {
			return boards;
		}

		public void setBoards(Set<Board> boards) {
			this.boards = boards;
		}

		public Set<Comment> getComments() {
			return comments;
		}

		public void setComments(Set<Comment> comments) {
			this.comments = comments;
		}

		
		
}

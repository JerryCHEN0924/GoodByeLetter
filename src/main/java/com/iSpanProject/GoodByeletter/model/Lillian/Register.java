package com.iSpanProject.GoodByeletter.model.Lillian;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;

@Entity
@Table(name = "member")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "memberId")
	private Integer memberId;

	// @Column(name = "account",columnDefinition = "nvarchar(50)", nullable = false)
	private String account;

	// @Column(name = "password",columnDefinition = "nvarchar(50)", nullable =
	// false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "FK_Plevel", foreignKey=@ForeignKey(name = "FK_member_level"))
	private Level FK_Plevel;

	// @Column(name = "registerTime")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date registerTime;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "FK_memberId", orphanRemoval = true)
	private List<LastNote> lastnote = new ArrayList<>();

	// 阿戴:連到Board
	@OneToMany(mappedBy = "FK_memberId", cascade = CascadeType.ALL)
	Set<Board> boards = new HashSet<>();

	// 阿戴:連到Commet
	@OneToMany(mappedBy = "FK_memberId", cascade = CascadeType.ALL)
	Set<Comment> comments = new HashSet<>();

	@PrePersist
	public void onCreate() {
		if (registerTime == null) {
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

	public List<LastNote> getLastnote() {
		return lastnote;
	}

	public void setLastnote(List<LastNote> lastnote) {
		this.lastnote = lastnote;
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

	public Register(Integer memberId, String account, String password, Level fK_Plevel, Date registerTime,
			List<LastNote> lastnote, Set<Board> boards, Set<Comment> comments) {
		super();
		this.memberId = memberId;
		this.account = account;
		this.password = password;
		FK_Plevel = fK_Plevel;
		this.registerTime = registerTime;
		this.lastnote = lastnote;
		this.boards = boards;
		this.comments = comments;
	}

	public Register() {
		super();
	}

}

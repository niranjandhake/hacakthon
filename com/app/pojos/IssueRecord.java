package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="issue_record")
public class IssueRecord 
{
	private Integer id;
	private Date issueDate,dueDate,returnDate;
	private double fine;
	private Copies copyid;
	private Users userid;
	
	public IssueRecord() {
		// TODO Auto-generated constructor stub
	}

	public IssueRecord(Date issueDate, Date dueDate, Date returnDate, double fine) {
		super();
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issue_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	@ManyToOne
	@JoinColumn(name = "copy_id")
	public Copies getCopyid() {
		return copyid;
	}

	public void setCopyid(Copies copyid) {
		this.copyid = copyid;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}
	
	
}

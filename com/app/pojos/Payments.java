package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Payments 
{
	private Integer id;
	private Users user;
	private double amount;
	private Date txTime,nextDueDate;
	private PaymentType type;
	
	public Payments() {
		// TODO Auto-generated constructor stub
	}

	public Payments(Users user, double amount, Date txTime, Date nextDueDate, PaymentType type) {
		super();
		this.user = user;
		this.amount = amount;
		this.txTime = txTime;
		this.nextDueDate = nextDueDate;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "tx_time")
	public Date getTxTime() {
		return txTime;
	}

	public void setTxTime(Date txTime) {
		this.txTime = txTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "nextdue_date")
	public Date getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}
	
	
}

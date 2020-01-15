package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Users 
{
	private Integer id;
	private String name,email,password,phone;
	private UserRole role;
	private List<Payments> paylist = new ArrayList<>();
	private List<IssueRecord> issuelist= new ArrayList<>();
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String name, String email, String password, String phone, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20,nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true)
	public List<Payments> getPaylist() {
		return paylist;
	}

	public void setPaylist(List<Payments> paylist) {
		this.paylist = paylist;
	}

	public void makePayment(Payments p)
	{
		paylist.add(p);
		p.setUser(this);
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userid",orphanRemoval = true)
	public List<IssueRecord> getIssuelist() {
		return issuelist;
	}

	public void setIssuelist(List<IssueRecord> issuelist) {
		this.issuelist = issuelist;
	}
	
	public void addIssueRecord(IssueRecord i)
	{
		issuelist.add(i);
		i.setUserid(this);
	}
	
	public void removeIssueRecord(IssueRecord i)
	{
		issuelist.remove(i);
		i.setUserid(null);
	}
}

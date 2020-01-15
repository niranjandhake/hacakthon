package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Copies 
{
	private Integer id;
	private Books book;
	private Integer rack;
	private CopiesStatus status;
	private List<IssueRecord> copyList = new ArrayList<>();
	
	public Copies() {
		// TODO Auto-generated constructor stub
	}

	public Copies(Books book, Integer rack, CopiesStatus status) {
		super();
		this.book = book;
		this.rack = rack;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "copy_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="book_id")
	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Integer getRack() {
		return rack;
	}

	public void setRack(Integer rack) {
		this.rack = rack;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public CopiesStatus getStatus() {
		return status;
	}

	public void setStatus(CopiesStatus status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "copyid",orphanRemoval = true)
	public List<IssueRecord> getCopyList() {
		return copyList;
	}

	public void setCopyList(List<IssueRecord> copyList) {
		this.copyList = copyList;
	}
	
	public void addIssueRecord(IssueRecord i)
	{
		copyList.add(i);
		i.setCopyid(this);
	}
	public void removeIssueRecord(IssueRecord i)
	{
		copyList.remove(i);
		i.setUserid(null);
	}
}

package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Books 
{
	private Integer id;
	private String name,author,subject;
	private double price;
	private String isbn;
	private List<Copies> copies = new ArrayList<>();
	
	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(String name, String author, String subject, double price, String isbn) {
		super();
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
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

	@Column(length = 20)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(length = 20)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(length = 20)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "book",orphanRemoval = true)
	public List<Copies> getCopies() {
		return copies;
	}

	public void setCopies(List<Copies> copies) {
		this.copies = copies;
	}
	
	public void addCopy(Copies c)
	{
		copies.add(c);
		c.setBook(this);
	}
	
	public void removeCopy(Copies c)
	{
		copies.remove(c);
		c.setBook(null);
	}
}

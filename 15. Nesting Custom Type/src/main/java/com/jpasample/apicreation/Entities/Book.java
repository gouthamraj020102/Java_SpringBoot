package com.jpasample.apicreation.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Book_id")
	private int id;

	@Column(name = "Book_name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Author author;

	public Book() {
		super();
	}

	public Book(int id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}

/*
 * {
 * "id" : 8,
 * "name" : "Good_Morning",
 * "author" : {
 * "authorId" : 78,
 * "firstName": "Bad",
 * "lastName" : "Morning"
 * }
 * }
 */
// Note: If you use put endpoint, make sure you should enter the correct id
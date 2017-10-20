package com.example.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity model for "Author" table
 * 
 * @author maximusfk
 *
 */
@Entity
@Table(name = "author")
public class Author {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	/**
	 * Default constructor for HTTP request
	 */
	public Author() {}

	/**
	 * Creates a new Author object with specific id, name and email
	 * @param id Author ID
	 * @param name Author name
	 * @param email Author email
	 */
	public Author(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
		
	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
}

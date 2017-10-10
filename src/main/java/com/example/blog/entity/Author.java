package com.example.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class provides database table "Author"
 * @author maximusfk
 *
 */
@Entity
@Table(name = "Author")
public class Author {
	
	@Id @GeneratedValue
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	/**
	 * Default constructor for HTTP request
	 */
	public Author() {}

	/**
	 * Creates a new Author object with specific id, name and email
	 * @param id
	 * @param name
	 * @param email
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
}

package com.example.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class provides database table
 * @author maximusfk
 *
 */
@Entity
@Table(name = "Author")
public class Author {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	public Author() {}

	public Author(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	/**
	 * Return id for this object
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set id for this object
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Return author name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set author name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return author email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set author email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}

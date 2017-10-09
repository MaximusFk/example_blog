package com.example.blog.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class provides database table "Article"
 * @author maximusfk
 *
 */
@Entity
@Table(name = "Article")
public class Article {

	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	public Article() {}

	public Article(Integer id, Author author, String title, String label, String text, Date createdDate) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.label = label;
		this.text = text;
		this.createdDate = createdDate;
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
	 * Return author for this article
	 * @return author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Set the author for this article
	 * @param author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * Return article title 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set article title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Return article label
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Set article label
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Return article text
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Set article text
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Return article created date
	 * @return date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Set article created date
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}

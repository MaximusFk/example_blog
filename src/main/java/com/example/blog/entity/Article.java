package com.example.blog.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
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
	
	/**
	 * Default constructor for HTTP request
	 */
	public Article() {}

	/**
	 * Creates a new Article object with specific id, author, title, label, text and date of creation
	 * @param id
	 * @param author
	 * @param title
	 * @param label
	 * @param text
	 * @param createdDate
	 */
	public Article(Integer id, Author author, String title, String label, String text, Date createdDate) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.label = label;
		this.text = text;
		this.createdDate = createdDate;
	}

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Author getAuthor() {
		return author;
	}

	
	public void setAuthor(Author author) {
		this.author = author;
	}

	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getLabel() {
		return label;
	}

	
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	public String getText() {
		return this.text;
	}
	
	
	public void setText(String text) {
		this.text = text;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}

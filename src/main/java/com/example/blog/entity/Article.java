package com.example.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity model for "Article" table
 * 
 * @author maximusfk
 *
 */
@Entity
@Table(name = "article")
public class Article {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@Column
	private String title;
	
	@Column
	private String label;
	
	@Column
	private String text;
	
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@Column(name = "modified_date")
	private Timestamp modifiedDate;
	
	/**
	 * Default constructor for HTTP request
	 */
	public Article() {}

	/**
	 * Creates a new Article object with specific id, author, title, label and text of creation
	 * @param id
	 * @param author
	 * @param title
	 * @param label
	 * @param text
	 */
	public Article(Integer id, Author author, String title, String label, String text) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.label = label;
		this.text = text;
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
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

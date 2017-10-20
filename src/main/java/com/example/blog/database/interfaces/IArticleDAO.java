package com.example.blog.database.interfaces;

import java.util.List;

import com.example.blog.entity.Article;

/**
 * Interface for working with article table on the database
 * 
 * @author maximusfk
 *
 */
public interface IArticleDAO {
	/**
	 * Return all articles for represent table of database
	 * 
	 * @param startRow Initial search position
	 * @param maxResults Maximum positions
	 * @return List all articles in database
	 */
	List<Article> getAll(int startRow, int maxResults);
	
	/**
	 * Search Article by ID
	 * 
	 * @param id Article ID
	 * @return Article object if founded, else null
	 */
	Article getById(Integer id);
	
	/**
	 * Create new instance of Article in database
	 * 
	 * @param Article
	 * @return id of created instance
	 */
	Integer create(Article Article);
	
	/**
	 * Update information of an exiting Article
	 * 
	 * @param Article
	 * @return id of updated instance, null if does not exist in database
	 */
	Integer update(Article Article);
	
	/**
	 * Remove exiting Article from database
	 * 
	 * @param id Article ID
	 * @return true if Article deleted else false
	 */
	boolean delete(Integer id);
}

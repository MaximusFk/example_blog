package com.example.blog.database;

import java.util.List;

import com.example.blog.entity.Article;

/**
 * Base interface for implementation access to database with Article data model
 * @author maximusfk
 *
 */
public interface IArticleDAOService {
	/**
	 * This method return all articles for represent table of database
	 * @return List all articles in database
	 */
	List<Article> getAll();
	
	/**
	 * This method looking for Article in database by ID
	 * @param id Article ID
	 * @return Article object if founded, else null
	 */
	Article getById(Integer id);
	
	/**
	 * This method create new instance of Article in database
	 * @param Article
	 * @return id of created instance
	 */
	Integer create(Article Article);
	
	/**
	 * This method update information of an exiting Article
	 * @param Article
	 * @return id of updated instance, null if does not exist in database
	 */
	Integer update(Article Article);
	
	/**
	 * This method remove exiting Article from database
	 * @param id
	 * @return true if Article deleted else false
	 */
	Boolean delete(Integer id);
}

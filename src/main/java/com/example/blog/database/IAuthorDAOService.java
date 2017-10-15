package com.example.blog.database;

import java.util.List;

import com.example.blog.entity.Author;

/**
 * Base interface for implementation access to database with Author data model
 * @author maximusfk
 *
 */
public interface IAuthorDAOService {
	/**
	 * This method return all authors for represent table of database
	 * @return List all authors in database
	 */
	List<Author> getAll();
	
	/**
	 * This method looking for Author in database by ID
	 * @param id Author ID
	 * @return Author object if founded, else null
	 */
	Author getById(Integer id);
	
	/**
	 * This method create new instance of Author in database
	 * @param Author
	 * @return id of created instance
	 */
	Integer create(Author Author);
	
	/**
	 * This method update information of an exiting Author
	 * @param Author
	 * @return id of updated instance, null if does not exist in database
	 */
	Integer update(Author Author);
	
	/**
	 * This method remove exiting Author from database
	 * @param id
	 * @return true if Author deleted else false
	 */
	Boolean delete(Integer id);
}

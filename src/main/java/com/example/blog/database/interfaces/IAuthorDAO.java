package com.example.blog.database.interfaces;

import java.util.List;

import com.example.blog.entity.Author;

/**
 * Interface for working with author table on the database
 * 
 * @author maximusfk
 *
 */
public interface IAuthorDAO {
	/**
	 * This method return all authors for represent table of database
	 * 
	 * @param startRow Initial search position
	 * @param maxResults Maximum positions
	 * @return List all authors in database
	 */
	List<Author> getAll(int startRow, int maxResults);
	
	/**
	 * This method looking for Author in database by ID
	 * 
	 * @param id Author ID
	 * @return Author object if founded, else null
	 */
	Author getById(Integer id);
	
	/**
	 * This method create new instance of Author in database
	 * 
	 * @param Author
	 * @return id of created instance
	 */
	Integer create(Author Author);
	
	/**
	 * This method update information of an exiting Author
	 * 
	 * @param Author
	 * @return id of updated instance, null if does not exist in database
	 */
	Integer update(Author Author);
	
	/**
	 * This method remove exiting Author from database
	 * 
	 * @param id
	 * @return true if Author deleted else false
	 */
	boolean delete(Integer id);
}

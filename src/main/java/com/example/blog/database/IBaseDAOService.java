package com.example.blog.database;

import java.util.List;

public interface IBaseDAOService <Entity> {
	
	
	/**
	 * This method return all entities for represent table of database
	 * @return List all entities in database
	 */
	List<Entity> selectAll();
	
	/**
	 * This method looking for entity in database by ID
	 * @param id Entity ID
	 * @return Entity object if founded, else null
	 */
	Entity select(Integer id);
	
	/**
	 * This method create new instance of Entity in database
	 * @param entity
	 * @return id of created instance
	 */
	Integer create(Entity entity);
	
	/**
	 * This method update information of an exiting Entity
	 * @param entity
	 * @return id of updated instance, null if does not exist in database
	 */
	Integer update(Entity entity);
	
	/**
	 * This method remove exiting Entity from database
	 * @param id
	 * @return true if entity deleted else false
	 */
	Boolean delete(Integer id);
	
}

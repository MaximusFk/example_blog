package com.example.blog.database;

import java.util.List;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.example.blog.entity.Author;

/**
 * Base DAO implementation for Author data model using Hibernate
 * @author maximusfk
 *
 */
@Repository
@ComponentScan
@Transactional
public class AuthorHibernateDAOService implements IBaseDAOService<Author> {
	
	private static Logger LOGGER = Logger.getLogger(AuthorHibernateDAOService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method return table name from @Table annotation
	 * @return table name
	 */
	private static String getTableName() {
		Table table = Author.class.getAnnotation(Table.class);
		return table.name();
	}

	@Override
	public List<Author> selectAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String tableName = getTableName();
			List<Author> result = session.createQuery("FROM " + tableName).list();
			return result;
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Author select(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Author author = session.get(Author.class, id);
			return author;
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer create(Author author) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(author);
			return id;
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer update(Author author) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(author);
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return author.getId();
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Author author = session.get(Author.class, id);
			if(author != null) {
				session.delete(author);
				session.flush();
				return true;
			}
			else {
				return false;
			}
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}

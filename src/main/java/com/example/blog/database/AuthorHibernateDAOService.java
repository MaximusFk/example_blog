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
 * IAuthorDAOService implementation for Author data model using Hibernate
 * @author maximusfk
 *
 */
@Repository
@ComponentScan
@Transactional
public class AuthorHibernateDAOService implements IAuthorDAOService {
	
	private static final Logger logger = Logger.getLogger(AuthorHibernateDAOService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private static String getTableName() {
		Table table = Author.class.getAnnotation(Table.class);
		return table.name();
	}

	/* 
	 * @see com.example.blog.database.IAuthorDAOService#getAll()
	 */
	@Override
	public List<Author> getAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String tableName = getTableName();
			List<Author> result = session.createQuery("FROM " + tableName).list();
			return result;
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/* 
	 * @see com.example.blog.database.IAuthorDAOService#getById(java.lang.Integer)
	 */
	@Override
	public Author getById(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Author author = session.get(Author.class, id);
			return author;
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/* 
	 * @see com.example.blog.database.IAuthorDAOService#create(com.example.blog.entity.Author)
	 */
	@Override
	public Integer create(Author author) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(author);
			return id;
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/* 
	 * @see com.example.blog.database.IAuthorDAOService#update(com.example.blog.entity.Author)
	 */
	@Override
	public Integer update(Author author) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(author);
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return author.getId();
	}

	/* 
	 * @see com.example.blog.database.IAuthorDAOService#delete(java.lang.Integer)
	 */
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
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}

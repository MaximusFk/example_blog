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

import com.example.blog.database.interfaces.IAuthorDAO;
import com.example.blog.entity.Author;

/**
 * IAuthorDAOService implementation for Author data model using Hibernate
 * 
 * @author maximusfk
 *
 */
@Repository
@Transactional
public class AuthorDAO implements IAuthorDAO {
	
	private static final Logger logger = Logger.getLogger(AuthorDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Author> getAll(int startRow, int maxResults) {
		try {
			Session session = sessionFactory.getCurrentSession();
			List<Author> result = session.createCriteria(Author.class)
										.setFirstResult(startRow)
										.setMaxResults(maxResults)
										.list();
			return result;
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Author getById(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Author author = session.get(Author.class, id);
			return author;
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer create(Author author) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(author);
			return id;
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer update(Author author) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(author);
			return author.getId();
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
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
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}

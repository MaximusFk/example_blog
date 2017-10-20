package com.example.blog.database;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blog.database.interfaces.IArticleDAO;
import com.example.blog.entity.Article;

/**
 * IArticleDAOService implementation for Article data model using Hibernate
 * 
 * @author maximusfk
 *
 */
@Repository
@Transactional
public class ArticleDAO implements IArticleDAO {

	private static final Logger logger = Logger.getLogger(ArticleDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Article> getAll(int startRow, int maxResults) {
		try {
			Session session = sessionFactory.getCurrentSession();
			List<Article> result = session.createCriteria(Article.class)
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
	public Article getById(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Article article = session.get(Article.class, id);
			return article;
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer create(Article article) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(article);
			return id;
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer update(Article article) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(article);
			return article.getId();
		} catch(HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Article article = session.get(Article.class, id);
			if(article != null) {
				session.delete(article);
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

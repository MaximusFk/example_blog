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

import com.example.blog.entity.Article;

/**
 * IArticleDAOService implementation for Article data model using Hibernate
 * @author maximusfk
 *
 */
@Repository
@ComponentScan
@Transactional
public class ArticleHibernateDAOService implements IArticleDAOService {

	private static final Logger logger = Logger.getLogger(ArticleHibernateDAOService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private static String getTableName() {
		Table table = Article.class.getAnnotation(Table.class);
		return table.name();
	}

	/* 
	 * @see com.example.blog.database.IArticleDAOService#getAll()
	 */
	@Override
	public List<Article> getAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String tableName = getTableName();
			List<Article> result = session.createQuery("FROM " + tableName).list();
			return result;
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/* 
	 * @see com.example.blog.database.IArticleDAOService#getById(java.lang.Integer)
	 */
	@Override
	public Article getById(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Article author = session.get(Article.class, id);
			return author;
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/* 
	 * @see com.example.blog.database.IArticleDAOService#create(com.example.blog.entity.Article)
	 */
	@Override
	public Integer create(Article article) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(article);
			return id;
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/* 
	 * @see com.example.blog.database.IArticleDAOService#update(com.example.blog.entity.Article)
	 */
	@Override
	public Integer update(Article article) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(article);
		}
		catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return article.getId();
	}

	/* 
	 * @see com.example.blog.database.IArticleDAOService#delete(java.lang.Integer)
	 */
	@Override
	public Boolean delete(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Article author = session.get(Article.class, id);
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

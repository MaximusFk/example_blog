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
 * Base DAO implementation for Hibernate
 * @author maximusfk
 *
 */
@Repository
@ComponentScan
@Transactional
public class ArticleHibernateDAOService implements IBaseDAOService<Article> {

	private static Logger LOGGER = Logger.getLogger(ArticleHibernateDAOService.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method return table name from @Table annotation
	 * @return table name
	 */
	private static String getTableName() {
		Table table = Article.class.getAnnotation(Table.class);
		return table.name();
	}

	@Override
	public List<Article> selectAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			String tableName = getTableName();
			List<Article> result = session.createQuery("FROM " + tableName).list();
			return result;
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Article select(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Article author = session.get(Article.class, id);
			return author;
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer create(Article entity) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Integer id = (Integer) session.save(entity);
			return id;
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer update(Article entity) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(entity);
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
		}
		return entity.getId();
	}

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
		}
		catch (HibernateException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

}

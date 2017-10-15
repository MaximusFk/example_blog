package com.example.blog.unit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.blog.database.ArticleHibernateDAOService;
import com.example.blog.entity.Article;
import com.example.blog.entity.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:hibernate_bean_test_config.xml")
@Transactional
public class ArticleHibernateDAOServiceTests {

	@Autowired
	ArticleHibernateDAOService articleDAOService;
	
	@Test
	public void testSelectAll() {
		List<Article> articles = articleDAOService.getAll();
		assertTrue(articles.size() > 0);
	}

	@Test
	public void testSelect() {
		Article article = articleDAOService.getById(1);
		assertNotNull(article);
	}

	@Test
	public void testCreate() {
		Author author = new Author(1, "Test name", "Test email");
		Article article = new Article(15, author, "Test title", "Test label", "Test text", new Date(System.currentTimeMillis()));
		Integer created_id = articleDAOService.create(article);
		assertNotNull(created_id);
	}

	@Test
	public void testUpdate() {
		Article article = articleDAOService.getById(1);
		article.setTitle("Changet test title");
		Integer id = articleDAOService.update(article);
		assertNotNull(id);
	}

	@Test
	public void testDelete() {
		Boolean deleted = articleDAOService.delete(1);
		assertNotNull(deleted);
		assertTrue(deleted);
	}

}

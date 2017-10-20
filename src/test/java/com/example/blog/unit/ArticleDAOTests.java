package com.example.blog.unit;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.blog.database.ArticleDAO;
import com.example.blog.entity.Article;
import com.example.blog.entity.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:hibernate-bean-test-config.xml")
@Transactional
public class ArticleDAOTests {

	@Autowired
	private ArticleDAO articleDAO;
	
	private static final Integer DEFAULT_ARTICLE_ID = 1;
	
	@Test
	public void testGetAll() {
		List<Article> articles = articleDAO.getAll(0, 500);
		assertTrue(articles.size() > 0);
	}

	@Test
	public void testGetById() {
		Article article = articleDAO.getById(DEFAULT_ARTICLE_ID);
		assertNotNull(article);
		System.out.println("{ARTICLE:CR}" + article.getCreatedDate().toString());
		System.out.println("{ARTICLE:MO}" + article.getModifiedDate().toString());
	}

	@Test
	public void testCreate() {
		Author author = new Author(1, "Test name", "Test email");
		Article article = new Article(null, author, "Test title", "Test label", "Test text");
		Integer created_id = articleDAO.create(article);
		assertNotNull(created_id);
	}

	@Test
	public void testUpdate() {
		Article article = articleDAO.getById(DEFAULT_ARTICLE_ID);
		article.setTitle("Changed test title");
		Integer id = articleDAO.update(article);
		assertNotNull(id);
		article = articleDAO.getById(id);
		System.out.println("{ARTICLE:CR}" + article.getCreatedDate().toString());
		System.out.println("{ARTICLE:MO}" + article.getModifiedDate().toString());
	}

	@Test
	public void testDelete() {
		boolean deleted = articleDAO.delete(DEFAULT_ARTICLE_ID);
		assertTrue(deleted);
	}

}

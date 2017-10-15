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

import com.example.blog.database.AuthorHibernateDAOService;
import com.example.blog.entity.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:hibernate_bean_test_config.xml")
@Transactional
public class AuthorHibertnateDAOServiceTests {

	@Autowired
	AuthorHibernateDAOService authorDAOService;
	
	@Test
	public void testSelectAll() {
		List<Author> authors = authorDAOService.getAll();
		assertTrue(authors.size() > 0);
	}

	@Test
	public void testSelect() {
		Author author = authorDAOService.getById(1);
		assertNotNull(author);
	}

	@Test
	public void testCreate() {
		Author author = new Author(15, "Test name", "test@email.com");
		Integer created_id = authorDAOService.create(author);
		assertNotNull(created_id);
	}

	@Test
	public void testUpdate() {
		Author author = authorDAOService.getById(1);
		author.setName("Changed test name");
		Integer id = authorDAOService.update(author);
		assertNotNull(id);
	}

	@Test
	public void testDelete() {
		Boolean deleted = authorDAOService.delete(1);
		assertNotNull(deleted);
		assertTrue(deleted);
	}

}

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

import com.example.blog.database.AuthorDAO;
import com.example.blog.entity.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:hibernate-bean-test-config.xml")
@Transactional
public class AuthorDAOTests {

	@Autowired
	private AuthorDAO authorDAO;
	
	private static final Integer DEFAULT_AUTHOR_ID = 1;
	
	@Test
	public void testGetAll() {
		List<Author> authors = authorDAO.getAll(0, 500);
		assertTrue(authors.size() > 0);
	}

	@Test
	public void testGetById() {
		Author author = authorDAO.getById(DEFAULT_AUTHOR_ID);
		assertNotNull(author);
	}

	@Test
	public void testCreate() {
		Author author = new Author(null, "Test name", "test@email.com");
		Integer created_id = authorDAO.create(author);
		assertNotNull(created_id);
	}

	@Test
	public void testUpdate() {
		Author author = authorDAO.getById(DEFAULT_AUTHOR_ID);
		author.setName("Changed test name");
		Integer id = authorDAO.update(author);
		assertNotNull(id);
	}

	@Test
	public void testDelete() {
		boolean deleted = authorDAO.delete(DEFAULT_AUTHOR_ID);
		assertTrue(deleted);
	}

}

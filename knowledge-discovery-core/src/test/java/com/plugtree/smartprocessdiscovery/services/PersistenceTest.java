package com.plugtree.smartprocessdiscovery.services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.plugtree.smartprocessdiscovery.dao.GenericDao;
import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class PersistenceTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@BeforeClass
	public static void loadSpringPersistenceContext() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testQuestionPersistance() {

		GenericDao<Question> questionDao = (GenericDao<Question>)applicationContext.getBean("questionDao");

		Assert.assertEquals(0, questionDao.listAll().size());
		
		Question question = new Question("test");
		questionDao.save(question);

		Assert.assertEquals(1, questionDao.listAll().size());

		question.setNotes("Updated");
		questionDao.update(question);
		question = questionDao.findById(question.getId());

		Assert.assertEquals("Updated", question.getNotes());

		questionDao.remove(question);

		Assert.assertEquals(0, questionDao.listAll().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCategoryPersistance() {

		GenericDao<Category> categoryDao = (GenericDao<Category>)applicationContext.getBean("categoryDao");

		Assert.assertEquals(0, categoryDao.listAll().size());
		
		Category category = new Category("Movie questions");
		category.setRank(5);
		categoryDao.save(category);

		Assert.assertEquals(1, categoryDao.listAll().size());

		int UPDATED_VALUE = 4;
		
		category.setRank(UPDATED_VALUE);
		categoryDao.update(category);
		
		category = categoryDao.findById(category.getId());

		Assert.assertEquals(UPDATED_VALUE, category.getRank());

		categoryDao.remove(category);

		Assert.assertEquals(0, categoryDao.listAll().size());
	}
}

package com.plugtree.smartprocessdiscovery.services;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.plugtree.smartprocessdiscovery.dao.GenericDao;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class PersistenceTest {

	//TODO: Improve
    @SuppressWarnings("unchecked")
	@Test
    public void loadSpringPersistenceContext() throws SystemException, NotSupportedException, RollbackException, HeuristicRollbackException, HeuristicMixedException {
        
    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
		GenericDao<Question> questionDao = (GenericDao<Question>)applicationContext.getBean("questionDao");
        
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
}

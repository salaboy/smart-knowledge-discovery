package com.plugtree.smartprocessdiscovery.services;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.dao.GenericDao;

/**
 * creation date: 2/23/11
 */
public class PersistenceServicesTest {

    @Test
    public void loadSpringPersistenceContext() throws SystemException, NotSupportedException, RollbackException, HeuristicRollbackException, HeuristicMixedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
        GenericDao<Question> questionService = (GenericDao<Question>) applicationContext.getBean("questionService");
        Question question = new Question("test");
        questionService.save(question);
        Assert.assertEquals(1, questionService.listAll().size());
        question.setNotes("Updated");
        questionService.update(question);
        question = questionService.findById(question.getId());
        Assert.assertEquals("Updated", question.getNotes());
        
        questionService.remove(question);
        Assert.assertEquals(0, questionService.listAll().size());
    }
}

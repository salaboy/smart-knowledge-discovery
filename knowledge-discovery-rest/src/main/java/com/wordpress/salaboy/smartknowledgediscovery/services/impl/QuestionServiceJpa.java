package com.wordpress.salaboy.smartknowledgediscovery.services.impl;

import com.wordpress.salaboy.smartknowledgediscovery.services.QuestionService;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * creation date: 2/23/11
 */
public class QuestionServiceJpa implements QuestionService {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Question question) {
        entityManager.persist(question);
    }

    public Question findById(Long id) {
        return entityManager.find(Question.class, id); 
    }

    public List<Question> listAll() {
        return entityManager.createQuery("SELECT q FROM Question q").getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

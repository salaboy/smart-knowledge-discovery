package com.wordpress.salaboy.smartknowledgediscovery.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wordpress.salaboy.smartknowledgediscovery.services.QuestionService;
import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

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

	public void removeById(Long id) {
		this.entityManager.remove(id);		
	}

	public void update(Question question) {
		Question oldQuestion = findById(question.getId());
		oldQuestion.setNotes(question.getNotes());
		oldQuestion.setText(question.getText());
		oldQuestion.setCategories(question.getCategories());
		oldQuestion.setTags(question.getTags());		
	}
}

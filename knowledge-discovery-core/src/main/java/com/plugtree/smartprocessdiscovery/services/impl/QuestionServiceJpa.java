package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;
import com.plugtree.smartprocessdiscovery.services.QuestionService;

/**
 * creation date: 2/23/11
 */
public class QuestionServiceJpa extends EntityServiceJpa<Question> {

    @Override
    public Class<Question> getPersistedClass() {
        return Question.class;
    }
}

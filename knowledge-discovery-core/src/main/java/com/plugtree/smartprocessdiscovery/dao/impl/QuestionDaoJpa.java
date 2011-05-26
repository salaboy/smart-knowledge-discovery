package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

/**
 * creation date: 2/23/11
 */
public class QuestionDaoJpa extends GenericDaoJpa<Question> {

    @Override
    public Class<Question> getPersistedClass() {
        return Question.class;
    }
}

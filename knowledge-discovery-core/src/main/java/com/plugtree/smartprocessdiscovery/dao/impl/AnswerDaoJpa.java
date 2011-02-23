package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.dao.AnswerDao;
import com.plugtree.smartprocessdiscovery.model.questionaire.Answer;

/**
 * creation date: 2/23/11
 */
public class AnswerDaoJpa extends GenericDaoJpa<Answer> implements AnswerDao {

    @Override
    public Class<Answer> getPersistedClass() {
        return Answer.class;
    }
}

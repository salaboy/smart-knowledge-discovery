package com.plugtree.smartprocessdiscovery.services.impl;

import com.worpdress.salaboy.smartprocessdiscovery.model.questionaire.Question;

/**
 * creation date: 2/23/11
 */
public class QuestionServiceJpa extends EntityServiceJpa<Question> {

    @Override
    public Class<Question> getPersistedClass() {
        return Question.class;
    }
}

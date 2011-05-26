package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.model.questionaire.AnsweredQuestionnaire;

/**
 * creation date: 2/23/11
 */
public class AnsweredQuestionnaireDaoJpa extends GenericDaoJpa<AnsweredQuestionnaire> {

    @Override
    public Class<AnsweredQuestionnaire> getPersistedClass() {
        return AnsweredQuestionnaire.class;
    }
}

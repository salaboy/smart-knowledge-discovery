package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

/**
 * creation date: 2/23/11
 */
public class QuestionnaireDaoJpa extends GenericDaoJpa<Questionnaire> {

    @Override
    public Class<Questionnaire> getPersistedClass() {
        return Questionnaire.class;
    }
}

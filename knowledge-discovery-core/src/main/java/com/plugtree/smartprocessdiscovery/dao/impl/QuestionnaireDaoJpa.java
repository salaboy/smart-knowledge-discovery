package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.dao.QuestionnaireDao;
import com.plugtree.smartprocessdiscovery.model.questionaire.Questionnaire;

/**
 * creation date: 2/23/11
 */
public class QuestionnaireDaoJpa extends GenericDaoJpa<Questionnaire> implements QuestionnaireDao {

    @Override
    public Class<Questionnaire> getPersistedClass() {
        return Questionnaire.class;
    }
}

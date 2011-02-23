package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.dao.InterviewDao;
import com.plugtree.smartprocessdiscovery.model.process.Interview;

/**
 * creation date: 2/23/11
 */
public class InterviewDaoJpa extends GenericDaoJpa<Interview> implements InterviewDao {

    @Override
    public Class<Interview> getPersistedClass() {
        return Interview.class;
    }
}

package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.model.process.Person;

/**
 * creation date: 2/23/11
 */
public class PersonDaoJpa extends GenericDaoJpa<Person> {

    @Override
    public Class<Person> getPersistedClass() {
        return Person.class;
    }
}

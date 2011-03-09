package com.plugtree.smartprocessdiscovery.dao.impl;


public class TagDaoJpa extends GenericDaoJpa<String> {

    @Override
    public Class<String> getPersistedClass() {
        return String.class;
    }
}


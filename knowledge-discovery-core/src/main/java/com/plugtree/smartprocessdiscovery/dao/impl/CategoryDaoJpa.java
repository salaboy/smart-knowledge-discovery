package com.plugtree.smartprocessdiscovery.dao.impl;

import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryDaoJpa extends GenericDaoJpa<Category> {

    @Override
    public Class<Category> getPersistedClass() {
        return Category.class;
    }
}

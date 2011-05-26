package com.plugtree.smartprocessdiscovery.services.impl;

import java.util.List;

import com.plugtree.smartprocessdiscovery.dao.GenericDao;
import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.services.Repository;
import com.plugtree.smartprocessdiscovery.services.RepositoryException;

public class CategoryRepositoryImpl implements Repository<Category> {

	private GenericDao<Category> categoryDao;
	
	@Override
	public List<Category> findAll() {
		return getCategoryDao().listAll();
	}

	@Override
	public List<Category> findAllWithFilter(String filter) {
		return getCategoryDao().listWithFilter(filter);
	}

	@Override
	public Long add(Category category) {
		getCategoryDao().save(category);
		
		return category.getId();
	}

	@Override
	public boolean remove(Long id) throws RepositoryException {
		
		Category category = getCategoryDao().findById(id);
		if(category == null) {
			throw new RepositoryException("Category doesn't exist");
		}
		
		getCategoryDao().remove(category);
				
		return true;
	}

	@Override
	public boolean update(Category category) throws RepositoryException {

		getCategoryDao().update(category);
		
		return true;
	}

	@Override
	public Category get(Long id) {
		return getCategoryDao().findById(id);
	}

	public void setCategoryDao(GenericDao<Category> categoryDao) {
		this.categoryDao = categoryDao;
	}

	public GenericDao<Category> getCategoryDao() {
		return categoryDao;
	}
}

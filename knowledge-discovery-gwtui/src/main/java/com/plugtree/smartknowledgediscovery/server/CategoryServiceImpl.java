package com.plugtree.smartknowledgediscovery.server;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.plugtree.smartknowledgediscovery.client.services.CategoryService;
import com.plugtree.smartprocessdiscovery.model.common.Category;
import com.plugtree.smartprocessdiscovery.services.RepositoryException;
import com.plugtree.smartprocessdiscovery.services.impl.CategoryRepositoryImpl;

@SuppressWarnings("serial")
public class CategoryServiceImpl extends RemoteServiceServlet implements CategoryService {

	private CategoryRepositoryImpl categoryRepository;
	
	public CategoryServiceImpl() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
		categoryRepository = (CategoryRepositoryImpl) applicationContext.getBean("categoryService");
	}
	
	@Override
    public List<Category> fetch() {
		return categoryRepository.findAll();
    }

    @Override
    public List<Category> fetchWithFilter(String filter) {
    	return categoryRepository.findAllWithFilter(filter);
    }

    @Override
    public List<Category> add(Category category) {
    	
    	categoryRepository.add(category);
        
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> remove(Long categoryId) {

        try {
			categoryRepository.remove(categoryId);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
        
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> update(Category category) {

    	try {
			categoryRepository.update(category);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
        
        return categoryRepository.findAll();    
    }

	@Override
	public Category get(Long categoryId) {
		return categoryRepository.get(categoryId);
	}
}
    
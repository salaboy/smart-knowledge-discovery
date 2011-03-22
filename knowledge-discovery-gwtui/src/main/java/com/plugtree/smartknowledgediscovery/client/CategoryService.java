package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.plugtree.smartprocessdiscovery.model.common.Category;

public interface CategoryService extends RemoteService {

    List<Category> fetch();

    List<Category> fetchWithFilter(String filter);

    List<Category> add(Category category);
    
    List<Category> remove(Long categoryId) ;
    
    List<Category> update(Category category) ;    
}

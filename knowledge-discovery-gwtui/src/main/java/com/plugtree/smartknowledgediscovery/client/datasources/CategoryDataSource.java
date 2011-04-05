package com.plugtree.smartknowledgediscovery.client.datasources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.plugtree.smartknowledgediscovery.client.services.CategoryServiceAsync;
import com.plugtree.smartknowledgediscovery.client.services.CategoryService;
import com.plugtree.smartknowledgediscovery.client.utils.Field;
import com.plugtree.smartknowledgediscovery.client.utils.GenericAsyncCallback;
import com.plugtree.smartknowledgediscovery.client.utils.IntegerValidator;
import com.plugtree.smartknowledgediscovery.client.utils.KeyField;
import com.plugtree.smartknowledgediscovery.client.utils.StringValidator;
import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryDataSource extends GenericDataSource<Category> {

    private CategoryServiceAsync service;

    private static CategoryDataSource instance = null;
    
    public static CategoryDataSource getInstance() {

        if (instance == null) {
            instance = new CategoryDataSource();
        }
        
        return instance;
    }
    
    private CategoryDataSource() {

        service = GWT.create(CategoryService.class);
        ((ServiceDefTarget)service).setServiceEntryPoint(GWT.getModuleBaseURL() + "category");

        fetch();
        
        Field idField = new KeyField("Id");
        Field nameField = new Field("Name", new StringValidator(true, 200));
        Field rankField = new Field("Rank", new IntegerValidator(true, 2));

        addField(idField);
        addField(nameField);
        addField(rankField);
    }

    @Override
    public boolean fetch() {

        service.fetch(new GenericAsyncCallback<Category>(getTableList()));

        return false;
    }

    @Override
    public boolean fetchWithFilter(String filter) {

        service.fetchWithFilter(filter, new GenericAsyncCallback<Category>(getTableList()));

        return false;
    }

    @Override
    public boolean add(Category category) {

        service.add(category, new GenericAsyncCallback<Category>(getTableList()));

        return false;
    }

    @Override
    public boolean remove(long id) {

        service.remove(id, new GenericAsyncCallback<Category>(getTableList()));

        return false;
    }

    @Override
    public boolean update(Category category) {

        service.update(category, new GenericAsyncCallback<Category>(getTableList()));

        return false;
    }
}

package com.plugtree.smartknowledgediscovery.client;

import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryDataSource extends GenericDataSource<Category> {

    private static CategoryDataSource instance = null;
    
    public static CategoryDataSource getInstance() {

        if (instance == null) {
            instance = new CategoryDataSource();
        }
        
        return instance;
    }
    
    private CategoryDataSource() {

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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fetchWithFilter(String filter) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean add(Category element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Category element) {
        // TODO Auto-generated method stub
        return false;
    }
}

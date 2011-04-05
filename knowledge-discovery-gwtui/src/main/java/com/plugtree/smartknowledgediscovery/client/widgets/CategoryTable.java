package com.plugtree.smartknowledgediscovery.client.widgets;

import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.plugtree.smartknowledgediscovery.client.datasources.CategoryDataSource;
import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryTable extends SmartTable<Category> {

    public CategoryTable() {
        super("Categories", CategoryDataSource.getInstance());
    }

    @Override
    void addRows(List<Category> categoryList) {
        
        int row = 2;

        for (final Category category : categoryList) {

            Button removeButton = createRemoveButton(category.getId());
            Button editButton = createEditButton(category);

            setText(row, 0, Long.toString(category.getId()));
            setText(row, 1, category.getName());
            setText(row, 2, String.valueOf(category.getRank()));
            setWidget(row, 3, removeButton);
            setWidget(row, 4, editButton);

            getCellFormatter().addStyleName(row, 3, "buttonColumn");
            getCellFormatter().addStyleName(row, 4, "buttonColumn");

            row++;
        }
    }

    private Button createEditButton(Category category) {
        // TODO Auto-generated method stub
        return new Button("edit");
    }

    private Button createRemoveButton(Long id) {
        // TODO Auto-generated method stub
        return new Button("x");
    }
}

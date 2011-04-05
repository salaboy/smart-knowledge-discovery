package com.plugtree.smartknowledgediscovery.client.widgets;

import com.plugtree.smartknowledgediscovery.client.datasources.CategoryDataSource;
import com.plugtree.smartprocessdiscovery.model.common.Category;


public class CategoryForm  extends Form<Category> {
    
    private boolean isEditForm = false;

    public CategoryForm(Category category) {

        if (category != null) {
            isEditForm = true;
        }

        setUp(CategoryDataSource.getInstance(), isEditForm);

        if (category != null) {
            data.get("Id").setText(category.getId().toString());
            data.get("Name").setText(category.getName());
            data.get("Rank").setText(String.valueOf(category.getRank()));
        }
    }

    public Category getCategory() {

        Category category = new Category();

        if (isEditForm) {
            category.setId(Long.parseLong(data.get("Id").getText()));
        }

        category.setName(data.get("Name").getText());
        category.setRank(Integer.valueOf(data.get("Rank").getText()));

        return category;
    }
}

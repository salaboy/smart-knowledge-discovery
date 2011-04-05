package com.plugtree.smartknowledgediscovery.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.plugtree.smartknowledgediscovery.client.datasources.CategoryDataSource;
import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryDialog extends PopupPanel {

    private VerticalPanel popupContent = new VerticalPanel();

    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private Button addEditButton = new Button();
    private Button cancelButton = new Button("Cancel");

    public CategoryDialog(final Category category) {

        final CategoryDataSource categoryDataSource = CategoryDataSource.getInstance();
        final CategoryForm categoryForm = new CategoryForm(category);

        if (category == null) {
            addEditButton.setText("Add");
        } else {
            addEditButton.setText("Edit");
        }

        buttonPanel.add(addEditButton);
        buttonPanel.add(cancelButton);

        addEditButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                if (categoryForm.isDataValid()) {
                    Category newCategory = categoryForm.getCategory();

                    if (category == null) {
                        categoryDataSource.add(newCategory);
                    } else {
                        categoryDataSource.update(newCategory);
                    }

                    hide();
                } else {
                    //Add an error dialog.
                    for( String error : categoryForm.getValidationErrors()) {
                        System.out.println(error);
                    }
                }
            }
        });

        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                hide(); 
            }
        });

        popupContent.add(categoryForm);
        popupContent.add(buttonPanel);

        setWidget(popupContent);

        addStyle();
    }

    private void addStyle() {
        addEditButton.addStyleName("button");
        cancelButton.addStyleName("button");

        center();
    }
}

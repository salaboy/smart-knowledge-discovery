package com.plugtree.smartknowledgediscovery.client.mainviews;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.plugtree.smartknowledgediscovery.client.datasources.CategoryDataSource;
import com.plugtree.smartknowledgediscovery.client.services.CategoryService;
import com.plugtree.smartknowledgediscovery.client.services.CategoryServiceAsync;
import com.plugtree.smartknowledgediscovery.client.widgets.CategoryDialog;
import com.plugtree.smartknowledgediscovery.client.widgets.CategoryTable;
import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryPanel extends VerticalPanel {

	private Button addButton = new Button("Add");
	private Button editButton = new Button("Edit");
	private Button removeButton = new Button("Remove");

	private HorizontalPanel buttonPanel = new HorizontalPanel();

	private CategoryTable categoryTable = new CategoryTable();
	
	private CategoryServiceAsync service;
	
	public CategoryPanel() {

		service = GWT.create(CategoryService.class);
        ((ServiceDefTarget)service).setServiceEntryPoint(GWT.getModuleBaseURL() + "category");
		
		add(categoryTable);

		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(editButton);

		add(buttonPanel);

		addButtonHandlers();

		addStyle();
	}
	private void addButtonHandlers() {

		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) { 
				CategoryDialog.createAddDialog().show();
			}
		});
		
		removeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				List<Long> selectedIdList = categoryTable.getSelectedIds();

				if (selectedIdList.size() == 0) {
					Window.alert("No rows selected.");
				}
				
				for(Long selectedId : selectedIdList) {
					CategoryDataSource.getInstance().remove(selectedId);
				}
			}
		});
		
		editButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				List<Long> selectedIdList = categoryTable.getSelectedIds();

				if (selectedIdList.size() == 0) {
					Window.alert("No rows selected.");
				} else if (selectedIdList.size() > 1) {
					Window.alert("You can edit only one row at the time");
				}

				if (selectedIdList.size() == 1) {
					Long selectedId = selectedIdList.get(0);

					service.get(selectedId, new AsyncCallback<Category>() {

						@Override
						public void onSuccess(Category category) {
							CategoryDialog.createEditDialog(category).show();
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Problem connection to the server.");
						}
					});
				}
			}
		});
	}
	private void addStyle() {
		addButton.addStyleName("button");
	}
}

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
import com.plugtree.smartknowledgediscovery.client.datasources.QuestionDataSource;
import com.plugtree.smartknowledgediscovery.client.services.QuestionService;
import com.plugtree.smartknowledgediscovery.client.services.QuestionServiceAsync;
import com.plugtree.smartknowledgediscovery.client.utils.FilterBox;
import com.plugtree.smartknowledgediscovery.client.widgets.QuestionDialog;
import com.plugtree.smartknowledgediscovery.client.widgets.QuestionTable;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionPanel extends HorizontalPanel {

	private Button addButton = new Button("Add");
	private Button editButton = new Button("Edit");
	private Button removeButton = new Button("Remove");

	private QuestionServiceAsync service;

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel buttonPanel = new HorizontalPanel();

	private QuestionTable questionTable = new QuestionTable();

	public QuestionPanel() {

		service = GWT.create(QuestionService.class);
		((ServiceDefTarget)service).setServiceEntryPoint(GWT.getModuleBaseURL() + "question");

		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(editButton);
		buttonPanel.setSpacing(3);

		vPanel.add(questionTable);
		vPanel.add(buttonPanel);

		add(vPanel);
		add(new FilterBox(QuestionDataSource.getInstance()));

		addButtonHandlers();
		addStyle();
	}

	private void addButtonHandlers() {

		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				QuestionDialog questionDialog = QuestionDialog.createAddDialog();
				questionDialog.show();
				questionTable.getSelectedIds().clear();
			}
		});

		removeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				List<Long> selectedIdList = questionTable.getSelectedIds();

				if (selectedIdList.size() == 0) {
					Window.alert("No rows selected.");
				}
				
				for(Long selectedId : selectedIdList) {
					QuestionDataSource.getInstance().remove(selectedId);
				}	
			}
		});

		editButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				List<Long> selectedIdList = questionTable.getSelectedIds();

				if (selectedIdList.size() == 0) {
					Window.alert("No rows selected.");
				} else if (selectedIdList.size() > 1) {
					Window.alert("You can edit only one row at the time");
				}

				if (selectedIdList.size() == 1) {
					Long selectedId = selectedIdList.get(0);

					service.get(selectedId, new AsyncCallback<Question>() {

						@Override
						public void onSuccess(Question question) {
							questionTable.getSelectedIds().clear();
							QuestionDialog.createEditDialog(question).show();
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


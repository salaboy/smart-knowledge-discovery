package com.plugtree.smartknowledgediscovery.client.mainviews;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class QuestionnairePanel extends HorizontalPanel {

    private Button addButton = new Button("Add");
    private VerticalPanel vPanel = new VerticalPanel();

	public QuestionnairePanel() {
		vPanel.add(new HTML("###Questionnaire CRUD under Construction###"));
		add(vPanel);
		
		/*
	    QuestionTable questionTable = new QuestionTable();
		vPanel.add(questionTable);
		vPanel.add(addButton);

		add(vPanel);
		add(new FilterBox(QuestionDataSource.getInstance()));

		addButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				QuestionDialog questionDialog = new QuestionDialog(null);
				questionDialog.show();
			}
		});
		 */
		addStyle();
	}

	private void addStyle() {
		addButton.addStyleName("button");
	}
}

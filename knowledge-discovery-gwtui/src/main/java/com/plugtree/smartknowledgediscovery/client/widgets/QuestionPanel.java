package com.plugtree.smartknowledgediscovery.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.plugtree.smartknowledgediscovery.client.datasources.QuestionDataSource;
import com.plugtree.smartknowledgediscovery.client.utils.FilterBox;

public class QuestionPanel extends HorizontalPanel {

    private Button addButton = new Button("Add");
    private VerticalPanel vPanel = new VerticalPanel();

	public QuestionPanel() {

	    QuestionTable questionTable = new QuestionTable();
		vPanel.add(questionTable);
		vPanel.add(addButton);

		add(vPanel);
		add(new FilterBox(QuestionDataSource.getInstance()));

		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				QuestionDialog questionDialog = new QuestionDialog(null);
				questionDialog.show();
			}
		});

		addStyle();
	}
	private void addStyle() {
		addButton.addStyleName("button");

	}
	
	
}

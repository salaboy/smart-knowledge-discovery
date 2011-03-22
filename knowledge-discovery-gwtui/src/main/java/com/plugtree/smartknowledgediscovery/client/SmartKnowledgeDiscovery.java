package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartKnowledgeDiscovery implements EntryPoint {

	private Button addButton = new Button("Add");
	private VerticalPanel panel = new VerticalPanel();

	@Override
    public void onModuleLoad() {

		QuestionTable questionTable = new QuestionTable();

		panel.add(questionTable);
		panel.add(addButton);

		addButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                QuestionDialog questionDialog = new QuestionDialog(null);
                questionDialog.show();
            }
        });

		RootPanel.get("mainPanel").add(panel);

		addStyle();
	}

	private void addStyle() {
	    addButton.addStyleName("button");
	}
}

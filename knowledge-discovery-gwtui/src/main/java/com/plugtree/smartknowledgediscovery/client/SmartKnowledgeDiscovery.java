package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartKnowledgeDiscovery implements EntryPoint {

	private Button addButton = new Button("Add");
	private VerticalPanel panel = new VerticalPanel();

	@Override
    public void onModuleLoad() {

		final QuestionDataSource dataSource = QuestionDataSource.getInstance();

		QuestionTable questionTable = new QuestionTable(dataSource);

		panel.add(questionTable);
		panel.add(addButton);

		addButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                QuestionDialog questionDialog = new QuestionDialog(dataSource, null);
                questionDialog.show();
            }
        });

		RootLayoutPanel.get().add(panel);

		addStyle();
	}

	private void addStyle() {
	    addButton.addStyleName("button");
	}
}

package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartKnowledgeDiscovery implements EntryPoint {

	private Button addButton = new Button("Add");

	public void onModuleLoad() {

		QuestionDataSource dataSource = new QuestionDataSource();

		QuestionTable questionTable = new QuestionTable(dataSource);

		RootLayoutPanel.get().add(questionTable);
		RootLayoutPanel.get().add(addButton);
	}
}

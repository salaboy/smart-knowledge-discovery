package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ResultPanel extends VerticalPanel {
	
	private String[] humanTaskColumnNames = {"Id", "Name", "Description"};
	private String[] systemTaskColumnNames = {"Id", "Name", "Description"};
	private String[] resourcesColumnNames = {"Id", "Resource"};

	private SmartTable humanTaskTable = new SmartTable("Human Tasks", humanTaskColumnNames);;
	private SmartTable systemTaskTable = new SmartTable("System Tasks", systemTaskColumnNames);
	private SmartTable resourcesTable = new SmartTable("Resources", resourcesColumnNames);
	
	private Button addRowHumanTask = new Button("Add Human Task");
	private Button addRowSystemTask = new Button("Add System Task");
	private Button addRowResourcesTask = new Button("Add Resource");
	
	private Button backButton = new Button("Back");
	
	public ResultPanel() {
	
		add(humanTaskTable);
		add(addRowHumanTask);
		add(systemTaskTable);
		add(addRowSystemTask);
		add(resourcesTable);
		add(addRowResourcesTask);
		add(backButton);
		
		addRowHumanTask.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				//TODO: Mostrar un popup para completar la human task, y luego al validar los datos
				//crear una nueva fila la tabla.
			}
		});
		
		//TODO: Click handler para addRowSystemTask y addResourceTask.
		
		backButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new MainPanel());
			}
		});
	}
}

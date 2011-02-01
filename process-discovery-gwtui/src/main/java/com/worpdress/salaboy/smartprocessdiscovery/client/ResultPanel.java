package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
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
	
	public ResultPanel() {
	
		add(humanTaskTable);
		add(addRowHumanTask);
		add(systemTaskTable);
		add(addRowSystemTask);
		add(resourcesTable);
		add(addRowResourcesTask);
		
		addRowHumanTask.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				try {
				TablePopUp tablePopUp = new TablePopUp(humanTaskColumnNames);
				
				tablePopUp.show();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		//TODO: Click handler para addRowSystemTask y addResourceTask.
	}
}

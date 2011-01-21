package com.example.discovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ResultPanel extends VerticalPanel {
	
	private VerticalPanel panelHumanTask = new VerticalPanel(); 
	private FlexTable humanTaskTable = new FlexTable();
	private Button addRowHumanTask = new Button("Add Human Task");
	private Label humanTaskLabel = new Label("Human Tasks");
	
	private VerticalPanel panelSystemTask = new VerticalPanel();
	private FlexTable systemTaskTable = new FlexTable();
	private Button addRowSystemTask = new Button("Add System Task");
	private Label systemTaskLabel = new Label("System Tasks");
	
	private VerticalPanel panelResources = new VerticalPanel();
	private FlexTable resourcesTable = new FlexTable();
	private Button addRowResourcesTask = new Button("Add Resource");
	private Label resourcesLabel = new Label("Resources");
	
	private Button backButton = new Button("Back");
	
	public ResultPanel() {
		
		//TODO: Ver como mergear las celdas en vez de agregar un label.
		//Permitiria crear una nueva clase y evitar todo este codigo duplicado.
		panelHumanTask.add(humanTaskLabel);
		panelHumanTask.add(humanTaskTable);
		panelHumanTask.add(addRowHumanTask);
		
		humanTaskTable.setText(0, 0, "Id");
		humanTaskTable.setText(0, 1, "Name");
		humanTaskTable.setText(0, 2, "Description");
		
		panelSystemTask.add(new Label("System Tasks"));
		panelSystemTask.add(systemTaskTable);
		panelSystemTask.add(addRowSystemTask);
		
		systemTaskTable.setText(0, 0, "Id");
		systemTaskTable.setText(0, 1, "Name");
		systemTaskTable.setText(0, 2, "Description");
		
		panelResources.add(new Label("Resources"));
		panelResources.add(resourcesTable);
		panelResources.add(addRowResourcesTask);
		
		resourcesTable.setText(0, 0, "Task ID");
		resourcesTable.setText(0, 1, "Components");
		
		add(panelHumanTask);
		add(panelSystemTask);
		add(panelResources);
		add(backButton);
		
		addRowHumanTask.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//TODO: Mostrar un popup para completar la human task, y luego al validar los datos
				//crear una nueva fila la tabla.
			}
		});
		
		//TODO: Click handler para addRowSystemTask y addResourceTask.
		
		backButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new MainPanel());
			}
		});
		
		addFormat();
	}
	
	private void addFormat() {
		
		humanTaskLabel.addStyleName("label");
		systemTaskLabel.addStyleName("label");
		resourcesLabel.addStyleName("label");
		
		humanTaskTable.getRowFormatter().addStyleName(0, "listHeader");
		systemTaskTable.getRowFormatter().addStyleName(0, "listHeader");
		resourcesTable.getRowFormatter().addStyleName(0, "listHeader");
		
		humanTaskTable.addStyleName("list");
		systemTaskTable.addStyleName("list");
		resourcesTable.addStyleName("list");	
	}
}

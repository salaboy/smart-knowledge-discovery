package com.worpdress.salaboy.smartprocessdiscovery.client;

import java.util.LinkedList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CuestionaryPanel extends HorizontalPanel {
	
	private VerticalPanel verticalPanel = new VerticalPanel();
	private Button createCuestionaryButton = new Button("Create Cuestionary");
	private Button backButton = new Button("Back");
	private FlexTable questionTable = new FlexTable();
	
	public CuestionaryPanel() {
	
		questionTable.setText(0, 0, "Select");
		questionTable.setText(0, 1, "Question");
		questionTable.setText(0, 2, "Description");
		
		verticalPanel.add(questionTable);
		verticalPanel.add(createCuestionaryButton);
		verticalPanel.add(backButton);
		
		backButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new MainPanel());
			}
		});
		
		questionTable.getRowFormatter().addStyleName(0, "listHeader");
		questionTable.addStyleName("list");
		
		add(verticalPanel);
		
		LinkedList<String> categories = new LinkedList<String>();//TODO: Hardcodeado
		categories.add("Easy");
		categories.add("Difficult");
		add(new CheckBoxList("Categories", categories));
		
		addQuestion();
	}
	
	private void addQuestion() {
		
		questionTable.setWidget(1, 0, new CheckBox());
		questionTable.setText(1, 1, "Ugis o La Continental?");
		questionTable.setText(1, 2, "Pregunta decisiva.");
	}
}

package com.worpdress.salaboy.smartprocessdiscovery.client;

import java.util.LinkedList;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CuestionaryPanel extends HorizontalPanel {
	
	private VerticalPanel verticalPanel = new VerticalPanel();
	private Button createCuestionaryButton = new Button("Create Cuestionary");
	private FlexTable questionTable = new FlexTable();
	
	public CuestionaryPanel() {
	
		questionTable.setText(0, 0, "Select");
		questionTable.setText(0, 1, "Question");
		questionTable.setText(0, 2, "Description");
		
		verticalPanel.add(questionTable);
		verticalPanel.add(createCuestionaryButton);
		
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

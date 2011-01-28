package com.worpdress.salaboy.smartprocessdiscovery.client;


import java.util.LinkedList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CrudQuestions extends HorizontalPanel {

	private VerticalPanel verticalPanel = new VerticalPanel();
	private Label questionLabel = new Label("Question:");
	private TextBox textBoxQuestion = new TextBox(); 
	private Label descriptionLabel = new Label("Description:");
	private TextArea description = new TextArea();
	private Button addQuestionButton = new Button("Add question");
	private Button backButton = new Button("Back");
	
	public CrudQuestions() {
		
		verticalPanel.add(questionLabel);
		verticalPanel.add(textBoxQuestion);
		verticalPanel.add(descriptionLabel);
		verticalPanel.add(description);
		verticalPanel.add(addQuestionButton);
		verticalPanel.add(backButton);
		
		add(verticalPanel);
		
		LinkedList<String> categories = new LinkedList<String>();//TODO: Hardcodeado
		//Hacer peticion al core por las categorias.
		categories.add("Easy");
		categories.add("Difficult");
		
		CheckBoxList checkBoxList = new CheckBoxList("Categories", categories);
		
		add(checkBoxList);

		//TODO: Nueva clase que encapsule el backButton?
		backButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new MainPanel());
			}
		});
		
		addQuestionButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				//TODO: Mandar peticion de agregar una pregunta.
				
				final PopupPanel popUp = new PopupPanel(true);
				VerticalPanel popUpContent = new VerticalPanel();
				
				Label label = new Label("The question was added.");
				Button closeButton = new Button("Close");
				
				popUpContent.add(label);
				popUpContent.add(closeButton);
				
				popUp.add(popUpContent);
				popUp.center();
				
				closeButton.addClickHandler(new ClickHandler() {
					
					public void onClick(ClickEvent event) {
						popUp.hide();
					}
				});
			}
		});
	}
}

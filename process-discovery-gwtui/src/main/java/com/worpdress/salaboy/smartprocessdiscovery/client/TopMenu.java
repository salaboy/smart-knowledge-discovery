package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class TopMenu extends HorizontalPanel {

	private Button crudQuestionsButton = new Button("Crud Questions");
	private Button createQuestionnaireButton = new Button("Create Questionnaire");
	private Button addResultButton = new Button("Add Result");

	public TopMenu() {
		
		add(crudQuestionsButton);
		add(createQuestionnaireButton);
		add(addResultButton);

		crudQuestionsButton.addStyleName("button");
		createQuestionnaireButton.addStyleName("button");
		addResultButton.addStyleName("button");

		crudQuestionsButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				changeMainPanel(new CrudQuestions());
			}
		});

		createQuestionnaireButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				changeMainPanel(new CuestionaryPanel());
			}
		});

		addResultButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				changeMainPanel(new ResultPanel());
			}
		});
	}
	
	private void changeMainPanel(Widget widget) {
		RootPanel.get().clear();
		RootPanel.get().add(widget);
	}
}

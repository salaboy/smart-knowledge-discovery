package com.example.discovery.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPanel extends VerticalPanel {

	private Button crudQuestionsButton = new Button("Crud Questions");
	private Button createQuestionnaireButton = new Button("Create Questionnaire");
	private Button addResultButton = new Button("Add Result");

	public MainPanel() {
		
		add(crudQuestionsButton);
		add(createQuestionnaireButton);
		add(addResultButton);

		crudQuestionsButton.addStyleName("button");
		createQuestionnaireButton.addStyleName("button");
		addResultButton.addStyleName("button");

		crudQuestionsButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new CrudQuestions());
			}
		});

		createQuestionnaireButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new CuestionaryPanel());
			}
		});

		addResultButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				RootPanel.get().add(new ResultPanel());
			}
		});
	}
}

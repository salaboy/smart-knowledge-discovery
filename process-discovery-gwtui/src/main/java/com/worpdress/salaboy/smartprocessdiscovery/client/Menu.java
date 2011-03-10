package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.StretchImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.worpdress.salaboy.smartprocessdiscovery.client.interview.InterviewPanel;

public class Menu extends HLayout {

	private StretchImgButton crudQuestionsButton = new IButton("Crud Questions");
	private IButton createQuestionaryButton = new IButton("Create Questionary");
	private IButton createInterviewButton = new IButton("Create Interview");
	private IButton addResultButton = new IButton("Add Result");
	private IButton crudCategoriesButton = new IButton("Crud Categories");
	private Layout southLayout;

	public Menu(Layout layout) {

		southLayout = layout;

		setMembersMargin(10);
		createQuestionaryButton.setWidth(150);

		addMember(crudQuestionsButton);
		addMember(createQuestionaryButton);
		addMember(addResultButton);
		addMember(createInterviewButton);
		addMember(crudCategoriesButton);

		crudCategoriesButton.addClickHandler( new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                changeMainPanel(new CrudCategories());
            }
        });
		
		crudQuestionsButton.addClickHandler( new ClickHandler() {

			@Override
            public void onClick(ClickEvent event) {
				changeMainPanel(new CrudQuestions());

			}
		});

		createQuestionaryButton.addClickHandler(new ClickHandler() {

			@Override
            public void onClick(ClickEvent event) {
				changeMainPanel(new CuestionaryPanel());
			}
		});

		addResultButton.addClickHandler(new ClickHandler() {

			@Override
            public void onClick(ClickEvent event) {
				changeMainPanel(new ResultPanel());
			}
		});

		createInterviewButton.addClickHandler( new ClickHandler() {

			@Override
            public void onClick(ClickEvent event) {
				changeMainPanel(new InterviewPanel());

			}
		});
	}

	private void changeMainPanel(Layout layout) {
		southLayout.removeChild(southLayout.getChildren()[0]);
		southLayout.addChild(layout);
	}
}

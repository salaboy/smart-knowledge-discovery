package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CrudQuestions extends HLayout {

	private VLayout crudLayout = new VLayout();
	private ListGrid questionList = new ListGrid();	
	private CategoryList categoryList = new CategoryList(questionList);
	
	private HLayout buttonLayout = new HLayout();
	private IButton addQuestionButton = new IButton("Add Question");
	private IButton editQuestionButton = new IButton("Edit Question");
	private IButton removeQuestionButton = new IButton("Remove Question");
	
	public CrudQuestions() {
		
		removeQuestionButton.setWidth(130);
		setMembersMargin(40);

		buttonLayout.setMembers(addQuestionButton, editQuestionButton, removeQuestionButton);
		buttonLayout.setMembersMargin(5);
	
		final DataSource QuestionListDataSource = LocalDataSource.getInstance();
		
		questionList.setDataSource(QuestionListDataSource);
		questionList.setAutoFetchData(true);
		questionList.setWidth(600);
		questionList.setHeight(200);
		questionList.setShowAllRecords(true);
		questionList.setSelectionType(SelectionStyle.SINGLE);
		
		removeQuestionButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				if (questionList.anySelected()) {
					questionList.removeSelectedData();	
				} else {
					SC.say("You have to select a question.");
				}								
			}
		});
		
		editQuestionButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				
				if (questionList.anySelected()) {
					new AddEditDialog(QuestionListDataSource, questionList).show();
				} else {
					SC.say("You have to select a question.");
				}
			}
		});
		
		addQuestionButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				new AddEditDialog(QuestionListDataSource, null).show();
			}
		});
		
		crudLayout.setMembers(questionList, buttonLayout);
		crudLayout.setMembersMargin(10);
				
		addMember(crudLayout);
		addMember(categoryList);
	}
}

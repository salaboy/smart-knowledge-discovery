package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CrudQuestions extends HLayout {

	private VLayout crudLayout = new VLayout();
	private ListGrid questionList = new ListGrid();	
	private ListGrid categoryList = new ListGrid();
	
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
		
		DataSource categoryListDataSource = new DataSource();
	    DataSourceTextField categoryNameField = new DataSourceTextField("itemCategoryName", "Filter Categories", 100, true);
	    categoryNameField.setPrimaryKey(true);
	    categoryListDataSource.addField(categoryNameField);
	    categoryListDataSource.setClientOnly(true);
	    categoryListDataSource.setTestData(new CategoryListRecord[] {new CategoryListRecord("Comida"), 
	    															 new CategoryListRecord("Futbol"),
	    															 new CategoryListRecord("IT")});
	    
	    categoryList.setDataSource(categoryListDataSource);
		categoryList.setWidth(200);
		categoryList.setHeight(100);
		categoryList.setShowAllRecords(true);
		categoryList.setAutoFetchData(true);
		categoryList.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		
		categoryList.addSelectionChangedHandler(new SelectionChangedHandler() {

			public void onSelectionChanged(SelectionEvent event) {
				
				ListGridRecord[] categories = categoryList.getSelection();
				
				String[] filterCategories = new String[categories.length];
				
				for(int i = 0; i < categories.length; i++) {
					filterCategories[i] = categories[i].getAttribute("itemCategoryName");
				}
				
				AdvancedCriteria criteria = new AdvancedCriteria("itemCategory", OperatorId.NOT_IN_SET, filterCategories);
				
				questionList.filterData(criteria);
			}
		});
		
		addMember(crudLayout);
		addMember(categoryList);
	}
}

package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CuestionaryPanel extends HLayout {
	
	private VLayout vLayout = new VLayout();
	private ListGrid questionList = new ListGrid();
	private ListGrid categoryList = new ListGrid();
	private IButton createQuestionaryButton = new IButton("Create Questionary");
	
	public CuestionaryPanel() {
	
		createQuestionaryButton.setWidth(150);
		questionList.setWidth(500);
		questionList.setHeight(200);
		questionList.setShowAllRecords(true);
		questionList.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		
		ListGridField questionField = new ListGridField("question", "Question");  
		ListGridField descriptionField = new ListGridField("description", "Description");  
		ListGridField categoryField = new ListGridField("category", "Category");  
		
		questionList.setFields(questionField, descriptionField, categoryField);  
  
		vLayout.addMember(questionList);
		vLayout.addMember(createQuestionaryButton);
		vLayout.setMembersMargin(40);
		
		addMember(vLayout);
	
		ListGridField categoryNameField = new ListGridField("category", "Categories");  

		categoryList.setFields(categoryNameField);
		categoryList.setWidth(200);
		categoryList.setHeight(100);
		categoryList.setShowAllRecords(true);
		categoryList.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		
		addMember(categoryList);
		
		setMembersMargin(40);
	}
}

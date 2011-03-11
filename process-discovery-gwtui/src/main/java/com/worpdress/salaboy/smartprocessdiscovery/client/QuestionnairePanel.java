package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire.QuestionnaireRestDS;

public class QuestionnairePanel extends HLayout {
	
	private VLayout vLayout = new VLayout();
	private ListGrid questionList = new ListGrid();
	private CategoryList categoryList = new CategoryList(questionList);
	private IButton createQuestionaryButton = new IButton("Create Questionnaire");
	
	public QuestionnairePanel() {
	
		createQuestionaryButton.setWidth(150);
		  questionList.setWidth(600);  
		  questionList.setHeight(500);  
		  questionList.setCanExpandRecords(true);  
		  questionList.setExpansionMode(ExpansionMode.DETAILS);  
		  questionList.setAutoFetchData(true);  
		  questionList.setDataSource(QuestionnaireRestDS.getInstance());  
		   
		          
		 ListGridField id = new ListGridField("id");  
		 ListGridField name = new ListGridField("name");  
		 questionList.setFields(id, name); 
		
		
		vLayout.addMember(questionList);
		vLayout.addMember(createQuestionaryButton);
		vLayout.setMembersMargin(40);
		
		addMember(vLayout);		
		addMember(categoryList);
		
		setMembersMargin(40);
	}
}

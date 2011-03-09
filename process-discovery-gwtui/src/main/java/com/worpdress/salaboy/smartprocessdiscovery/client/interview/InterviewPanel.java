package com.worpdress.salaboy.smartprocessdiscovery.client.interview;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.worpdress.salaboy.smartprocessdiscovery.client.CategoryList;
import com.worpdress.salaboy.smartprocessdiscovery.client.CrudLayout;
import com.worpdress.salaboy.smartprocessdiscovery.client.QuestionRestDS;
import com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire.AnsweredQuestionnaireRestDS;

public class InterviewPanel extends HLayout {

	private VLayout vLayout = new VLayout();
	private DataSource interviewDataSource = InterviewRestDS.getInstance();	
	private DataSource answeredQuestionnaireDataSource = AnsweredQuestionnaireRestDS.getInstance();		
	
	public InterviewPanel() {
	
		CrudLayout crudInterview = new CrudLayout(interviewDataSource, "Interview");
		CrudLayout crudAnsweredQuestionnaire = new CrudLayout(answeredQuestionnaireDataSource, "Answer");
						
		vLayout.setMembersMargin(40);
		
		addMember(vLayout);		
		addMember(crudInterview);
		addMember(crudAnsweredQuestionnaire);
		
		
		setMembersMargin(40);
	}
			
	
}

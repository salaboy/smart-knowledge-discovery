package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.data.events.DataArrivedEvent;
import com.smartgwt.client.data.events.DataArrivedHandler;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire.QuestionnaireRestDS;

public class QuestionnairePanel extends HLayout {
	private VLayout vLayout = new VLayout();
	private HLayout hLayout = new HLayout();
	private ListGrid questionList = new ListGrid();
	private CategoryList categoryList = new CategoryList(questionList);
	private IButton createQuestionnaireButton = new IButton("Create Questionnaire");
	private IButton modQuestionQuestionnaire = new IButton("Modify Question");
	private IButton remQuestionQuestionnaire = new IButton("Remove Question");	


	public QuestionnairePanel() {
		QuestionnaireRestDS questionnaireDS = QuestionnaireRestDS.getInstance();

		createQuestionnaireButton.setWidth(150);		
		questionList.setWidth(600);  
		questionList.setHeight(300);  
		questionList.setAutoFetchData(true);  
		questionList.setDataSource(questionnaireDS); 

		hLayout.addMember(modQuestionQuestionnaire);
		hLayout.addMember(remQuestionQuestionnaire);
		hLayout.addMember(createQuestionnaireButton);
		hLayout.setMembersMargin(20);


		vLayout.addMember(questionList);
		vLayout.addMember(hLayout);

		addMember(vLayout);		
		addMember(categoryList);


		setMembersMargin(40);		
		questionList.addCellDoubleClickHandler(new CellDoubleClickHandler() {

			public void onCellDoubleClick(CellDoubleClickEvent event) {
				new AddEditDialog(questionList.getDataSource(), questionList).show();

			}
		});

		remQuestionQuestionnaire.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (questionList.anySelected()) {
					questionList.removeSelectedData();	
				} else {
					SC.say("You have to select a Question from a Questionnaire .");
				}								
			}
		});

		modQuestionQuestionnaire.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				new AddEditDialog(questionList.getDataSource(), null).show();
			}
		});

		createQuestionnaireButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				new QuestionnaireEditDialog().show();
			}
		});




	}
}

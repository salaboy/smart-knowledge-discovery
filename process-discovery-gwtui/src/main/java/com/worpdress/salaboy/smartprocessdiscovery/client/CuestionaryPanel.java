package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CuestionaryPanel extends HLayout {
	
	private VLayout vLayout = new VLayout();
	private ListGrid questionList = new ListGrid();
	private CategoryList categoryList = new CategoryList(questionList);
	private IButton createQuestionaryButton = new IButton("Create Questionary");
	
	public CuestionaryPanel() {
	
		createQuestionaryButton.setWidth(150);
		questionList.setWidth(500);
		questionList.setHeight(200);
		questionList.setShowAllRecords(true);
		questionList.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		questionList.setDataSource(QuestionRestDS.getInstance());
		questionList.setAutoFetchData(true);
  
		vLayout.addMember(questionList);
		vLayout.addMember(createQuestionaryButton);
		vLayout.setMembersMargin(40);
		
		addMember(vLayout);		
		addMember(categoryList);
		
		setMembersMargin(40);
	}
}

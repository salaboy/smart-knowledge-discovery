package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.layout.HLayout;

public class CrudQuestions extends HLayout {


	public CrudQuestions() {

		DataSource questionDataSource = QuestionRestDS.getInstance();

		CrudLayout crudQuestion = new CrudLayout(questionDataSource, "Question");
		CategoryList categoryList = new CategoryList(crudQuestion.getListGrid());

		addMember(crudQuestion);
		addMember(categoryList);

		setMembersMargin(20);
	}
}

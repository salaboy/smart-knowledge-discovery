package com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class AnsweredQuestionnaireRestDS extends RestDataSource {
	private static AnsweredQuestionnaireRestDS  instance;

	public static AnsweredQuestionnaireRestDS getInstance() {

		if (instance == null) {
			instance = new AnsweredQuestionnaireRestDS(); 
		} 

		return instance;
	}

	private AnsweredQuestionnaireRestDS() {

		setID("AnsweredQuestionnaireRestDS");

		DataSourceIntegerField pkField = new DataSourceIntegerField("id");  
		pkField.setHidden(false);  
		pkField.setPrimaryKey(true);
		pkField.setCanEdit(false);

		DataSourceTextField questionField = new DataSourceTextField("questions", "Questions", 2000, true);
		DataSourceTextField answerField = new DataSourceTextField("answers", "Answers", 2000, true);		
		setFields(pkField,questionField,answerField);
		OperationBinding fetch = new OperationBinding();  
		fetch.setOperationType(DSOperationType.FETCH);  
		fetch.setDataProtocol(DSProtocol.POSTMESSAGE);  

		OperationBinding add = new OperationBinding();  
		add.setOperationType(DSOperationType.ADD);  
		add.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding update = new OperationBinding();  
		update.setOperationType(DSOperationType.UPDATE);  
		update.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding remove = new OperationBinding();  
		remove.setOperationType(DSOperationType.REMOVE);  
		remove.setDataProtocol(DSProtocol.POSTMESSAGE);

		setOperationBindings(fetch, add, update, remove);  

		setFetchDataURL("dummyHttpServlet/answeredQuestionnaire/get");
		setAddDataURL("dummyHttpServlet/answeredQuestionnaire/add");  
		setUpdateDataURL("dummyHttpServlet/answeredQuestionnaire/update");  
		setRemoveDataURL("dummyHttpServlet/answeredQuestionnaire/remove");
	}
}

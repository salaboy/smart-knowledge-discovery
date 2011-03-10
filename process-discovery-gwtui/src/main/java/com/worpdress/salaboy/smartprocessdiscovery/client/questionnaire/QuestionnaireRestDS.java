package com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire;


import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class QuestionnaireRestDS extends RestDataSource {
	private static QuestionnaireRestDS  instance;

	public static QuestionnaireRestDS getInstance() {

		if (instance == null) {
			instance = new QuestionnaireRestDS(); 
		} 

		return instance;
	}

	private QuestionnaireRestDS() {

		setID("QuestionnaireRestDS");

		DataSourceIntegerField pkField = new DataSourceIntegerField("id");  
		pkField.setHidden(false);  
		pkField.setPrimaryKey(true);
		pkField.setCanEdit(false);

		DataSourceTextField questionField = new DataSourceTextField("questions/question/text", "Questions", 2000, true);
		setFields(pkField,questionField);
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

		setFetchDataURL("dummyHttpServlet/questionnaire/get");
		setAddDataURL("dummyHttpServlet/questionnaire/add");  
		setUpdateDataURL("dummyHttpServlet/questionnaire/update");  
		setRemoveDataURL("dummyHttpServlet/questionnaire/remove");
	}
}
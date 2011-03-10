package com.worpdress.salaboy.smartprocessdiscovery.client.interview;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire.AnsweredQuestionnaireRestDS;

public class InterviewRestDS extends RestDataSource {

	private static InterviewRestDS instance;

	public static InterviewRestDS getInstance() {
		
		if (instance == null) {
			instance = new InterviewRestDS(); 
		} 
		
		return instance;
	}
	
	private InterviewRestDS() {
		
		setID("InterviewRestDS");
		
		DataSourceIntegerField pkField = new DataSourceIntegerField("id");  
		pkField.setHidden(false);  
		pkField.setPrimaryKey(true);
		pkField.setCanEdit(false);
		
		DataSourceTextField descriptionField = new DataSourceTextField("description", "Description", 2000, true);
		DataSourceIntegerField questionnaireField = new DataSourceIntegerField("/response/data/questionnaire/id","Questionnaire");
		setFields(pkField,descriptionField,questionnaireField);
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

		setFetchDataURL("dummyHttpServlet/interview/get");
		setAddDataURL("dummyHttpServlet/interview/add");  
		setUpdateDataURL("dummyHttpServlet/interview/update");  
		setRemoveDataURL("dummyHttpServlet/interview/remove");
	}
}

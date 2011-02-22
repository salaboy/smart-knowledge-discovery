package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class QuestionRestDS extends RestDataSource {

	private static QuestionRestDS instance;
	
	public static QuestionRestDS getInstance() {
		
		if (instance == null) {
			instance = new QuestionRestDS(); 
		} 
		
		return instance;
	}
	
	private QuestionRestDS() {
		
		setID("QuestionRestDS");
		
		DataSourceIntegerField pkField = new DataSourceIntegerField("id");  
		pkField.setHidden(false);  
		pkField.setPrimaryKey(true);
		pkField.setCanEdit(false);
		
		DataSourceTextField questionField = new DataSourceTextField("question", "Question", 300, true);
		DataSourceTextField descriptionField = new DataSourceTextField("description", "Description", 2000, true);
		DataSourceEnumField categoryField = new DataSourceEnumField("category", "Category", 30, true);
        
		setFields(pkField, questionField, descriptionField, categoryField);
		
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
		
		setFetchDataURL("knowledge-discovery-rest/rest/question/get");
		setAddDataURL("knowledge-discovery-rest/rest/question/add");  
		setUpdateDataURL("knowledge-discovery-rest/rest/question/update");  
		setRemoveDataURL("knowledge-discovery-rest/rest/question/remove");  
	}
}
